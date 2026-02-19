# Write your MySQL query statement below
select 
DATE_FORMAT(trans_date, '%Y-%m') as `month`,
country,
count(*) as trans_count,
sum(state = 'approved') as approved_count,
sum(amount) as trans_total_amount,
sum((state = 'approved') * amount) as approved_total_amount
from Transactions
group by `month`, country;