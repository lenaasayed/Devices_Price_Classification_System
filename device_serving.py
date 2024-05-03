import pickle
import numpy as np
from flask import Flask, request, jsonify
from waitress import serve    
# create function that predict one element
def Predict_Single_Element(element,dv,model):
    X = dv.transform([element])
    pred_Y_prob = model.predict_proba(X)[:, 1]
    pred_Y = model.predict(X)
    return pred_Y_prob[0],pred_Y

# Load The Model
with open('device-model.bin', 'rb') as f_in:
    dv, model = pickle.load(f_in)
        
# create the Flask app
app = Flask('device')
@app.route('/prediction', methods=['POST'])
def predict():
# Get the content of the request in JSON
    customer = request.get_json()
    prob,prediction = Predict_Single_Element(customer, dv, model)
    result = {
    'predict1': float( prob),
    'predict2': prediction,
    }
# Convert the response to JSON    
    return jsonify(result)

# starts the service
if __name__ == '__main__':
    serve(app,host='0.0.0.0',port=9800)
