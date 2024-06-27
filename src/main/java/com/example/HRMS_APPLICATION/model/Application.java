package com.example.HRMS_APPLICATION.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private String applicantName;
    private String jobTitle;
}
