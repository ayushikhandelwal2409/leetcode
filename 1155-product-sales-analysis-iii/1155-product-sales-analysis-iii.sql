# Write your MySQL query statement below
SELECT s.product_id, s.year AS first_year, s.quantity, s.price
FROM Sales s
JOIN (
  SELECT product_id, MIN(year) AS min_year
  FROM Sales
  GROUP BY product_id
) AS min_year_sales
ON s.product_id = min_year_sales.product_id AND s.year = min_year_sales.min_year;