from flask import Flask
from flask_restful import Api
#from flask_restful_swagger_2 import Api
from werkzeug.contrib.fixers import ProxyFix
from flask_cors import CORS
from com.quick_loan.customer.suggestion.web.suggestion import SuggestionController, SuggestionDataSetController ,SuggestionDataTestController
app = Flask(__name__)
CORS(app)

api = Api(app , catch_all_404s=True)
#api = Api(app,api_version='0.0', api_spec_url='/api/swagger')


api.add_resource(SuggestionController, '/api/suggestion/<model_name>', endpoint="suggestion")
api.add_resource(SuggestionDataSetController, '/api/suggestion/dataset/<name>', endpoint="suggestion/dataset")

if __name__ == '__main__':
    app.run(debug=True)