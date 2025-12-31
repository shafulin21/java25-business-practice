# 今日对话总结 & 后续学习计划（Java 25 练习仓库 + MySQL 8.4.6）

日期：2025-12-25

---

## 1. 今日对话总结（你已经完成了什么）

### 环境与工具
- ✅ Windows 11 + IntelliJ IDEA 开发
- ✅ JDK 25 已安装（用于练习新特性）
- ✅ Maven 已在 IDEA 中配置为新版本（你已完成 Maven 设置）
- ✅ 使用 Maven 创建项目并成功推送到 GitHub
- ✅ 将项目从单模块改造成 **父工程（packaging=pom）+ 多模块结构**
  - business-common
  - business-domain
  - business-infrastructure
  - business-application
  - business-adapter（Spring Boot 启动模块）
- ✅ Spring Boot 成功启动并可访问接口
- ✅ MySQL 8.4.6 安装完成并已验证：
  - `select version();` 返回 `8.4.6`

### 遇到的问题与解决
- ❗ Spring Boot/Spring Framework 暂不支持直接解析 **Java 25 的 class 文件格式（major version 69）**
- ✅ 解决方式：**编译目标（maven.compiler.release）降为 21**
  - 依然可以用 JDK25 运行/开发，但字节码以 Java21 兼容格式产出
- ⚠️ 启动时出现 Tomcat Native 的警告：
  - `--enable-native-access=ALL-UNNAMED` 可消除（可选）
  - 不影响你继续练习

### 当前阶段最重要的目标
- 🎯 用 **MySQL 8.4.6** 练 SQL（建表、增删改查、索引、事务）
- 🎯 用 **Spring Boot + MyBatis** 练业务开发（分层、DTO/VO、事务、异常、统一返回）

---

## 2. 你当前项目的“推荐目标配置”

### Java / Maven
- JDK：25（用于运行与开发）
- Maven 编译 release：**21**（保证 Spring 可正常扫描）
- IDE：
  - Project SDK / Module SDK：JDK25
  - Maven home：3.9.x
  - Maven Importer JDK：JDK25（或 Project SDK）

### 数据库
- MySQL：8.4.6（已 OK）
- 推荐建一个练习库：`practice`
- 推荐表：`product`（商品表）

---

## 3. 学习计划（4 周 + 每周目标 + 每日建议）

> 核心原则：**每周做一个闭环**（能跑、能测、能用 SQL 验证）

---

### 第 0 周（已完成）✅：环境与工程结构
**你已完成：**
- JDK25 + IDEA + Maven 配置
- GitHub 仓库推送
- 多模块工程结构
- Spring Boot 跑通
- MySQL 8.4.6 安装验证

**可选优化：**
- （可选）IDEA Run 配置加 VM 参数消除 warning：
  - `--enable-native-access=ALL-UNNAMED`

---

### 第 1 周：商品 CRUD（SQL + MyBatis + 分层）
**目标：完成一个可用的商品管理模块（接口 + SQL）**

#### 你要实现的功能
1. 建库建表（product）
2. 新增商品（INSERT）
3. 查询商品（SELECT by id）
4. 商品列表分页（SELECT + LIMIT/OFFSET）
5. 更新库存（UPDATE）
6. 上下架（UPDATE）

#### 代码结构建议
- domain：`Product`
- infrastructure：`ProductMapper` + `ProductMapper.xml`
- application：`ProductService`
- adapter：`ProductController`

#### SQL 练习重点
- DDL：CREATE TABLE + INDEX
- DML：INSERT / SELECT / UPDATE
- 分页：LIMIT/OFFSET

#### 每日节奏（建议 1~1.5 小时/天）
- Day1：建库建表 + 能连上数据库
- Day2：insert + selectById
- Day3：分页 list
- Day4：updateStock + updateStatus
- Day5：补参数校验 + 返回格式
- Day6：写 3 个测试用例（正常/库存更新/非法参数）
- Day7：复盘 + 清理代码 + 写 README

---

### 第 2 周：订单下单（事务 + 状态流转）
**目标：完成下单闭环（写订单 + 扣库存），并理解事务与一致性**

#### 你要实现的功能
1. 建表：`orders`、`order_item`
2. 下单接口：写订单 + 扣库存（同一事务）
3. 查询订单
4. 取消订单：状态流转 + 回滚库存

#### 练习点
- `@Transactional`
- 订单状态枚举（NEW/PAID/CANCELLED）
- 校验（库存不足、商品不存在、订单状态不允许取消）

#### SQL 练习重点
- 多表设计
- JOIN（查询订单 + 明细）
- 事务：BEGIN/COMMIT/ROLLBACK

---

### 第 3 周：并发 & 幂等（更贴近真实业务）
**目标：把“能用”升级到“更可靠”**

#### 你要实现的功能
1. 防重复下单（幂等 key）
2. 库存扣减并发保护（乐观锁 or 悲观锁）
3. 限制库存不能扣成负数

#### SQL 练习重点
- `UPDATE ... WHERE stock >= ?`
- 行锁：`SELECT ... FOR UPDATE`
- 观察死锁/锁等待（理解即可）

---

### 第 4 周：SQL 进阶 & 性能优化（加分项）
**目标：会写 SQL + 会看执行计划 + 会加索引**

#### 练习内容
- EXPLAIN 分析慢查询
- 索引设计：联合索引、覆盖索引
- 模糊查询与索引失效
- 分页性能（深分页问题了解）

---

## 4. 里程碑验收（你每周都可以对照检查）

### Week1 验收
- [ ] 商品 CRUD 接口可用
- [ ] 能用 SQL 验证数据变化
- [ ] 代码分层清晰（Controller/Service/Mapper）
- [ ] 有基本异常处理

### Week2 验收
- [ ] 下单事务正确（写订单+扣库存）
- [ ] 取消订单能回滚库存
- [ ] 状态机基本正确

### Week3 验收
- [ ] 幂等方案能防重复
- [ ] 并发下库存不为负
- [ ] 至少写一个并发测试/压测脚本（简单即可）

### Week4 验收
- [ ] 会用 EXPLAIN
- [ ] 会根据查询加索引
- [ ] 理解常见 SQL 性能坑

---

## 5. 下一步你可以立刻做的事情（今天/明天就能开始）
1. 在 MySQL 中执行 product 建表 SQL
2. 在项目里接入 MyBatis + MySQL Driver
3. 完成 `ProductMapper + XML + Service + Controller`
4. 用 Postman/浏览器调用接口
5. 用 SQL 验证接口是否生效

---

如果你愿意，我也可以把 **第 1 周商品 CRUD 的所有代码骨架 + SQL + Postman 请求示例**整理成一个单独文档/压缩包结构。
