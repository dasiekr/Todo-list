package com.todopoject.springBoot.todolist.error;

public class ExistingEmailException extends Exception{

    @Override
    public String getMessage() {
        return "This email already exists";
    }
}
