# Overview 

This document guides you how to setup junit environment on MacOS X using Eclipse 2023 Dec 

# Initilize a maven project 

```
cd /Users/vuhung/eclipse-workspace
```

Initilize the project 

```
mvn archetype:generate -DgroupId=com.vuhung.app -DartifactId=vuhung-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

This will create a junit project with specified settings

Group ID: com.vuhung.app
Artifact ID: vuhung-app

This will generate a maven-based project under `/Users/vuhung/eclipse-workspace/vuhung-app`

Try to build 

```
mvn package
``` 

# Fix settings 

When we try to build with generated settings, we get the following errors 

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.0:compile (default-compile) on project vuhung-app: Compilation failure: Compilation failure:
[ERROR] Source option 7 is no longer supported. Use 8 or later.
[ERROR] Target option 7 is no longer supported. Use 8 or later.
```

## The fix
Specify source and target for maven with newer versions in pom.xml 

```
      <plugin>
          <artifactId>maven-compiler-plugin</artifactId>          
            <configuration>
	            <source>20</source>  
	            <target>20</target>
            </configuration>
          <version>3.8.0</version>
        </plugin>
```

# Build and Test 

Build: 

```
mvn package
``` 

Or run Test directly

```
mvn test
```

```
mvn verify
``` 

