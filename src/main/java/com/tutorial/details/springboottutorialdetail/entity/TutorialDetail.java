package com.tutorial.details.springboottutorialdetail.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDetail {
    @Id
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdOn;

    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "tutorialId" ,referencedColumnName = "id")
    private Tutorial tutorial;
}

