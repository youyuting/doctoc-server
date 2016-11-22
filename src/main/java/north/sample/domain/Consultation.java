package north.sample.domain;

import org.postgresql.geometric.PGpoint;
import org.postgresql.util.PGmoney;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by reva on 11/10/2016.
 */

@Entity
public class Consultation {

    @Id
    private long id;
    @ManyToOne
    Patient patient;
    @ManyToOne
    Doctor doctor;
    @Column(name = "consultation_date", nullable = false)
    private Date date;//???
    @Column( nullable = false)
    private PGpoint place;
    @Column( nullable = false)
    private PGmoney price;
    @Column(columnDefinition = "text", nullable = false)
    private String prescription;

    @Column( nullable = false)
    private String diagnostic;

    @OneToMany(mappedBy = "consultation")
    private List<Constant> constant;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public PGpoint getPlace() {
        return place;
    }
    public void setPlace(PGpoint place) {
        this.place = place;
    }
    public PGmoney getPrice() {
        return price;
    }
    public void setPrice(PGmoney price) {
        this.price = price;
    }
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public List<Constant> getConstant() {
        return constant;
    }

    public void setConstant(List<Constant> constant) {
        this.constant = constant;
    }
}


