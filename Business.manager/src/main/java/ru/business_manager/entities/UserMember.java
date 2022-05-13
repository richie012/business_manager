package ru.business_manager.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class UserMember {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private boolean active;
    private String login;
    private String pass;

    @ElementCollection(targetClass =  Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public UserMember() {
    }

    public UserMember(String name, String login, String pass) {
        this.name = name;
        this.login = login;
        this.pass = pass;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long setId(Long id) {
        return this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
}
