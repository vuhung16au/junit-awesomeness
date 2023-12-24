| No | Commands | Explanations | 
| :------------------- | :---------- | :---------- |
| 1   | mvn clean         |     Clean         | 
| 2   |    mvn validate      |     Validates the Maven project to ensure that everything is correct and all the necessary information is available         | 
|   3 |    mvn test      |        Run the test cases of the project      | 
|  4  |     mvn verify     |       Builds the project, runs all the test cases and run any checks on the results of the integration tests to ensure quality criteria are met       | 
|  5  |     mvn clean verify     |   Clean, and the Verify           | 

`mvn archetype:generate -Dfilter=senerity`: Generate a senerity based maven project.
`mvn archetype:generate -DgroupId=com.vuhung.app -DartifactId=vuhung-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`: Generate a skeleton maven based jUnit project with specified group ID ad artifact ID.

