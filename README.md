# CambadaForum - October 2020
## Author
Otavio Sartorelli de Toledo Piza email: I am currently a freshman at Purdue University and am very interested in back-end development.
- Contact info: otaviostpiza@gmail.com

## About the Project
This project is an online forum similar to Reddit, which I created during the summer break of 2020 for my friends and me. It used a PostgreSQL server to store the contents of the website and was build using Java 8.

Current functionality includes:
- Registering a new user
- Logging-in 
- Creating new topics
- Editing old topics
- Commenting on topics
- Viewing the user ranking based on activity

Currently, I am working on:
- Impementing custom exceptions
- Stylizing the forum
- Adding the possibility to befriend users

## Intalation 
### Requirements
Albeit there are many ways to install the project, the following is by far the easiest. The requirements are:
- Java 8: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
- TomCat 9: https://tomcat.apache.org/download-90.cgi
- Eclipse IDE for enterprise Developers: https://www.eclipse.org/downloads/packages/release/2018-12/r/eclipse-ide-enterprise-java-developers
- postgreSQL: https://jdbc.postgresql.org/download.html

### Process
1. Install Eclipse making sure to choose the enterprise edition.
2. Install TomCat 9.
3. Install PostgreSQL (take note of your user and password)
4. Clone the repository and open it as a project on Eclipse.
5. Find 'postgresql-42.2.14.jar' under Libraries and add it to the TomCat 9 lib folder
6. Create a new TomCat 9 server in Eclipse, ensuring its ports are properly configured

### Setting up the web forum
1. To configure the database, just run App.java
2. First execute 'createTables'
3. Then, using the information from the PostgreSQL installation, 'execute config'