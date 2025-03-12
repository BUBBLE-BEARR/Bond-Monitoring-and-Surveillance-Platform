## 运行系统

### 后端运行

1、SVN(https://svn.interotc.cn/svn/FGZJCJK/branches/1.0/Code/backend/Project-Cloud)`checkOut`到工作目录
 2、导入到`Eclipse`，菜单 `File` -> `Import`，然后选择 `Maven` -> `Existing Maven Projects`，点击 `Next`> 按钮，选择工作目录，然后点击 `Finish` 按钮，即可成功导入。
 `Eclipse`会自动加载`Maven`依赖包，初次加载会比较慢（根据自身网络情况而定）

3、打开运行基础模块（启动没有先后顺序）

- ProjectGatewayApplication （网关模块 必须）
- ProjectAuthApplication    （认证模块 必须）
- ProjectSystemApplication  （系统模块 必须）
- ProjectNpddmApplication（非公开发行债模块 必须）
- ProjectMonitorApplication （监控中心 可选）
- ProjectGenApplication     （代码生成 可选）
- ProjectJobApplication     （定时任务 可选）
- ProjectFileApplication     （文件服务 可选）

### 前端运行

1、SVN(https://svn.interotc.cn/svn/FGZJCJK/branches/1.0/Code/frontend/project-ui)`checkOut`到工作目录

```bash
# 进入项目目录
cd project-ui

# 安装依赖
npm install

# 强烈建议不要用直接使用 cnpm 安装，会有各种诡异的 bug，可以通过重新指定 registry 来解决 npm 安装速度慢的问题。
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev
```

2、打开浏览器，输入：([http://localhost:80 (opens new window)](http://localhost:80)) 默认账户/密码 `admin/admin123`）
 若能正确展示登录页面，并能成功登录，菜单及页面展示正常，则表明环境搭建成功

> 提示
>
> 因为本项目是前后端完全分离的，所以需要前后端都单独启动好，才能进行访问。
>  前端安装完node后，最好设置下淘宝的镜像源，不建议使用cnpm（可能会出现奇怪的问题）

## 系统模块

~~~java
com.project     
├── project-ui              // 前端框架 [80]
├── project-gateway         // 网关模块 [8099]
├── project-auth            // 认证中心 [9200]
├── project-api             // 接口模块
│       └── project-api-system                          // 系统接口
├── project-common          // 通用模块
│       └── project-common-core                         // 核心模块
│       └── project-common-datascope                    // 权限范围
│       └── project-common-datasource                   // 多数据源
│       └── project-common-log                          // 日志记录
│       └── project-common-redis                        // 缓存服务
│       └── project-common-security                     // 安全模块
│       └── project-common-swagger                      // swagger接口文档
├── project-modules         // 业务模块
│       └── project-system                              // 系统模块       [9201]
│       └── project-gen                                 // 代码生成       [9202]
│       └── project-job                                 // 定时任务       [9203]
│       └── project-npddm                               // 非公开发行债模块 [9204]
│       └── project-file                                // 文件服务       [9300]
├── project-visual          // 图形化管理模块
│       └── project-visual-monitor                      // 监控中心       [9100]
├──pom.xml                // 公共依赖
~~~

> 请在`非公开发行债模块`编写功能代码

```java
com.project     
├── project-modules         // 业务模块
│       └── project-npddm                               // 非公开发行债模块 [9204]
```

### 系统模块之间的依赖关系

#### 网关模块

```java
com.project
├── project-gateway         // 网关模块 [8099]
dependencies(通用模块-核心模块|通用模块-缓存服务)
    com.project
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-redis                        // 缓存服务
```

#### 认证中心

```java
com.project
├── project-auth            // 认证中心 [9200]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-缓存服务|通用模块-安全模块)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
```

#### 接口模块-系统接口

```java
com.project
├── project-api             // 接口模块
│       └── project-api-system                          // 系统接口
dependencies(通用模块-核心模块)
    com.project
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
```

#### 通用模块-核心模块

```java
com.project
├── project-common          // 通用模块
│       └── project-common-core                         // 核心模块
dependencies(不依赖任何子模块) 
```

#### 通用模块-权限范围

```java
com.project
├── project-common          // 通用模块
│       └── project-common-datascope                    // 权限范围
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-缓存服务|通用模块-安全模块)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
```

#### 通用模块-多数据源

```java
com.project
├── project-common          // 通用模块
│       └── project-common-datasource                   // 多数据源
dependencies(不依赖任何子模块)
```

#### 通用模块-日志记录

```java
com.project
├── project-common          // 通用模块
│       └── project-common-log                          // 日志记录
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-缓存服务|通用模块-安全模块)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
```

#### 通用模块-缓存服务

```java
com.project
├── project-common          // 通用模块
│       └── project-common-redis                        // 缓存服务
dependencies(通用模块-核心模块)
    com.project
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
```

#### 通用模块-安全模块

```java
com.project
├── project-common          // 通用模块
│       └── project-common-security                     // 安全模块
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-缓存服务)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-redis                        // 缓存服务
```

#### 通用模块-swagger接口文档

```java
com.project
├── project-common          // 通用模块
│       └── project-common-swagger                      // swagger接口文档
dependencies(不依赖任何子模块)
```

#### 业务模块-系统模块

```java
com.project
├── project-modules         // 业务模块
│       └── project-system                              // 系统模块       [9201]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-权限范围|通用模块-多数据源|通用模块-日志记录|通用模块-缓存服务|通用模块-安全模块|通用模块-swagger接口文档)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-datascope                    // 权限范围
    │       └── project-common-datasource                   // 多数据源
    │       └── project-common-log                          // 日志记录
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
    │       └── project-common-swagger                      // swagger接口文档
```

#### 业务模块-代码生成

```java
com.project
├── project-modules         // 业务模块
│       └── project-gen                                 // 代码生成       [9202]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-日志记录|通用模块-缓存服务|通用模块-安全模块|通用模块-swagger接口文档)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-log                          // 日志记录
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
    │       └── project-common-swagger                      // swagger接口文档
```

#### 业务模块-定时任务

```java
com.project
├── project-modules         // 业务模块
│       └── project-job                                 // 定时任务       [9203]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-日志记录|通用模块-缓存服务|通用模块-安全模块|通用模块-swagger接口文档)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-log                          // 日志记录
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
    │       └── project-common-swagger                      // swagger接口文档
```

#### 业务模块-非公开发行债模块

```java
com.project
├── project-modules         // 业务模块
│       └── project-npddm                               // 非公开发行债模块 [9204]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-权限范围|通用模块-多数据源|通用模块-日志记录|通用模块-缓存服务|通用模块-安全模块|通用模块-swagger接口文档)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-datascope                    // 权限范围
    │       └── project-common-datasource                   // 多数据源
    │       └── project-common-log                          // 日志记录
    │       └── project-common-redis                        // 缓存服务
    │       └── project-common-security                     // 安全模块
    │       └── project-common-swagger                      // swagger接口文档
```

#### 业务模块-文件服务

```java
com.project
├── project-modules         // 业务模块
│       └── project-file                                // 文件服务       [9300]
dependencies(接口模块-系统接口|通用模块-核心模块|通用模块-swagger接口文档)
    com.project
    ├── project-api             // 接口模块
    │       └── project-api-system                          // 系统接口
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
    │       └── project-common-swagger                      // swagger接口文档
```

#### 图形化管理模块-监控中心

```java
com.project
├── project-visual          // 图形化管理模块
│       └── project-visual-monitor                      // 监控中心       [9100]
dependencies(通用模块-核心模块)
    com.project
    ├── project-common          // 通用模块
    │       └── project-common-core                         // 核心模块
```

### 软件说明：

#### 服务器IP：10.0.25.30

| 软件            | 版本             | 端口                     | 用户名/密码  | 备注                                                         |
| --------------- | ---------------- | ------------------------ | ------------ | ------------------------------------------------------------ |
| OpenJDK         | 1.8.0_302        | 无                       | 无           | OpenJDK1.8                                                   |
| Node            | v12.22.8         | 无                       | 无           | NodeJs运行时环境                                             |
| Npm             | 6.14.15          | 无                       | 无           | Npm包管理工具                                                |
| Maven           | 3.6.3            | 无                       | 无           | Apache Maven 包管理及打包工具                                |
| Nginx           | 1.21.3           | 80<br />9015             | 无           | Web服务器及反向代理                                          |
| Jenkins         | 2.323-1.1.noarch | 9999                     | 等分配       | 持续集成工具<br />使用流水线即代码方式持续集成项目<br />1、从SVN拉取源代码<br />2、Maven 构建，制品上传到Artifactory<br />3、启动 Sonarqube 代码静态扫描<br />4、启动 YAPI 接口测试<br />5、启动 Selenium UI 自动化测试<br />6、使用Ansible Playbook部署微服务 |
| Redis           | 5.0.5            | 6379                     | 无           | 分布式缓存                                                   |
| MySQL           | 8.0.27           | 3307                     | root/root123 | MySQL8 WITH CTE查询效率更高                                  |
| JIRA            | 8.12.0           | 8080                     | 等分配       | 需求管理工具<br />建立需求任务<br />分配开发任务<br />构建时可以关联需求ID |
| Nacos           | 2.0.3            | 8848<br />9848<br />9849 | nacos/nacos  | 服务注册中心及配置中心                                       |
| Artifactory-OSS | 6.18.1           | 9083                     | 等分配       | 制品管理库<br />开源版仅支持Maven等有限制品库<br />企业版全语言支持 |
| Artifactory-JCR | 7.4.3            | 9381<br />9382           |              | Docker镜像、Helm包仓库管理中心                               |
| Sonarqube       |                  | 9000                     |              | 代码规约、扫描工具                                           |
| YAPI            |                  | 3100                     | 等分配       | 接口测试工具                                                 |
| mongo           | latest           | 27017                    | 等分配       | 为YAPI的数据库服务                                           |
|                 |                  |                          |              |                                                              |

#### Nacos

`http://172.16.101.109:8848/nacos`

#### Artifactory-OSS

制品管理工具-开源版本-管理Maven私服

##### Maven私服配置

虚拟库中集成了本地库和远程库(https://repo1.maven.org/maven2/)

本地Maven settings.xml配置如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <servers>
    <server>
      <username>admin</username>
      <password>YangArtifactory1990</password>
      <id>central</id>
    </server>
    <server>
      <username>admin</username>
      <password>YangArtifactory1990</password>
      <id>snapshots</id>
    </server>
  </servers>
  <profiles>
    <profile>
      <repositories>
        <repository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>libs-release</name>
          <url>http://10.0.25.30:9083/artifactory/libs-release</url>
        </repository>
        <repository>
          <snapshots />
          <id>snapshots</id>
          <name>libs-snapshot</name>
          <url>http://10.0.25.30:9083/artifactory/libs-snapshot</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>libs-release</name>
          <url>http://10.0.25.30:9083/artifactory/libs-release</url>
        </pluginRepository>
        <pluginRepository>
          <snapshots />
          <id>snapshots</id>
          <name>libs-snapshot</name>
          <url>http://10.0.25.30:9083/artifactory/libs-snapshot</url>
        </pluginRepository>
      </pluginRepositories>
      <id>artifactory</id>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>artifactory</activeProfile>
  </activeProfiles>
</settings>
```

配置完成后进入项目目录`\Project-Cloud\`下，执行`mvn package`进行依赖下载，可以看到从私服中拉取jar包就正确了

##### 实现制品上传

`\Project-Cloud\pom.xml`加入如下配置：

```xml
<distributionManagement>
	    <repository>
	        <id>central</id>
	        <name>544d25b369f1-releases</name>
	        <url>http://10.0.25.30:9083/artifactory/libs-snapshot-local</url>
	    </repository>
	    <snapshotRepository>
	        <id>snapshots</id>
	        <name>544d25b369f1-snapshots</name>
	        <url>http://10.0.25.30:9083/artifactory/libs-snapshot-local</url>
	    </snapshotRepository>
	</distributionManagement>
```

配置完成后进入项目目录`\Project-Cloud\`下，执行`mvn deploy`进行发布，实现制品上传

#### YAPI

http://10.0.25.30:3100

#### Sonarqube

http://10.0.25.30:9000

#### Jenkins

| 用户名        | 全称   | 邮箱                  | 初始密码  |
| ------------- | ------ | --------------------- | --------- |
| weibin        | 魏斌   | weibin@163.com        | @Admin123 |
| yangwang      | 杨望   | yangwang@163.com      | @Admin123 |
| shizhenzhen   | 史振振 | shizhenzhen@163.com   | @Admin123 |
| zhangguanglei | 张广磊 | zhangguanglei@163.com | @Admin123 |
| xuyaya        | 徐亚亚 | xuyaya@163.com        | @Admin123 |
| fengjunjun    | 冯俊俊 | fengjunjun@163.com    | @Admin123 |
| chencaifen    | 陈采芬 | chencaifen@163.com    | @Admin123 |

#### 非公债后台应用入口

http://10.0.25.30:9015

#### 非公债前端网站对外

http://10.0.25.30:9012/

