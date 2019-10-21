package com.todopoject.springBoot.todolist.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int task_id;

    private String description;

    private Date date;

    private boolean isDone;
}
