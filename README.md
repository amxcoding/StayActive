# StayActive
The goal of the project is to design a modular and extensible application using OOP principles, SOLID, design patterns and testing. To do this, we had to first make a functional and technical design of our application. 

This application's purposes is to provide notifications in a certain time interval on which the user can act. If the user accepts the notification an exercises is shown that the user can do. The goal is to keep the user active once every hour.

## Clean architecture
Based on [CleanArchitecture](https://github.com/jasontaylordev/CleanArchitecture). The dependencies 
between the layers are as following:

![4-tier](assets/n-tier.png)

- ### [Application layer](Application)
The application layer depends only on the domain layer. Furthermore, it contains all the application logic. The application
layer contains the interfaces and logic what are used throughout the whole application. 
- ### [Domain layer](Domain)
The domain layer has no dependency on the other layers. It contains all entities, enums, exceptions, interfaces, 
types and logic specific to the domain layer.
- ### [ConsolUI layer](ConsoleUI)
For the console UI I have used the MVC design pattern. The console UI  depends on the infrastructure layer through dependency 
injection.
- ### [Infrastructure layer](Infrastructure)
I have used a template pattern for the database command and query. To access the database layer
I make use of DAOs and Repositories.


