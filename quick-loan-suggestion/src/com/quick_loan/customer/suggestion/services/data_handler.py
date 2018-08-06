import pandas as pd
import numpy as np
import codecs, json


df = pd.read_csv('com/quick_loan/customer/suggestion/data/loan_data_final.csv')
feature_names = ['Loan_ID', 'Married', 'Dependents', 'Self_Employed', 'ApplicantIncome', 'LoanAmount']


print("Loan data set columns :{}".format(df.columns))

def cleanData() :
    df.isna().sum()
    df.isnull().sum()

def show():
    print("Loan data set columns :{}".format(df.columns))
    #print("Diabetes data set describe :{}".format(df.describe))

def init():
    cleanData()
    show()

init()


class NumpyEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, np.ndarray):
            return obj.tolist()
        return json.JSONEncoder.default(self, obj)

class CustomerDataSet():

    def getDataSet(self):
        return df

    def getData(self):
        #print(json.dumps({'columns' : diabetes.columns} , cls=NumpyEncoder))
        return self.getDataSet().to_json(orient='split')

    def getDataShape(self):
        #return  json.dumps({'shape' : self.getData().shape} , cls=NumpyEncoder)
        print("Loan data set dimensions :{}".format(self.getDataSet().shape))
        return {'shape' : self.getDataSet().shape}

    def getDescribe(self):
        #return  json.dumps({'shape' : self.getData().shape} , cls=NumpyEncoder)
        print("Loan data set dimensions :{}".format(self.getDataSet().describe))
        return {'describe' : self.getDataSet().columns}


    def getX(self):
        return self.getDataSet()[feature_names]

    def getXByDataFrame(self , df):
        return df[feature_names]


    def getY(self):
        return self.getDataSet().Loan_Status

    def getColumns(self):
        #print(json.dumps({'columns' : diabetes.columns} , cls=NumpyEncoder))
        return self.getDataSet().to_json(orient='split')