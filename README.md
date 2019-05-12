# Travel-agency
This is a demo of a social site like travel agency. Here is the way to write your own time line,edit,update and delete the post status. You can view your own time line and there is a Home where you can view all users status. Using Spring MVC, Hibernate ORM and JavaScript to completed this project.

#Project configuration and setup:

1) First create a database named travelagency because I configured it into applicationContext.xml. Write create here
<prop key="hibernate.hbm2ddl.auto"> create </prop><!-- create or update database like "create" or "update" -->
You can change it as you expect.Then start application with apache-tomcat v9 and for database I used xampp run it for mysql database connection which database you created. All the database table will be created by the hibernate annotation configuration.

2) For clear understanding read applicationContext.xml and UsersController.java and pom.xml file. Need to focus on ajax.login_registration.js and ajax.post_status.js for request handling between client side and controller

3) To deploy the site by only running  apache-tomcat v9 server. For that please put travel-agency.war file into
C:\Program Files\Apache Software Foundation\apache-tomcat-9.0.16\webapps\travel-agency.war

4) Completed feature for posting own time line, to view posted status, delete a status and edit a status. Also covered Session and Cookie for login and logout 

