package com.todopoject.springBoot.todolist.repository;

import com.todopoject.springBoot.todolist.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);


}
