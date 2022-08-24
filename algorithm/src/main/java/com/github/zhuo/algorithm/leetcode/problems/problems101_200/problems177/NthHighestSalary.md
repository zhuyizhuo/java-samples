
## 第 N 高的薪水
- https://leetcode.cn/problems/nth-highest-salary/
- 难度 中等
> 编写一个SQL查询来报告 Employee 表中第 n 高的工资。如果没有第 n 个最高工资，查询应该报告为 null 。

MYSQL:
```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N:=N-1;
  RETURN (
      # Write your MySQL query statement below.
    select
        salary
    from
        Employee
        group by salary
        order by salary desc
        limit n,1
  );
END
```
