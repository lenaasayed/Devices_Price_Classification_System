import pickle
import numpy as np
from flask import Flask, request, jsonify
from waitress import serve    
import uuid
import os
import re

# create function that predict one element
def Predict_Single_Element(element,dv,model):
#     Vectorize the customer: create the matrix X
    X = dv.transform([element])
#     Apply the model to this matrix
    pred_Y_prob = model.predict_proba(X)[:, 1]
#     Predict the customer
    pred_Y = model.predict(X)
#     Return the result
    return pred_Y

# Load The Model
with open('device-model.bin', 'rb') as f_in:
    dv, model = pickle.load(f_in)

    
# create the Flask app
app = Flask('device')
@app.route('/prediction', methods=['POST'])
def predict():
# Get the content of the request in JSON
    customer = request.get_json()
#     Call the function to predict the reslt
    prediction = Predict_Single_Element(customer, dv, model)
#     Convert the result to string
    result = str(prediction[0])
    return result

# starts the service
if __name__ == '__main__':
    
    serve(app, listen='*:9000',debug=True)