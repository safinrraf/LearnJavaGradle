# The project aims to learn the basics of Gradle

# How to run the application:
## using gradle
```
gradle run
```
## using java -jar, ! not working yet
```
java -jar build/libs/learn-java-1.0.0.jar
```


## Check the manifest file
```
unzip -q -c build/libs/learn-java-1.0.0.jar  META-INF/MANIFEST.MF
```


## Viewing the Contents of a JAR File
[The Java™ Tutorials](https://docs.oracle.com/javase/tutorial/deployment/jar/view.html)
```
jar tvf build/libs/learn-java-1.0.0.jar
```