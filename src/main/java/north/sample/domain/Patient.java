package north.sample.domain;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by yyou on 2016/11/14.
 */
public class Patient {
    @Id
    private Long id;
    @Column(length = 64, nullable = false, unique = true)
    private String nom;//last name
    @Column(length = 64, nullable = false)
    private String prenom;//first name
    @Column(nullable = false)
    private char sex;
    @Column(length = 10, nullable = false)
    private long telephone;
    @Column(length = 64, nullable = false)
    private String email;


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
}
