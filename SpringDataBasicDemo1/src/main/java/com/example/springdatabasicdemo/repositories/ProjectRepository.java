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
    @Query(value = "select p " +
            " from Projects p " +
            "join Tasks ts on p.id = ts.project.id " +
            " WHERE ts.stat = 'Done' " +
            " and " +
            " p.id = (" +
            "    SELECT t.project.id" +
            "    FROM Team t" +
            "    JOIN Clerk c ON t.id = c.team.id" +
            "    GROUP BY t.project.id" +
            "    ORDER BY SUM(c.KPI) DESC" +
            "    LIMIT 1) " +
            "group by p.id " +
            "order by count(ts.id) desc limit 1",
            nativeQuery = false)
    Projects findBestProject();
//    //нужен запрос который выведет проект в котором больше всего выполненых задач и команда с самым высоким kpi
}