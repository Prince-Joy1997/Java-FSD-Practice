# TopJobs App
Designed and developed by Anwar Khan, Jaimin Patel, Divya Swetha Meduri, and Fernanda Goncalves Rios

## Instructions To Run Application
Ensure that the following enviromental variables have been set on your local machine:

* **MYSQL_URL** : jdbc:mysql://localhost:3306/topjobauthenticatordb?createDatabaseIfNotExist=true&user=***YOUREUSERNAMEHERE***&password=***YOURPASSWORDHERE***
* **MYSQL_USER** : (your mysql username)
* **MYSQL_PASSWORD** : (your mysql password)
* **MONGO_URL** : mongodb://localhost:27017/topjobsdb

Next, using Spring Tool Suite run the back end services in the following order
* EurekaServer
* Authenticator_Service
* Employer
* Job
* JobSeeker
* Gateway

Next, open a command prompt window within the **Front End Angular** folder, and run the following commands:
```
npm install
ng serve
```

Finally, navigate to the following link in your browser to access the application:
```
http://localhost:4200/
```
