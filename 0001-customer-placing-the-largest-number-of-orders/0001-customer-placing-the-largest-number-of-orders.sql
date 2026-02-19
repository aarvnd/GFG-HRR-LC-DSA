# Write your MySQL query statement below
Select customer_number
from Orders
group BY customer_number
order by count(*) desc
limit 1;