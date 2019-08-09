# Discovery

Prerequisite: 
1.	Java to be installed and Environment variables to be set.
JAVA_HOME = path to jdk C:\Program Files\Java\jdk1.8.0_161
JRE_HOME = path to jre C:\Program Files\Java\jre1.8.0_161
Add to Path: 
%JAVA_HOME%\bin
% JRE_HOME %\bin

2.	Maven to be downloaded and Environment variables to be set.
M2_HOME = C:\Downloads\apache-maven-3.5.4-bin
MAVEN_HOME = C:\Downloads\apache-maven-3.5.4-bin
Add to Path: 
% M2_HOME %\bin
% MAVEN_HOME %\bin

Navigate inside  Project master/CucumberProject
and run below commands to execute your test cases 

Navigate to Project folder where pom.xml resides
From that path open command promt or open open command prompt and navigate to pom.xml inside the project folder
and fire below commands : 

mvn eclipse:eclipse
mvn test

