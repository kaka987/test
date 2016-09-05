package com.thoughtworks.toc.account.model;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Integer age;
    private String email;
    //private Set<Role> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    protected User() {}
    
    public User(String username, String email, Integer age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    public User(Long id, String username, String email, Integer age) {
        this.id = id;
    	this.username = username;
        this.email = email;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public Integer getAge() {
    	return age;
    }
    
    public void setAge(Integer age) {
    	this.age = age;
    }

    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
