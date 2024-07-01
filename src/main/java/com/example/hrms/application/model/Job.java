package com.example.hrms.application.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String title;
    private String description;
}
