package north.sample.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yyou on 2016/11/14.
 */
@Entity
public class Patient {
    @Id
    private Long id;
    @Column(length = 64, nullable = false)
    private String lastName;
    @Column(length = 64, nullable = false)
    private String firstName;
    @Column(nullable = false)
    private char sex;
    @Column(nullable = false)
    private long telephone;
    @Column(length = 64, nullable = false)
    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Antecedent> antecedents;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
