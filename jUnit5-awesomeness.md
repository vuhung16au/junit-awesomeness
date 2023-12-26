# Overview 

This file notes important features on jUnit 5 (as compared to jUnit 4) 

# jUnit 5 architecture 

JUnit Jupiter - Includes new programming and extension models for writing tests in JUnit 5. 
JUnit Platform – Scopes all the extension frameworks we might have an interest in: test execution, discovery, and reporting.
JUnit Vintage – Allows backward compatibility with JUnit 4 or even JUnit 3.

# New in jUnit 5 

jUnit 5: 
- Allows multiple runners to work simultaneously
- Makes good use of the Java 8 features
- Adds more granularity and can import only what’s necessary

# Assertions in jUnit 5 

![Assertions in jUnit 5](https://github.com/vuhung16au/junit-awesomeness/blob/main/jUnit5-and-jUnit4.png?raw=true
)

# Setup jUnit5 and maven 

pom.xml 

Newer versons can be found on https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
```
    <properties>
        <junit-jupiter.version>5.5.2</junit-jupiter.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```
Add maven dependency
```

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit-jupiter.version}</version>
            <scope>test</scope>
        </dependency>
```

Plugins 
```
        <plugins>

            <!-- Need at least 2.22.0 to support JUnit 5 platform -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M3</version>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>

            <!-- for mvn site to generate test repot, optional -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-site-plugin</artifactId>
                <version>3.8.2</version>
            </plugin>
        </plugins>
``` 

# Sample jUnit 5 assertions 

[jUnit 5 sample assertion](https://github.com/vuhung16au/junit-awesomeness/blob/main/JUnit5ShowcaseTest.java)

# Sample run with jUnit 5 + maven 

Clean and run all test cases 
```
mvn clean
mvn test 
```

```
mvn site
```
The report will be avaialbe under `./target/site/surefire-report.html`


# Awesome resources 

- https://junit.org/junit5/
- https://junit.org/junit5/docs/current/api/
- https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html

- https://www.baeldung.com/junit-5
- https://www.baeldung.com/junit-5
