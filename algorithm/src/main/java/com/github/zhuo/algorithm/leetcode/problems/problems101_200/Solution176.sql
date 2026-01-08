/*
第二高的薪水
https://leetcode.cn/problems/second-highest-salary/
难度 中等
*/

oracle:
select salary as "SecondHighestSalary" from ( select id,salary,rownum n from Employee order by salary ) where n = 2
暂未解决没有返回 null 问题

mysql:
select max(Salary) SecondHighestSalary
from Employee
where Salary < (select max(Salary) from Employee)
通用方案
