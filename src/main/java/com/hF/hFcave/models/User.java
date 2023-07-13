package com.hF.hFcave.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "usr")
public class User {
    @Id
    private String id;

    private String name;
    private String userPic;
    private String locale;
    private String email;
    private String gender;

    @OneToMany(mappedBy = "author")
    private List<Note> notes;

    @OneToMany(mappedBy = "author")
    private List<Task> tasks;

    @OneToMany(mappedBy = "assign")
    private List<Task> assignedTasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
