package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClerkRepository extends JpaRepository<Clerk, Long> {
    @Query("SELECT c FROM Clerk c WHERE c.team.name = :teamName")
    List<Clerk> findAllByTeamName(@Param("teamName") String teamName);

    @Query("SELECT c FROM Clerk c ORDER BY c.KPI DESC LIMIT :lim")
    List<Clerk> findClerkByKpiOrderByKpiDesc(@Param("lim") int lim);
}
