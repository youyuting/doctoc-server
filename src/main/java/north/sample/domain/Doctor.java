package north.sample.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yyou on 2016/11/10.
 */

@Entity
public class Doctor {

    @Id
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String nom;//last name
    @Column(length = 64, nullable = false)
    private String prenom;//first name
    @Column( nullable = false)
    private char sex;
    @Column(length = 64, nullable = false)
    private String fac;
    @Column(nullable = false)
    private Long telephone;
    @Column(length = 64, nullable = false)
    private String email;
    @Column(length = 64, nullable = false)
    private String photo;
    @Column(name="pic")
    @Lob
    private byte[] picture;

    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}
