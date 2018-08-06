import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import codecs, json

from com.quick_loan.customer.suggestion.domain.computation import Computation
from com.quick_loan.customer.suggestion.services.data_handler import CustomerDataSet





from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.ensemble import RandomForestClassifier
from sklearn.ensemble import GradientBoostingClassifier


from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.metrics import accuracy_score

models = []

models.append(('KNeighborsClassifier', KNeighborsClassifier()))
models.append(('SVC', SVC()))
models.append(('LogisticRegression', LogisticRegression()))
models.append(('DecisionTreeClassifier', DecisionTreeClassifier()))
models.append(('GaussianNB', GaussianNB()))
models.append(('RandomForestClassifier', RandomForestClassifier()))
models.append(('GradientBoostingClassifier', GradientBoostingClassifier()))

class AllModels():
    def __init__(self):
        self.dataDataSet = CustomerDataSet()
        self.data = self.dataDataSet.getDataSet()
        self.X_train, self.X_test, self.y_train, self.y_test = train_test_split(self.dataDataSet.getX(), self.dataDataSet.getY(),
                                                            stratify=self.data.Loan_Status, random_state=0)
        self.train()

    def train(self):
        names = []
        scores = []
        for name, model in models:
            model.fit(self.dataDataSet.getX(), self.dataDataSet.getY())


    def predictAll(self):
        #print(json.dumps({'columns' : diabetes.columns} , cls=NumpyEncoder))
        names = []
        scores = []
        computationList = []
        for name, model in models:
            self.y_pred = model.predict(self.X_test)
            scores.append(accuracy_score(self.y_test, self.y_pred))
            names.append(name)
            computationList.append(Computation(name,accuracy_score(self.y_test, self.y_pred)).__dict__)

        #tr_split = pd.DataFrame({'Name': names, 'Score': scores})
        #print(tr_split)
        #print(tr_split.values)
        return computationList
        #return tr_split.to_json(orient='split')

    def predict(self , x = {}):
        #print(json.dumps({'columns' : diabetes.columns} , cls=NumpyEncoder))
        names = []
        scores = []
        computationList = []
        print("x",x)
        for name, model in models:
            y_pred = model.predict( self.dataDataSet.getXByDataFrame(x) )
            print("y_pred", y_pred)
            computationList.append(Computation(name,pred = str(y_pred[0])).__dict__)
        return computationList
