import React, { useState } from 'react';
import './Control.css'
import {Button, ButtonGroup, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle} from '@mui/material';
import axios from 'axios';

function AlterControlButtons({selectedFlatRows, isOneRowSelected, isRowSelected}) {
    const [response, setResponse] = useState(0);
    axios.defaults.baseURL = 'http://localhost:8080/HRC61148WK/';
    axios.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
    axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
    axios.defaults.headers.post['Access-Control-Allow-Methods'] = '*';
    var getSlNos = (selectedFlatRows) => {
        let slnos = "";
        selectedFlatRows.map((row) => {
            slnos += (row.values['slNo']) + "-"
            return null;
        })
        slnos = slnos.slice(0, -1);
        return slnos;
    }
    var deleteData = (e) => {
        let slNos = getSlNos(selectedFlatRows);
        let message = "Delete invoice at SL NOs: " + slNos.replaceAll("-", ", ") + "?";
        let permission = window.confirm(message);
        if(permission === true){
            axios.get("http://localhost:8080/HRC61148WK/Delete?slnos=" + slNos).then(response => setResponse(response.data));
            window.location.reload(true);
        }
    }
    var editData = (e) => {
        let slNo = getSlNos(selectedFlatRows);
        let newInvoiceCurrency = "";
        let newCustomerPaymentTerm = "";
        newInvoiceCurrency = window.prompt("Enter new Invoice Currency for Sl NO: " + slNo);
        if(newInvoiceCurrency !== ""){
            newCustomerPaymentTerm = window.prompt("Enter new Customer Payment Term for Sl NO: " + slNo);
            if(newCustomerPaymentTerm !== ""){
                axios.get("http://localhost:8080/HRC61148WK/Edit?slno=" + slNo + "&invoicecurrency=" + newInvoiceCurrency + "&customerpaymentterm=" + newCustomerPaymentTerm).then(response => setResponse(response.data));
                window.location.reload(true);
            }
        }

    }
    return (
            <>
            <ButtonGroup size="large" aria-label="large button group" className='alter control'>
                <Button size='large' id='add-button' variant="outlined">ADD</Button>
                <Button size='large' id='edit-button' className='middleButton' variant="outlined" onClick={editData} disabled={!isOneRowSelected}>EDIT</Button>
                <Button size='large' id='delete-button' variant="outlined" onClick={deleteData} disabled={!isRowSelected}>DELETE</Button>
            </ButtonGroup>
            </>
        );
    }

export default AlterControlButtons;