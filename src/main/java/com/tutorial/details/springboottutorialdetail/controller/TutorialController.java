package com.tutorial.details.springboottutorialdetail.controller;

import com.tutorial.details.springboottutorialdetail.entity.Tutorial;
import com.tutorial.details.springboottutorialdetail.repository.TutorialDetailRepository;
import com.tutorial.details.springboottutorialdetail.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialDetailRepository tutorialDetailRepository;

    //Post a new tutorial to the database
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        Tutorial tutorial1 = tutorialRepository.save(tutorial);
        return new ResponseEntity<>(tutorial1 , HttpStatus.CREATED);
    }

    //get All tutorial by title
    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorial(@RequestParam String title){
        List<Tutorial> tutorials = new ArrayList<>();
        if (title == null){
            tutorialRepository.findAll().forEach(tutorials::add);
        }else {
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
        }if (tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorials,HttpStatus.OK);
    }

    //find tutorial by id
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) throws Exception {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(
                ()-> new Exception("Tutorial with id not found")
        );
        return new ResponseEntity<>(tutorial,HttpStatus.OK);
    }

    //update tutorial
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id , @RequestBody Tutorial tutorial) throws Exception {
        Tutorial tutorial1 = tutorialRepository.findById(id).orElseThrow(
                ()-> new Exception("tutorial with id not found")
        );
        tutorial1.setTitle(tutorial.getTitle());
        tutorial1.setDescription(tutorial.getDescription());
        tutorial1.setPublished(tutorial1.getPublished());

        return new ResponseEntity<>(tutorial1 ,HttpStatus.OK);

    }

    //delete tutorial by Id
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorialById(@PathVariable Long id){
        if (!tutorialRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tutorialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete all tutorial
    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteTutorial(){
        tutorialRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //get published tutorial
    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> getPublishedTutorial(@RequestParam Boolean published){
        List<Tutorial> tutorials = tutorialRepository.findByPublished(published);
        if (tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials ,HttpStatus.OK);
    }

}
