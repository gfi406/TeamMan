package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.dtos.CountDto;
import com.example.springdatabasicdemo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@EnableJpaRepositories
public interface TeamRepository extends JpaRepository<Team,Long>
{
    List<Team> findAllByProjectName(String projectName);
    List<Team> findAll ();

    @Query("select c from Clerk c  where c.team.id =:teamId")
    List<Clerk> getAllClerkFromTeam(@Param("teamId")Long teamId );

    @Query("SELECT new com.example.springdatabasicdemo.dtos.CountDto(t.name, COUNT(c.id)) " +
            "FROM Team t LEFT JOIN t.clerks c " +
            "GROUP BY t.name")
    List<CountDto> getTeamClerksCountDto();

    @Query("select t from Team t join Clerk c on t.id = c.team.id GROUP BY t HAVING SUM(c.KPI) >= :kpi order by  SUM(c.KPI) asc limit :lim ")
    List<Team> getTopKpiTeam(@Param("kpi") int kpi,@Param("lim") int lim);


}
