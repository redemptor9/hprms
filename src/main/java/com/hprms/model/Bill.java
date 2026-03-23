package com.hprms.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @Column(name = "bill_id")
    private String billId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private BigDecimal amount;

    @Column(name = "bill_date")
    private LocalDate date;

    private String status; // Paid, Unpaid

    public Bill() {}

    public Bill(String billId, Patient patient, BigDecimal amount, LocalDate date, String status) {
        this.billId = billId;
        this.patient = patient;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
