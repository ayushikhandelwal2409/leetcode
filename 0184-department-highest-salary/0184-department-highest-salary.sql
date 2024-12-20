# Write your MySQL query statement below
select d.name as Department, e.name as Employee,e.salary as Salary
from Employee e left join Department d
on d.id=e.departmentId
where(
    e.salary=(
        select max(salary) from employee where departmentId = e.departmentId
    ) 
)
order by d.name,e.name;
