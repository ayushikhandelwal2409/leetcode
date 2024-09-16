# Write your MySQL query statement below
select e.name,b.bonus from Employee e left join Bonus b
on e.empId=b.empId
where b.bonus IS NULL or b.bonus<1000;