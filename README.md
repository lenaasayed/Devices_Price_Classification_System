
# Devices Price Classification System

Building a ML model that classify the price level ,0:(low cost),1:(medium cost),2:(high cost),3:(very high cost)
of the devices using Python for ML part ,SpringBoot and Angular.


## Project Workflow:

- Build ML model using python in Jupyter Notebook
- Build Microservice using Flask Python Framework
- Dockerizing Flask Application
- SpringBoot project for Backend
- Angular project for Frontend


## Machine learning part
Building ML model, to classify the price for any device
-  1.Data Preparing
    - Data Preparing
    - Exploratory Data Analysis
    - Analyze categorical variables
        - RISK RATIO 
        - MUTUAL INFORMATION
    - Feature engineering 
    - Analyze numerical variables
        - correlation coefficient
        - Heat Map
    - Handle categorical variables
- 2.Build Model
    - Create Features and Labels from Dataframe
    - Splitting Data into Train , Validation and Test
    - Train the model using KNN
- 3.Evaluate Model
    - Confusion Matrix and Accuracy
- 4.Optimize Model
    - Hyperparameter Tuning
    - K-fold Cross-Validation
## Microservice part
Serving models with Flask in app.py, to connect with Spring backend
- create the Flask app
- create function that predict one device
- starts the service
- given the features of a device,it will respond with the price level
## Virtual machine part
Managing dependencies of python
- create the requirements.txt that has python libraries
- start "venv" environment

        $ virtualenv venv
- active "venv" environment

        $ venv/Scripts/activate
- install the requirements.txt

        (venv)$ pip install -r requirements.txt    
- run the app.y using waitress

        (venv)$ waitress-serve --host=0.0.0.0 --port=9700 app:app      
## Docker part
- Make the Dockerfile
    - Set the working directory
    - Copy and install the requirements.txt file
    - Copy the ".py" and the model ".bin"
    - Open the port that web service uses
    - Specify how the service should be started
- Build the image

        $ docker build -t predict .
- use the image to start a Docker container

        $ docker run -it -p 9700:9700 predict:latest
## Backend part
- Create a Spring Boot Application using Spring Initializr
- Define Maven Dependencies in pom.xml File
- Creating the Prediction.java to represent the data model
- Create the PredictionRepository.java to handle database operations
- Create the PredictionService.java to handle the business logic for REST AP
- Create the PredictionServiceImplements.java to implement the logic
- Create the PredictionController.java to handle HTTP requests for REST API
## Frontend part
- create web page to show the result of some test data
- create web page to enter the features of device to get level of price
- create Reqests to backend

  
## API Reference

#### Get all devices

```http
  GET /api/devices
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |


#### Get result of price's level of in test dataset

```http
  GET /api/predictObj/{count}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id     ` | `number` | **Required**. Your id of device |


#### Get result of price's level of in one device

```http
  GET /api/predict
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |
