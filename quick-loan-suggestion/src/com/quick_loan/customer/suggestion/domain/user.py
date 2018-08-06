import pandas as pd


class User:
    def __init__(self ,org={}):
        self.Loan_ID = org['Loan_ID']
        self.Married = org['Married']
        self.Dependents = org['Dependents']
        self.Self_Employed = org['Self_Employed']
        self.ApplicantIncome = org['ApplicantIncome']
        self.LoanAmount = org['LoanAmount']
        self.Loan_Status=0

    def __str__(self):
        return str(self.__dict__)

    def getFrame(self ):

        return pd.DataFrame(
            {'Loan_ID': self.Loan_ID, 'Married': self.Married, 'Dependents': self.Dependents, 'Self_Employed': self.Self_Employed,
             'ApplicantIncome': self.ApplicantIncome, 'LoanAmount': self.LoanAmount,
             }, index=[0])

