package com.oumoi.projectmanagement.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;

    private String name;

    private String stage; // NOT STARTED, COMPLETED , INPROGRESS

    private String description;


//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private String startDate;

//    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private String  dueDate;

    private Double estimatedCost;

}
