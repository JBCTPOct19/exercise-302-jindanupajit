package com.jindanupajit.javabootcamp.exercise3021.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@NotNull <-- This create validation error below
    // org.springframework.validation.BeanPropertyBindingResult: 1 errors
    // Field error in object 'task' on field 'id': rejected value [null]; codes [NotNull.task.id,NotNull.id,NotNull.java.lang.Long,NotNull]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [task.id,id]; arguments []; default message [id]]; default message [must not be null]
    private Long id;

    @NotNull
    @Size(min=1, max=128)
    private String name;

    @NotNull
    private String date;

    @NotNull
    private String priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
