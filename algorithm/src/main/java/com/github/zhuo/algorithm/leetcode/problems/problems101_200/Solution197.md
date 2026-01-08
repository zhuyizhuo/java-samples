## 上升的温度
- https://leetcode.cn/problems/rising-temperature/
- 难度 简单

编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。

返回结果 不要求顺序 。

```sql
select w1.id as "Id" from Weather w1 ,Weather w2
where datediff(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature
```
