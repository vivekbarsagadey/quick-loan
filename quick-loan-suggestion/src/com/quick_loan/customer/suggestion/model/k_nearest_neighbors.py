import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import codecs, json

from com.quick_loan.customer.suggestion.domain.computation import Computation
from com.quick_loan.customer.suggestion.services.data_handler import CustomerDataSet


from sklearn.neighbors import KNeighborsClassifier

from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score
from sklearn.metrics import accuracy_score



class KNearestNeighborsModel():
    def __init__(self):
        self.dataDataSet = CustomerDataSet()
        self.data = self.dataDataSet.getDataSet()
        self.knnmodel =  KNeighborsClassifier()
        self.X_train, self.X_test, self.y_train, self.y_test = train_test_split(self.dataDataSet.getX(),
                                                                                self.dataDataSet.getY(),
                                                                                stratify=self.data.Loan_Status,
                                                                                random_state=0)
        self.train()

    def train(self):
        self.knnmodel.fit(self.X_train, self.y_train)



    def predict(self):
        #print(json.dumps({'columns' : diabetes.columns} , cls=NumpyEncoder))
        self.y_pred = self.knnmodel.predict(self.X_test)
        return Computation("KNN",accuracy_score(self.y_test, self.y_pred)).__dict__
