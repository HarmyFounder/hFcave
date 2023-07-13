package com.hF.hFcave.models;

import jakarta.persistence.*;

@Entity
public class Habit {
    @Id
    @GeneratedValue
    private Long id;

    private String tittle;
    private String tag;
    private boolean isDone ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
