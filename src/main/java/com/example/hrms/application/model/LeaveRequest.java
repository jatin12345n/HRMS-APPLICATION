package com.example.hrms.application.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String employeeName;
    private LocalDate startDate;
    private LocalDate endDate;}
