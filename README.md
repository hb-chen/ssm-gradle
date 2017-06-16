spring boot mvc mybatis shiro

#### Flyway初始化数据库
```bash
$ ./gradlew flywayMigrate
```

#### 运行
```bash
$ ./gradlew bootRun

# app模块使用以下配置
# apply plugin: 'application'
# mainClassName = 'hello.Application'
$ ./gradlew run
```

#### MyBatis Generator
```bash
$ ./gradlew mybatisGenerate
```

#### 查看tasks
```bash
$ ./gradlew tasks
```