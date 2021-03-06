package north.sample.domain;
//import org.postgis.Point;
import javax.persistence.*;
import java.io.Serializable;
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
    private Date date;
    /*@Column( nullable = false)
    private Point place;*/
    @Column( nullable = false)
    private double price;

    @Column( nullable = false)
    private String diagnostic;
    //诊断 results

    @Column(columnDefinition = "text", nullable = false)
    private String prescription;
    //medicament recommendees 处方


    @OneToMany(mappedBy = "consultation")
    private List<Condition> condition;
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
    /*public Point getPlace() {
        return place;
    }
    public void setPlace(Point place) {
        this.place = place;
    }*/
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
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

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }


    public long getDoctorId(long id){
        return doctor.getId();
    }

    public long getPatientId(long id){
        return patient.getId();
    }
}


