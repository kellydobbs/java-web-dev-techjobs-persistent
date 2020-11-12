## Part 1: Test it with SQL
SHOW FIELDS
FROM job

## Part 2: Test it with SQL
SELECT name
FROM employer
WHERE location = 'st.louis';

## Part 3: Test it with SQL
DROP table job

## Part 4: Test it with SQL
SELECT name,  description
FROM skill
INNER JOIN job_skills ON skill.id = job_skills.skills_id
ORDER BY name