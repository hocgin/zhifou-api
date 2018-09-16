## flyway 基本命令
- Migrate `把数据库Schema迁移到最新版本`
- Clean 
- Info
- Validate
- Baseline
- Repair``

## 文件命名
```shell
# 版本迁移
V2__Add_new_table.sql

- V: 前缀
- 2: 版本号
- __: 分割
- Add_new_table: 描述
- .sql: 后缀

# 撤销迁移
U2__Add_new_table.sql

- U: 撤销前缀
- 2: 版本号
- __: 分割
- Add_new_table: 描述
- .sql: 后缀

# 可重复迁移
R__Add_new_table.sql

- R: 可重复迁移前缀
- __: 分割
- Add_new_table: 描述
- .sql: 后缀

```