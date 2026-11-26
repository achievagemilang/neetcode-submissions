-- Write your query below
SELECT 
    name, 
    CASE WHEN SUM(distance) > 0 THEN SUM(distance)
    ELSE 0
    END AS travelled_distance
FROM users u
LEFT JOIN rides r
    ON u.id = r.user_id
GROUP BY name
ORDER BY travelled_distance DESC, name ASC