SELECT  p.name AS project_name,
        t.name AS task_name,
        c.name AS clerk_name,
        tm.name AS clerk_team,
        c.kpi AS clerk_kpi
FROM project p
JOIN task t ON t.project_id = p.id  
JOIN team tm ON tm.project_id = p.id
JOIN clerk c ON c.team_id = tm.id
WHERE
    t.stat = 'Done'
    AND
    CAST(t.deadline AS date) > CURRENT_DATE - INTERVAL '2  months'
    AND
    c.kpi > 70
ORDER BY c.kpi DESC;