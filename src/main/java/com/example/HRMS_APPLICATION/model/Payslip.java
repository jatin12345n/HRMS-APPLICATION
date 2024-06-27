package com.example.HRMS_APPLICATION.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Payslip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String employeeName;
    private BigDecimal amount;}
