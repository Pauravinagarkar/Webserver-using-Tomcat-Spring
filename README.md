﻿# Webserver-using-Tomcat-Spring
#  Spring MVC Application

## Step 1: Set Up Your Development Environment

1. **Install Java Development Kit (JDK)**:
   - Ensure you have the latest JDK installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Set Up Your IDE**:
   - Use an IDE like IntelliJ IDEA, Eclipse, or NetBeans.

3. **Install Apache Tomcat**:
   - Download and install Apache Tomcat from [here](http://tomcat.apache.org/download-90.cgi). Ensure Tomcat is configured in your IDE.

4. **Set Up a Database**:
   - Install and configure a database like MySQL or PostgreSQL.

## Step 2: Set Up the Project Structure

1. **Create a New Maven Project**:
   - Open your IDE and create a new Maven project.

2. **Add Dependencies**:
   - Open the `pom.xml` file and add the necessary Spring dependencies.

## Step 3: Configure Your Application

1. **web.xml**:
   - Place the following content in `web.xml`:

    ```xml
    <web-app>
        <!-- Your web.xml content -->
    </web-app>
    ```

2. **spring-dispatcher-servlet.xml**:
   - Place the following content in `spring-dispatcher-servlet.xml`:

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns:mvc="http://www.springframework.org/schema/mvc"
           xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="
               http://www.springframework.org/schema/beans 
               http://www.springframework.org/schema/beans/spring-beans.xsd
               http://www.springframework.org/schema/mvc
               http://www.springframework.org/schema/mvc/spring-mvc.xsd 
               http://www.springframework.org/schema/context 
               http://www.springframework.org/schema/context/spring-context.xsd">

        <mvc:annotation-driven/>
        <context:annotation-config/>
        <context:component-scan base-package="pauravi"/>

        <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/views/"/>
            <property name="suffix" value=".jsp"/>
        </bean>
    </beans>
    ```

3. **Controller Class**:
   - Ensure you have the `StudentAdmissionController.java` in the correct package.

4. **AdmissionSuccess.jsp**:
   - Place your `AdmissionSuccess.jsp` file in the `WEB-INF/views` directory.

5. **CSS**:
   - Place `style.css` in the appropriate directory and link it in your JSP files if necessary.

## Step 4: Run the Application

1. **Build the Project**:
   - Run `mvn clean install` to build the project and generate the WAR file.

2. **Deploy to Tomcat**:
   - Copy the generated WAR file to the Tomcat `webapps` directory.

3. **Start Tomcat**:
   - Start the Tomcat server and access the application via `http://localhost:8080/student-registration/admissionForm`.

## Troubleshooting

### Maven Installation Issues

1. **mvn clean install Failed**:
   - Check if Maven was downloaded properly.

2. **To Install Maven on Windows**:
   - Go to the Apache Maven download page and download the binary zip archive for your operating system.
   - Extract the downloaded zip file to a directory on your computer (e.g., `C:\Program Files\Apache\Maven`).

3. **Install Maven from Terminal**:
   ```bash
   # Set the version number
   $mavenVersion = "3.8.6"

   # Download Maven
   Invoke-WebRequest -Uri "https://downloads.apache.org/maven/maven-3/$mavenVersion/binaries/apache-maven-$mavenVersion-bin.zip" -OutFile "C:\apache-maven-$mavenVersion-bin.zip"

   # Extract Maven
   Expand-Archive -Path "C:\apache-maven-$mavenVersion-bin.zip" -DestinationPath "C:\Program Files\Apache\Maven"

   # Remove the zip file
   Remove-Item -Path "C:\apache-maven-$mavenVersion-bin.zip"
   ```

4. **If Downloaded Manually, Extract**:
   ```bash
   # Define the paths
   $mavenZipPath = "C:\Users\User-name\Downloads\apache-maven-3.8.8-bin.zip"
   $destinationPath = "C:\Program Files\Apache\Maven"

   # Create the destination directory if it doesn't exist
   New-Item -ItemType Directory -Force -Path $destinationPath

   # Extract the archive
   Expand-Archive -Path $mavenZipPath -DestinationPath $destinationPath

   # List the contents to verify extraction
   Get-ChildItem -Path $destinationPath
   ```

### Set Up Environment Variables

- Check if your Maven has `bin` in it. If not, reinstall the correct version.

- **Add Maven to System PATH**:
   - In the Edit Environment Variable window, click "New" and add the path to the Maven bin directory (e.g., `C:\Program Files\Apache\Maven\apache-maven-3.8.8\bin`).

- **Set MAVEN_HOME Variable**:
   - Set the Variable name as `MAVEN_HOME` and the Variable value as the path to your Maven directory (e.g., `C:\Program Files\Apache\Maven\apache-maven-3.8.8`).

### Verify Maven Installation

- Type on Terminal:
  ```bash
  mvn -version
  ```

### If mvn clean install fails:

- Check `pom.xml`.
- Update your `pom.xml` file or restore the version of Maven.
- Add Compiler Plugin Configuration in `pom.xml`.
- Update the Maven WAR Plugin Configuration.

## How to Install Tomcat

1. **Download Apache Tomcat**:
   - Go to the Apache Tomcat download page.
   - Download the "32-bit/64-bit Windows Service Installer" or the "zip" file.

2. **Install or Extract Tomcat**:
   - If you downloaded the installer, run it and follow the installation steps.
   - If you downloaded the zip file, extract it to a known location, such as `C:\Tomcat`.

### Extract through Terminal

```bash
# Define the path variables
$zipFilePath = "C:\Users\user-name\Downloads\apache-tomcat-9.0.89-src.zip"
$destinationPath = "C:\Tomcat"

# Create the destination directory if it doesn't exist
New-Item -ItemType Directory -Force -Path $destinationPath

# Extract the zip file
Add-Type -AssemblyName System.IO.Compression.FileSystem
[System.IO.Compression.ZipFile]::ExtractToDirectory($zipFilePath, $destinationPath)
```

### Navigate to Bin directory to Open Tomcat

```bash
cd "C:\Tomcat\apache-tomcat-9.0.89\bin"
```

### Start Tomcat

```bash
.\startup.bat
```

### Start Web browser

```bash
http://localhost:8080
```

### If localhost is not working:

- **Error: ERR_INVALID_HTTP_RESPONSE**:
  - Check logs.
  - Mostly it is because port 8080 is already in use by another web service.
  - Change Port.

### Manually change the port:

- Manually go to: `C:\Tomcat\apache-tomcat-9.0.89\conf\server.xml` and change port from 8080 to 8081

```xml
<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443" />
```

### If you get HTTP 500 error:

- It means there is a problem with your dispatcher file: `spring-dispatcher-servlet.xml`.
- Check the structure of your whole program.
- Verify `web.xml` Configuration.
- Redeploy the Application.

### Ideal File Structure:

```
student-registration/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── pauravi/
│   │   │       └── FileNameController.java
│   │   ├── resources/
│   │   ├── webapp/
│   │       ├── WEB-INF/
│   │       │   ├── web.xml
│   │       │   ├── spring-dispatcher-servlet.xml
│   │       │   └── views/
│   │       │       ├── Filename.jsp
│   │       │       ├── FileSuccess.jsp
│   │       └── css/
│   │           └── style.css
```

Ideally, with the correct code and code version, it should run properly.

## Conclusion
By following these steps, you can set up, develop, and deploy your Spring web application. The provided files and configuration should now work correctly when deployed to a Tomcat server.
