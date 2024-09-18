# Write your MySQL query statement below
SELECT 
  ROUND(
    SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) / 
    COUNT(DISTINCT fo.customer_id) * 100, 2
  ) AS immediate_percentage
FROM 
  (
    SELECT 
      d.customer_id, 
      MIN(d.order_date) AS first_order_date
    FROM 
      Delivery d
    GROUP BY 
      d.customer_id
  ) AS fo
JOIN 
  Delivery d ON fo.customer_id = d.customer_id AND fo.first_order_date = d.order_date;