package com.em.entities;

import java.time.LocalDate;

import com.em.enumerators.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "vacation_request_table")
public class VacationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vr_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee requester;

    @Column(name = "startDate")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "hr_employee_id")
    private HREmployee hrEmployee; 

    public VacationRequest(Employee requester, LocalDate startDate, LocalDate endDate, Status status, String reason) {
        this.requester = requester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.reason = reason;
    }

}