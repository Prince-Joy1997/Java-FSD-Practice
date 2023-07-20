# Training Manager 

Create prototype application that will manage the training details.
The classess are as follows:
```java
    class Student {}
    
    class Mentor {}
    
    class Batch {}
    
    class Schedule {}
    
    class Topic {}
```

The `Batch` class contains details of all the students in the batch, the mentor, and the schedule.
One batch can have multiple students, but it will have only one `Mentor`.
The `Schedule` class contains the details of the topics for the batch. Each topic has a start date and end date 
and a name.

## Requirements

- Create the proper methods for each class.
- Make sure data is encapsulated.
- Add unit testing to the application.
- The start date of a topic should be after the end date of the previous topic.
- The start date of a topic should be on or after the start date of the batch.
- The end date of a topic should be on or before the end date of the batch.
- The start date of a batch should be on or after the current date.
- The end date of a batch should be on or after the start date of the batch.
- Make sure all the data is validated before it is assigned to the member variables.