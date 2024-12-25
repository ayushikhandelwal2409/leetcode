# Write your MySQL query statement below
select d.name as Department, e.name as Employee ,e.salary as Salary
from Employee e left join Department d on e.departmentId=d.id
where e.salary in(
    select distinct salary from Employee e2
    where  e2.departmentId = e.departmentId
    order by salary desc
)
and (
    select count(distinct e3.salary) from Employee e3
    where e3.departmentId = e.departmentId AND e3.salary >= e.salary
)<=3;