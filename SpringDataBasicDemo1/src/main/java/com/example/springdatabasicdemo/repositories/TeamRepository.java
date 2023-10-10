package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.dtos.CountDto;
import com.example.springdatabasicdemo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@EnableJpaRepositories
public interface TeamRepository extends JpaRepository<Team,Long>
{
    List<Team> findAllByProjectName(String projectName);
    List<Team> findAll ();

    @Query("SELECT new com.example.springdatabasicdemo.dtos.CountDto(t.name, COUNT(c.id)) " +
            "FROM Team t LEFT JOIN t.clerks c " +
            "GROUP BY t.name")
    List<CountDto> getTeamClerksCountDto();


}
