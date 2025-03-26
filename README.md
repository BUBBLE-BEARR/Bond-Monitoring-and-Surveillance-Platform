## System Operation Guide

### Backend Setup

1. Use SVN (https://svn.interotc.cn/svn/FGZJCJK/branches/1.0/Code/backend/Project-Cloud) to `checkOut` the code into your working directory.

2. Import the project into `Eclipse`: Select `File` -> `Import`, choose `Maven` -> `Existing Maven Projects`, click `Next`, select your working directory, and click `Finish`.

Eclipse will automatically load the Maven dependencies. Initial loading may be slow, depending on network conditions.

3. Start the required modules (no particular order):
- ProjectGatewayApplication (Gateway module - Required)
- ProjectAuthApplication (Authentication module - Required)
- ProjectSystemApplication (System module - Required)
- ProjectNpddmApplication (Non-public Debt Module - Required)
- ProjectMonitorApplication (Monitoring Center - Optional)
- ProjectGenApplication (Code Generation - Optional)
- ProjectJobApplication (Scheduled Tasks - Optional)
- ProjectFileApplication (File Service - Optional)

### Frontend Setup

1. Use SVN (https://svn.interotc.cn/svn/FGZJCJK/branches/1.0/Code/frontend/project-ui) to `checkOut` the frontend code.

```bash
# Enter the project directory
cd project-ui

# Install dependencies
npm install

# Strongly recommended to avoid using cnpm directly to prevent issues.
npm install --registry=https://registry.npm.taobao.org

# Launch local development server
npm run dev
```

2. Open a browser and navigate to: [http://localhost:80](http://localhost:80). Use the default username/password: `admin/admin123`. If the login page loads successfully and you can log in, your environment is correctly set up.

> Note:
>
> The frontend and backend are completely separated; both must be running independently.

## System Modules

```java
com.project
├── project-ui                // Frontend framework [80]
├── project-gateway           // Gateway Module [8099]
├── project-auth              // Authentication Center [9200]
├── project-api               // API Modules
│       └── project-api-system                        // System API
├── project-common            // Common Modules
│       └── project-common-core                       // Core Module
│       └── project-common-datascope                  // Permissions Scope
│       └── project-common-datasource                 // Multi Data Source
│       └── project-common-log                        // Logging
│       └── project-common-redis                      // Caching
│       └── project-common-security                   // Security
│       └── project-common-swagger                    // Swagger API Docs
├── project-modules           // Business Modules
│       └── project-system                            // System Module [9201]
│       └── project-gen                               // Code Generation [9202]
│       └── project-job                               // Scheduled Tasks [9203]
│       └── project-npddm                             // Non-public Debt Module [9204]
│       └── project-file                              // File Service [9300]
├── project-visual            // Visualization Management
│       └── project-visual-monitor                    // Monitoring Center [9100]
├── pom.xml                   // Common Dependencies
```

> Please implement new functionality within the `Non-public Debt Module`.

### Software Information:

#### Server IP: 10.0.25.30

| Software        | Version           | Port                   | Username/Password | Notes                                                      |
|-----------------|-------------------|------------------------|-------------------|------------------------------------------------------------|
| OpenJDK         | 1.8.0_302         | -                      | -                 | OpenJDK1.8                                                 |
| Node            | v12.22.8          | -                      | -                 | NodeJS environment                                         |
| Npm             | 6.14.15           | -                      | -                 | Package manager                                            |
| Maven           | 3.6.3             | -                      | -                 | Apache Maven for building projects                         |
| Nginx           | 1.21.3            | 80, 9015               | -                 | Web server and reverse proxy                               |
| Jenkins         | 2.323-1.1.noarch  | 9999                   | Assigned          | Continuous Integration (CI)                                |
| Redis           | 5.0.5             | 6379                   | -                 | Distributed caching                                        |
| MySQL           | 8.0.27            | 3307                   | root/root123      | Database management                                        |
| JIRA            | 8.12.0            | 8080                   | Assigned          | Requirements and issue management                          |
| Nacos           | 2.0.3             | 8848, 9848, 9849       | nacos/nacos       | Service registry and configuration                         |
| Artifactory-OSS | 6.18.1            | 9083                   | Assigned          | Artifact repository management (Maven)                     |
| Artifactory-JCR | 7.4.3             | 9381, 9382             | -                 | Docker and Helm artifact repository                        |
| SonarQube       | -                 | 9000                   | -                 | Code quality management                                    |
| YAPI            | -                 | 3100                   | Assigned          | API testing                                                |
| Mongo           | latest            | 27017                  | Assigned          | Database for YAPI                                          |

#### Maven Repository Configuration

Configure Maven (`settings.xml`) to use Artifactory-OSS as follows:

```xml
<!-- Configuration provided previously -->
```

Run `mvn package` to verify dependency downloads from Artifactory.

To deploy artifacts, add the following to your project `pom.xml`:

```xml
<distributionManagement>
  <repository>
    <id>central</id>
    <name>releases</name>
    <url>http://10.0.25.30:9083/artifactory/libs-snapshot-local</url>
  </repository>
  <snapshotRepository>
    <id>snapshots</id>
    <name>snapshots</name>
    <url>http://10.0.25.30:9083/artifactory/libs-snapshot-local</url>
  </snapshotRepository>
</distributionManagement>
```

Execute `mvn deploy` to upload artifacts.

#### Access URLs:
- **Nacos:** http://172.16.101.109:8848/nacos
- **Artifactory-OSS:** http://10.0.25.30:9083
- **YAPI:** http://10.0.25.30:3100
- **SonarQube:** http://10.0.25.30:9000
- **Non-public Debt Application:** http://10.0.25.30:9015

#### Jenkins Users (Initial Password: `@Admin123`):
- weibin (weibin@163.com)
- yangwang (yangwang@163.com)
- shizhenzhen (shizhenzhen@163.com)
- zhangguanglei (zhangguanglei@163.com)
- xuyaya (xuyaya@163.com)
- fengjunjun (fengjunjun@163.com)
- chencaifen (chencaifen@163.com)

