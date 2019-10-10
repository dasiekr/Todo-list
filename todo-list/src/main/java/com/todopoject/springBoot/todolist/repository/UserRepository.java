package com.todopoject.springBoot.todolist.repository;

import com.todopoject.springBoot.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
