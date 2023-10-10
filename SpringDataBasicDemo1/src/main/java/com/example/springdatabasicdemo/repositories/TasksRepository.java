package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>
{
    @Query("SELECT t FROM Tasks t JOIN t.project p WHERE p.name = :projectName")
    List<Tasks> findAllByProjectName(@Param("projectName") String projectName);
    @Query("SELECT t FROM Tasks t WHERE EXTRACT(MONTH FROM CAST(t.deadline AS date)) = :month AND t.stat = :stat ORDER BY CAST(t.deadline AS date) ASC LIMIT :lim")
    List<Tasks> findLastDoneTasks(@Param("month") int month, @Param("stat") String stat, @Param("lim") int lim);
    //SELECT t FROM Tasks t WHERE t.stat = :stat  ORDER BY t.deadline DESC LIMIT :lim
    List<Tasks> findAll();
}
