# Write your MySQL query statement below
select tb2.email as Email from( 
    select tb1.email, count(tb1.email) as count from Person as tb1 group by email) as tb2 where tb2.count > 1 ;