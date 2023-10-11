package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Clerk;
import com.example.springdatabasicdemo.models.Projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {

    List<Projects> findAll();
    @Query("Select c FROM Clerk c JOIN Team t on c.team.id = t.id join Projects p on  t.project.id = p.id where p.name = :projectName")
    List<Clerk> findAllClerksByProjectName(@Param("projectName") String projectName);

}