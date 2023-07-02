package com.tutorial.details.springboottutorialdetail.repository;

import com.tutorial.details.springboottutorialdetail.entity.TutorialDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialDetailRepository extends JpaRepository<TutorialDetail , Long> {
    @Transactional
    void deleteById(Long id);

    @Transactional
    void deleteByTutorialId(Long tutorialId);

}
