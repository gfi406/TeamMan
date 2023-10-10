package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {

    List<Projects> findAll();

}