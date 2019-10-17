package com.todopoject.springBoot.todolist.error;

public class DifferentPasswordException extends Exception {

    @Override
    public String getMessage() {
        return "Entered passwords do not match";
    }
}
