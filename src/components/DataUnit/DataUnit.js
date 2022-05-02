import './DataUnit.css'
import React, { useState } from 'react';
import ControlPanel from '../ControlPanel/ControlPanel'
import TableUnit from './Table/TableUnit';

export default function DataUnit(props) {

    const [selectedFlatRows, setSelectedFlatRows] = useState([]);
    const [isOneRowSelected, setIsOneRowSelected] = useState(false);
    const [isRowSelected, setIsRowSelected] = useState(false);
    const [updateTable, setUpdateTable] = useState(false);

    return (
        <div className='dataUnit'>
            <ControlPanel selectedFlatRows={selectedFlatRows} isOneRowSelected={isOneRowSelected} isRowSelected={isRowSelected} setUpdateTable={setUpdateTable}/>
            <TableUnit setSelectedFlatRows={setSelectedFlatRows} setIsOneRowSelected={setIsOneRowSelected} setIsRowSelected={setIsRowSelected} updateTable={updateTable}/>
        </div>
    );
}