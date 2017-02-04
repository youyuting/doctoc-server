package north.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by reva on 11/10/2016.
 */
@Entity
public class Antecedent {
//what's problem the patient have
    @Id
    private Long id;
    @ManyToOne
    Patient patient;
    @Column
    private String antecedentType;
    @Column(name = "antecedent_date",nullable = false)
    private Date date;
    @Column(columnDefinition = "text",nullable = false, unique = true)
    private String description;

    public Antecedent() {
    }

    public Antecedent(Long id, Patient patient, String antecedentType, Date date, String description) {
        this.id = id;
        this.patient = patient;
        this.antecedentType = antecedentType;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getAntecedentType() {
        return antecedentType;
    }

    public void setAntecedentType(String antecedentType) {
        this.antecedentType = antecedentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
