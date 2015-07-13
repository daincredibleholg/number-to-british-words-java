# Number to words transformation (British edition)

# Introduction
This is a small programming challenge, written in Java. The task is simple: Transform a number into (british) words.
Numbers are expected to be positive and the maximum number supported is 999,999,999.

# Prerequisites
To get this application up and running, you need the following ingredients:
* Java (tested with Java 8)
* Maven (tested with version 3.3.3)

# Build status
* Master branch: [![Build Status](https://travis-ci.org/daincredibleholg/number-to-british-words-java.svg?branch=master)](https://travis-ci.org/daincredibleholg/number-to-british-words-java)
* Develop branch: [![Build Status](https://travis-ci.org/daincredibleholg/number-to-british-words-java.svg?branch=develop)](https://travis-ci.org/daincredibleholg/number-to-british-words-java)
* Status static code analysis: [![Coverity Badge](https://scan.coverity.com/projects/5687/badge.svg)](https://scan.coverity.com/projects/5687)

# How to start
To get this project up and running, simply clone the repository, let Maven build the project:

```
mvn clean package
```

If you interested in the tests, run the following command:
```
mvn clean verify
```

This will execute all unit tests and the integration tests.

# Usage
Maven will create the file _number2words.jar_ in the target directory. This is the program, simply do:

```
java -jar target/number2words.jar [<number>]
```

and replace _<number>_ by the number you want the british word representation for. For example:

```
java -jar target/number2words.jar 42
```

Calling the application without an argument, with a non-numeric or more than one argument will show the usage
information:
```
This program converts numbers between 1 and 999999999 into british words. (E.g. 42 get converted to 'forty two')
Usage:
        java -jar number2words.jar <number>

```


