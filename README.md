LoskaWebApp
===========
##About
Web-based application for creating and managing invoices.

The application is developed in Java using the Spring MVC framework. A MySQL database is
used to persist data.

Javascript support is required on the client browser for JQuery to function properly.

The database can be migrated relatively easily from MySql to another engine. This only requires
new implementations of the data access object interfaces on the application’s side.

The application as it stands is still missing a lot of features!! 

##Application Architecture
![Architecture Diagram](https://raw.github.com/nyholmniklas/LoskaWebApp/master/doc/arch_diagram.jpg)

##Database Schema
![Database Schema](https://raw.github.com/nyholmniklas/LoskaWebApp/master/doc/db_diagram.jpg)

##Screenshots
###Login
![Login Screenshot](https://raw.github.com/nyholmniklas/LoskaWebApp/master/doc/screenshots/login.jpg)
###Create Invoice
![New Invoice Screenshot](https://raw.github.com/nyholmniklas/LoskaWebApp/master/doc/screenshots/create_invoice.jpg)