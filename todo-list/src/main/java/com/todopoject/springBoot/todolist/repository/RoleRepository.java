package com.todopoject.springBoot.todolist.repository;

import com.todopoject.springBoot.todolist.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
