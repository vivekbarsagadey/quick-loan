from flask import Flask, jsonify, request
from flask_restful import Resource, reqparse
from com.quick_loan.customer.suggestion.model.models import AllModels

import pandas as pd

from com.quick_loan.customer.suggestion.domain.user import User
from com.quick_loan.customer.suggestion.model.k_nearest_neighbors import KNearestNeighborsModel
from com.quick_loan.customer.suggestion.services.data_handler import CustomerDataSet


#parser = reqparse.RequestParser()
#parser.add_argument('firstName', type=str, location='json')

class SuggestionController(Resource):
    '''@swagger.doc({
        'tags': ['SuggestionController'],
        'description': 'Returns a Diabetes data',
        'parameters': [
            {
                'model_name': 'all',
                'description': 'which model is going to use'
            }
        ],
        'responses': {
            '200': {
                'description': 'User',
                'examples': {
                    'application/json': {
                        'data': 'all'
                    }
                }
            }
        }
    })'''
    def get(self, model_name = "all"):
        if model_name == 'knn':
            return KNearestNeighborsModel().predict()
        else:
            return AllModels().predictAll()

    def post(self , model_name = "all"):
        json_data = request.get_json(force=True)
        print(json_data)
        user = User(json_data)
        print("user is ",user)
        mod = AllModels()
        userDataFrame=user.getFrame()
        if model_name == 'knn':
            return KNearestNeighborsModel().predict()
        else:
            return AllModels().predict(userDataFrame)

class SuggestionDataTestController(Resource):
    def post(self ):
        json_data = request.get_json(force=True)
        #args = parser.parse_args()
        print(json_data)
        #print(args['firstName'])
        return {"name":"test"}

class SuggestionDataSetController(Resource):
    def get(self , name = "header"):
        if name == 'header':
            return CustomerDataSet().getColumns()
        elif name == 'shape' :
            return CustomerDataSet().getDataShape()
        elif name == 'describe' :
            return CustomerDataSet().getDescribe()
        elif name == 'data' :
            return CustomerDataSet().getData()
        else:
            return CustomerDataSet().getData()
