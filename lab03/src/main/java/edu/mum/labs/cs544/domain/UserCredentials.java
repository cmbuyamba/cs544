package edu.mum.labs.cs544.domain;

import javax.persistence.*;

@Entity
@Table(name = "authentification")
public class UserCredentials {

    @Id
    @Column(name = "user")
    private String username;
    @Column(length = 32, nullable = false)
    private String password;
    @Transient
    private String verifyPassword;
    private Boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
