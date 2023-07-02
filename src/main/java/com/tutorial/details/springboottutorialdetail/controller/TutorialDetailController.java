package com.tutorial.details.springboottutorialdetail.controller;

import com.tutorial.details.springboottutorialdetail.entity.Tutorial;
import com.tutorial.details.springboottutorialdetail.entity.TutorialDetail;
import com.tutorial.details.springboottutorialdetail.repository.TutorialDetailRepository;
import com.tutorial.details.springboottutorialdetail.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TutorialDetailController {
    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialDetailRepository tutorialDetailRepository;

    //save tutorial details by tutorialId
    @PostMapping("/tutorials/{id}/details")
    public ResponseEntity<TutorialDetail> createTutorialDetail(@RequestBody TutorialDetail tutorialDetail,
                                                               @PathVariable Long id) throws Exception {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(()->
                new Exception("id not found"));
        tutorialDetail.setTutorial(tutorial);
        TutorialDetail tutorialDetail1 = tutorialDetailRepository.save(tutorialDetail);
        return new ResponseEntity<>(tutorialDetail1 , HttpStatus.OK);
    }

    //get tutorial details by id
    @GetMapping("/details/{id}")
    public ResponseEntity<TutorialDetail> getDetailsById(@PathVariable Long id) throws Exception {
        TutorialDetail tutorialDetail = tutorialDetailRepository.findById(id).orElseThrow(()->
                new Exception("id not found"));
        return new ResponseEntity<>(tutorialDetail , HttpStatus.OK);
    }

    //update tutorial details
    @PutMapping("/details/{id}")
    public ResponseEntity<TutorialDetail> updateTutorial(@PathVariable Long id ,
                                                         @RequestBody TutorialDetail tutorialDetail) throws Exception {
        TutorialDetail tutorialDetail1 = tutorialDetailRepository.findById(id).orElseThrow(()->
                new Exception("id not found"));
        tutorialDetail1.setCreatedBy(tutorialDetail.getCreatedBy());
        tutorialDetail1.setCreatedOn(tutorialDetail.getCreatedOn());
        TutorialDetail tutorialDetail2 = tutorialDetailRepository.save(tutorialDetail1);

        return new ResponseEntity<>(tutorialDetail2 ,HttpStatus.CREATED);
    }

    //delete details by id
    @DeleteMapping("/details/{id}")
    public ResponseEntity<HttpStatus> deleteDetailsById(@PathVariable Long id){
        tutorialDetailRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete detail by tutorial_id
    @DeleteMapping("/tutorials/{id}/details")
    public ResponseEntity<HttpStatus> deleteByTutorialId(@PathVariable Long id){
        if (!tutorialRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tutorialDetailRepository.deleteByTutorialId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
