# SayNoToHunger

SayNoToHunger (NoToHunger) is a Java Spring Boot and Angular application. It is a web-based donation portal where people can donate food and money to the needy people. 

## Front end frameworks used:
---
Our team has used **HTML, CSS, Bootstrap 4, and Angular 7** for the front end.
## Backend technology used:
---
We have used the **Java Spring Boot** to complete the back-end functionalities.
## Database:
---
Our team has decided to have a centralized database so that everyone can access it anytime without any hurdles. Hence, we have created a SQL database in Microsoft Azure.
[Server name: webdevproject.database.windows.net]

## W3C Compliance:
---
We have used the chrome extension ["HTML Validator"]( https://chrome.google.com/webstore/detail/html-validator/mpbelhhnfhfjnaehkcnnaknldmnocglk) to validate the w3c compliance. To validate the HTML, we navigated to the pages we have created through the application. We opened the "developer tools" by pressing F12 or by selecting 'Inspect element' from the right-click menu. The w3c compliance check results are displayed under the tab "HTML validator". It reported 1 error which is an Angular directive. Then, we clicked on the `w3c online` button to validate my page which reported 0 errors.

## File organization:
---
In the front-end project, our team has decided to group the HTML, CSS, and script files based on the feature. Since angular is component based, every reusable part of HTML can be created into separate components, which will result in a large list of HTML, CSS, and Script files. This makes the code maintenance harder. Hence we have grouped the HTML, CSS, and TS files based on the feature it belongs to.

In the back-end project, we have 4 main directories:
* Controller - contains the code responsible handling request and response
* Service - contains the code responsible for business logic and data manipulations
* Data Layer - contains the code for performing database related operations
* Model - contains the classes that represent the data from the database

## Setup instructions:
---
The first step is to clone or download the project from the [repository]
Back end Repository: https://git.cs.dal.ca/araja/saynotohungerserver
Front end Repository: https://git.cs.dal.ca/krao/notohunger
The project contains 2 sub-projects:
* front-end angular project (Folder name: `notohunger`)
* back-end Java Spring Boot project (Folder name: `saynotohungerserver`)

`The back-end project should be running in the local system as a pre-requisite for the application to function properly.`

1. Java Spring Boot
Pre-requisites:
    * Java Development Kit (Version 1.8)
      [Java Development Kit (JDK 8.1)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) can be downloaded  [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html). The current version of JDK can be verified by using the command `java -version`
    * Active Internet connection
        Since the database resides in the cloud, the device (in which the application is browsed) should be connected to the Internet.
    * An IDE compatible with JAVA
        For example, [Eclipse](https://www.eclipse.org/downloads/), [VS Code](https://code.visualstudio.com/download) (requires additional installation of [Java extension pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)), etc.
2. Angular (front-end) project:
Pre-requisites:    
    * Node
        Install node by downloading from  https://nodejs.org/en/download/
    * NPM
        After installing [node]( https://nodejs.org/en/download/), open a command prompt and execute the command `npm install –g @angular/cli`
        
#### Steps to run the back-end project
---
* Open the back-end project (saynotohungerserver) from Eclipse, VS Code, or any other IDE that supports Java.
* Run the project through menus or by pressing `Ctrl + F5` for VS Code and `Ctrl + F11` for Eclipse.
* The application will be hosted on the port 8080. Hence, there should not be any other process running on the port 8080 to avoid any issues.
* To verify whether the application is running successful, browse `http://localhost:8080`, a "Hello World!!!" message will be displayed.

#### Steps to run the front-end project
* Open the front-end project folder(notohunger) in Windows Explorer.
* Type `cmd` in the address bar of Windows Explorer and press `Enter`. Otherwise, open a command prompt and change the path to the source code project folder (notohunger).
`Note: The command prompt should be pointing the notohunger folder (notohunger)`
* Execute the command `npm install`. This command will download the necessary files.
* Execute the command `ng serve`. This command hosts the application in `http://localhost:4200` by default. There should not be any other process running on the port 4200 to avoid any issues.

## Features:
* The website has interesting features like user profile management, Food Donation, Money donation, Volunteering, Tracking, Administration, AI messaging, Recipient, map integration, News feed and so on.

##### To Navigate the website
* Open the home page of the website, You can register yourself as any one of the four kinds of users (admin, donor, recipient, volunteer).
* Login as donor to access the donor pages and donate food or money.
* To donate food, click on Donate now and fill in the details and click submit.
* A registered user can see this post in the dashboard and can accept or deny the offer.
* To post a request, login as a recipient, click on Need Food? and fill in the details and submit.
* This can be seen in the registered donors in the dashboard food offerings. The user can choose to donate from there as well.
* Registered volunteer can login and visit the dashboard to see the set of orders and choose one to volunteer.
* The status of the delivery can be tracked by the donor and the recipient by choosing dashboard - my offerings(donor)  / my requests (recipient) - in food offer , click track to know whether the order is delivered or not, who took the offer and so on.
* The News Feed can be seen by the user in the Home page to know the latest NEWS added by the administrator
* The AI messaging is available in the Home page to help the user to access the website and to know some common facts.
* When the users login as administrator, then the user can accept the user, delete the user, suspend the user and so on.


### IDE & Tools Used:
---
VS Code, Eclipse, Postman, SQL Server Management Studio, Microsoft Azure

### References:
---
[1] https://programmaticponderings.com/2012/08/24/calling-sql-server-stored-procedures-with-java-using-jdbc/
We have used the reference [1] to understand the syntax for calling a stored procedure in SQL Server.

[2] https://spring.io/guides/gs/rest-service-cors/
We have used the reference [2] to solve the errors while connecting the angular services to spring boot methods.

[3]"Angular", Angular.io, 2019. [Online]. Available: https://angular.io/guide/quickstart. [Accessed: 23- Mar- 2019].

[4]"Angular reactive forms validation", YouTube, 2019. [Online]. Available: https://www.youtube.com/watch?v=MPuXl1DS1vU. [Accessed: 23- Mar- 2019].

[5]"Angular 6 Reactive Form Validation", YouTube, 2019. [Online]. Available: https://www.youtube.com/watch?v=KdjSZ-VTDMw. [Accessed: 23- Mar- 2019].

[6]a. Mark Otto, "Introduction", Getbootstrap.com, 2019. [Online]. Available: https://getbootstrap.com/docs/4.3/getting-started/introduction/. [Accessed: 23- Mar- 2019].

[7]"Bootstrap 4 Tutorial", W3schools.com, 2019. [Online]. Available: https://www.w3schools.com/bootstrap4/. [Accessed: 23- Mar- 2019].

[8]2019. [Online]. Available: https://www.w3schools.com/html/default.asp. [Accessed: 23- Mar- 2019].

[9]"CSS Tutorial", W3schools.com, 2019. [Online]. Available: https://www.w3schools.com/css/. [Accessed: 23- Mar- 2019].

[10]2019. [Online]. Available: https://theirworld.org/news/school-meals-crisis-hits-1.5m-vulnerable-children-west-and-central-africa. [Accessed: 23- Mar- 2019].

[11]"An End to World Hunger?", Applied Unificationism, 2019. [Online]. Available: https://appliedunificationism.com/2013/07/09/ending-world-hunger/. [Accessed: 23- Mar- 2019].

[12]T. Team, "Get To Know Your Neighbours With Apartment Community Events", Rentseeker.ca, 2019. [Online]. Available: http://www.rentseeker.ca/blog/index.php/entertain-renters-with-apartment-community-resident-events/787. [Accessed: 23- Mar- 2019].

[13]"Download free icons, music, stock photos, vectors", Icons8.com, 2019. [Online]. Available: https://icons8.com/. [Accessed: 23- Mar- 2019].

[14]"Sign in", GitLab, 2019. [Online]. Available: https://git.cs.dal.ca/ydesai/a2_yash_desai. [Accessed: 23- Mar- 2019].

[15] Abinaya Raja, B00799562, Assignment 3, CSCI 5709

[16] Abinaya Raja, B00799562, Assignment 4, CSCI 5709

[17] Jamuna Loganath, B00811590, Assignment 3, CSCI 5709

[17] Jamuna Loganath, B00811590, Assignment 4, CSCI 5709

[18] Bhavya Chandrappa, B00781097, Assignment 3, CSCI 5709

[19] Bhavya Chandrappa, B00781097, Assignment 4, CSCI 5709

[20] Eugene Shishannikov, B00806895, Assignment 3, CSCI 5709

[21] Eugene Shishannikov, B00806895, Assignment 4, CSCI 5709

[22] Kush Rao, B00801194, Assignment 3, CSCI 5709

[23] Kush Rao, B00801194, Assignment 4, CSCI 5709

[24] Yash Desai, B00810560, Assignment 3, CSCI 5709

[25] Yash Desai, B00810560, Assignment 4, CSCI 5709

[26]"Dialogflow", Dialogflow, 2019. [Online]. Available: https://dialogflow.com/.

[27]"A Quick Example of Spring Websockets' @SendToUser Annotation | Baeldung", Baeldung, 2019. [Online]. Available: https://www.baeldung.com/spring-websockets-sendtouser.
