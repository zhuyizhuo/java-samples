<--
 https://leetcode.cn/problems/combine-two-tables/

编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和州。如果 personId 的地址不在 Address 表中，则报告为空  null 。

以 任意顺序 返回结果表。

-->

select firstName,lastName,city,state from person left join address on person.personId = address.personId
