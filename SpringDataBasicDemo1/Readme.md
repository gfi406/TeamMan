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

SELECT p 
FROM 
project p 
JOIN team t ON p.id = t.project_id 
JOIN clerk c ON c.team_id = t.id 
WHERE p.id = (
select p.id from project p 
join task ts on p.id = ts.project_id
WHERE ts.stat = 'Done' 
and p.id = ( 
SELECT t.project_id FROM team t
JOIN clerk c ON t.id = c.team_id
GROUP BY t.project_id ORDER BY SUM(c.kpi)
DESC LIMIT 1) 
group by p.id 
order by count(ts.id) desc limit 1) limit 1
