package com.todopoject.springBoot.todolist.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int task_id;


    @Size(min = 10)
    private String description;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date targetDate;


    private String status;


    private String username;

    public Task() {
        super();
    }

    public Task(@Size(min = 10) String description, Date targetDate, String status, String username) {
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
        this.username = username;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                ", username=" + username +
                '}';
    }
}
