# fantasy-football-analyzer
A project to track and analyze data related to NFL fantasy football.

Idea inspired by V1 of the project available here: https://github.com/pecjas/FFBStats

##Table of Contents
1. [Getting Started](#getting-started)
2. [Create Your Database](#create-your-database)
3. [Starting the Application](#starting-the-application)

##Getting Started
Be sure to install the dependencies on your computer
* Java: Java 11
* MySql: 8.0.20
* MySQL Workbench: Any Version
* TODO: Add JS Dependencies

##Create your database
1. Follow the instructions [here](https://dev.mysql.com/doc/refman/8.0/en/installing.html) 
   to install and configure MySql
2. Create a new database in MySql
3. In the analyzer-core module, copy `connection.properties.example` to `connection.properties`
   ```
   $ cp connection.properties.example connection.properties #unix-like OS
   $ copy connection.properties.example connection.properties #windows OS
   ```
4. Fill in the connection details documented in `connection.properties`
5. Run the liquibase command to populate your schema. The parameters should be the same as in 
   the `connection.properties` file.
   
**Note:** If you want to connect to MySql without a password, remove or clear out the DB_PASSWORD field.

##Starting the Application
1. **Optional:** If you want to change the port the application runs on, make a copy of `application.properties.example`
   into `application.properties`.
   ```
   $ cp application.properties.example application.properties
   $ copy application.properties.example application.properties
   ```
2. Build the project
   ```
   $ mvn clean install -Pdev # builds a .jar
   $ mvn clean install -Pdev,deploy #builds a .war
   ```
3. Run the project.
    1. If you built a `.jar`:
       ```
       $ java -jar analyzer-application/target/analyzer-application-* # * will be the version
       ```
    2. If you built a `.war`, you'll deploy to a servlet container.

##Useful Commands 
* Skip tests and checkstyle
    ```
    $ mvn clean install -Pdev
    ```
* Checkstyle
    ```
    $ mvn checkstyle:checkstyle
    ```
* Liquibase - fill in the required parameters
    ```
    $ mvn clean install liquibase:update -pl analyzer-sql -Ddb.host=[HOST NAME] -Ddb.port=[PORT] \
      -Ddb.name=[DATABASE NAME] -Ddb.useSSL=[TRUE|FALSE] -Ddb.username=[DB USER] -Ddb.password=[PASSWORD] \
      -Ddb.tz=[TIMEZONE]
    ```
    **Note:** The defaults for liquibase parameters are:
    * db.host: 127.0.0.1
    * db.port: 3306
    * db.name: new
    * db.useSSL: FALSE
    * db.username: root
    * db.password: `NULL`
    * db.tz: America/Chicago
* Running Integrated Tests
    ```
    $ mvn clean test -pl analyzer-tests
    ```

