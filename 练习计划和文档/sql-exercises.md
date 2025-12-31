# Week1 SQL 练习题（配合 product 表）

> 目标：你要做到「能写 + 能解释 + 能用 EXPLAIN 看懂基本输出」

## A. 基础 CRUD（必做）
1) 插入 3 条商品数据（不同 name/price/stock）
2) 查询所有商品，按 id 倒序
3) 按 id 查询商品
4) 把某个商品库存改为指定值（UPDATE）
5) 把某个商品下架（status=0）
6) 删除某个商品（物理删除）【了解即可；业务里多用软删】

## B. 分页与筛选（必做）
1) 查询第 1 页（10 条）
2) 查询第 2 页（10 条）
3) 查询“上架商品”（status=1），按 created_at 倒序
4) 按 name 模糊查询（LIKE '%ap% '），观察索引是否生效

## C. 聚合与统计（选做）
1) 统计上架商品数量
2) 统计库存总量（sum(stock)）

## D. 索引与 EXPLAIN（进阶）
1) 对下面查询执行 EXPLAIN，观察是否用到 idx_status / idx_name：
   - SELECT * FROM product WHERE status=1 ORDER BY id DESC LIMIT 10;
   - SELECT * FROM product WHERE name LIKE '%ap%';
2) 思考：为什么 LIKE '%xx%' 很难用上索引？怎样改写更可能用上索引？

## E. 常用参考 SQL（答案方向，不是唯一）
```sql
-- 插入
INSERT INTO product(name, price, stock, status) VALUES ('apple', 3.50, 100, 1);

-- 列表
SELECT * FROM product ORDER BY id DESC;

-- 详情
SELECT * FROM product WHERE id=1;

-- 分页
SELECT * FROM product ORDER BY id DESC LIMIT 10 OFFSET 0;

-- 更新库存
UPDATE product SET stock=80 WHERE id=1;

-- 上下架
UPDATE product SET status=0 WHERE id=1;

-- 统计
SELECT COUNT(*) FROM product WHERE status=1;
SELECT SUM(stock) FROM product;
```
