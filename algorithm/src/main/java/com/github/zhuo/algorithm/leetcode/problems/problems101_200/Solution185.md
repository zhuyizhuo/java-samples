## 部门工资前三高的所有员工
- https://leetcode.cn/problems/department-top-three-salaries/
- 难度 困难

MYSQL:
```sql
SELECT
	d. NAME AS Department,
	e. NAME AS Employee,
	e.salary AS Salary
FROM
	Employee e,
	Department d,
(
select DISTINCT salary, departmentId, dense_rank() over(PARTITION BY departmentId order by salary desc) as 'rank'
    from employee ) c
WHERE
	e.departmentId = d.id
and e.salary = c.salary and e.departmentId = c.departmentId and c.rank < 4
;
```
