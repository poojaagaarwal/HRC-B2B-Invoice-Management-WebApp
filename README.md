# HRC-B2B-Invoice-Management-WebApp

This project was conducted as a task in an ***internship*** under the ***Highradius Corporation***.  
The objective was to build an ***invoice management web application which could be used in a B2B field***. 
The web application could help the seller business to keep track of all the money that are owed by buyer businesses.
<hr>

## Product Requirements Specification

### Idea about the problem-

The B2B world operates differently from the B2C or C2C world. Businesses work with other businesses on credit. When a buyer business orders goods from the seller business, 
the seller business issues an invoice for the same. This invoice for the goods contains various information like the details of the goods purchased and when it should be paid. 
This is known in accounting terminology as “Accounts Receivable”.  
  
Seller business interacts with various businesses and sells goods to all of them at various times. Hence, the seller business needs to keep track of the total amount it owes from all the buyers. 
This involves keeping track of all invoices from all the buyers. Each invoice will have various important fields like a payment due date, invoice date, invoice amount, baseline date etc.  
  
The buyer business needs to clear its amount due before the due date. However, in real-world scenarios, the invoices are not always cleared ie. paid in full amount by the due date. 
The date on which a customer clears the payment for an invoice is called the payment date.   
  
### The objectives of the Web Application is: 
- To `build a Full-stack Invoice Management Application` using Reacts, JDBC, Java, Servlets. 
- Build a `responsive` Receivables Dashboard.
- Visualize Data in the form of `grids`. 
- Visualize Data in the form of `graphs`. 
- Perform `Searching operations` on the invoices. 
- `Add & Edit data` in the editable fields of the grid. 
- `Delete data` of selected rows in predefined templates. 


### The objectives of the ML is:
- `View` the invoice data from various buyers. 
- See various fields/attributes of the invoice(s) from a particular buyer. 
Perform `Data Pre-processing` on the invoice data. 
- Recieve account-level analytics to easily visualize and interpret data- `EDA and 
Feature Engineering`. 
- Get a `prediction` of when the invoice is going to get paid.


## Navigate through the project
- [CODE FOR CLIENT(Using ReactJS)](client/src/)  
- [CODE FOR SERVER(Using JAVA)](server/src/main/java/crud/)  
- [Code ML(Using Jupyter Notebook - Python)](ML/HRC61148WK_Pooja_Agarwal_prediction.ipynb)  
- [DATASET](ML/dataset.csv?raw=true)  
- [OUTPUT DATASET ACQUIRED AFTER PERFORMING ML](ML/HRC61148WK_Pooja_Agarwal.csv?raw=true)  
- [SQL SETUP](database/H2H_Internship.sql?raw=true)

## Softwares Used
- [Visual Studio Code](https://code.visualstudio.com/): Visual Studio Code was used for developing the `front-end` of the web application using reactJS.  
- [Node.JS](https://nodejs.org/en/), [create_react_app](https://create-react-app.dev/): Node.js is an open-source, cross-platform, back-end JavaScript runtime
 environment that runs on the V8 engine and executes JavaScript code outside a web browser. `create_react_app` Node.JS package was used to set up the project to run a react application.  
- [ReactJS](https://reactjs.org/): React is a front-end JavaScript library for building user interfaces based on UI components. It was used to develop the front-end
of the web application.  
- [Eclipse](https://www.eclipse.org/), [JAVA](https://www.oracle.com/in/java/): Eclipse was used to develop the `back-end` of the web application using Java.
- [SqlYOG](https://webyog.com/product/sqlyog/): SQLYOG was used to set and manage the `database`.
- [Jupyter Notebook](https://jupyter.org/), [Anaconda Navigator](https://docs.anaconda.com/anaconda/navigator/index.html): 
Jupyter Notebook and Anaconda python environment were used to develop the code for `Machine Learning` part.
