package com.exam.examserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
