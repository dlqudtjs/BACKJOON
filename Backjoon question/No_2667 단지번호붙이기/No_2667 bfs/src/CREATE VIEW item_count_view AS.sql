CREATE VIEW item_count_view AS
SELECT item_id AS review_item_id, COUNT(item_id) AS review_count
FROM review
GROUP BY review_item_id;


// 사용법
SELECT review_count
FROM item_count_view
WHERE review_item_id = 5;


// 키워드 포함 되는 keyword list
CREATE VIEW item_list_by_keyword_view AS
select keyword.keyword AS input_keyword, keyword.keyword_id
from keyword
where keyword.keyword like '%keyword%'

// keyword list
CREATE VIEW keyword_list_view AS
select itemKeyword.item_id, itemKeyword.keyword_id
from itemKeyword



// 검색 item list 

CREATE VIEW item_list_by_search_view AS
item.item_id,
item.name,
item.category_id,
item.image_1,
item.content,
item.created_at,
item.updated_at,
item.price,
item.stock,
ifnull((select item_count_view.review_count
from item_count_view
where item_count_view.review_item_id = item.item_id), 0) as review_count,
ifnull((select item_avg_view.avg_rating
from item_avg_view
where item_avg_view.avg_item_id = item.item_id), 0) as avg_rating,
ifnull((select item_sales_view.sales
from item_sales_view
where item_sales_view.sales_item_id = item.item_id), 0) as sales
from item
where item.name like '%${search}%'
