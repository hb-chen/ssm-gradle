Spring Boot Sample 

- shiro
- mybatis
- mahout

#### 配置数据库
```bash
# env=dev
$ vi dao/src/main/java/resources/resources-dev/db-mysql.properties
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