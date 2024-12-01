const rows = [];
const deliveryValues = [];
const warehouseValues = [];
let realRowCount = 0;
let realColCount = 0;

function drawTable() {
    console.log('in draw table');
    const tableContainer = document.getElementById('table-container');

    while (tableContainer.lastElementChild) {
        tableContainer.removeChild(tableContainer.lastElementChild);
    }

    let rowCount = Number.parseInt(document.getElementById('suppliersCountInput').value);
    let colCount = Number.parseInt(document.getElementById('warehousesCountInput').value);
    realRowCount = rowCount;
    realColCount = colCount;
    rowCount += 2;
    colCount += 1;

    const tableElement = document.createElement('table');
    tableElement.classList.add('table');
    tableElement.classList.add('col-6');
    tableElement.classList.add('offset-3');
    tableElement.classList.add('table-striped')
    tableElement.id = 'inputTable';


    for (let i = 0; i < rowCount; i++) {
        const rowElement = document.createElement('tr');

        for (let j = 0; j < colCount; j++) {

            if (i === 0) {
                const headElement = document.createElement('th');

                if (j === 0) {
                    headElement.innerHTML = '<sub>ui</sub>\\<sup>vj</sup>';
                } else {
                    headElement.innerHTML = `V${j}`;
                }
                rowElement.appendChild(headElement);

            } 
            else {
                if (j === 0) {
                    const rowHeadElement = document.createElement('th');
                    rowHeadElement.innerHTML = i === rowCount - 1 ? '' : `U${i}`;
                    rowElement.appendChild(rowHeadElement);
                }
                else {
                    const colElement = document.createElement('td');
                    if (i === rowCount - 1) {
                        colElement.innerHTML = `Склад ${j}:  `;
                        colElement.appendChild(createInputElement('warehouseValue'));
                    } else {
                        const inputRouteWeightElement = createInputElement('routeWeight');
                        inputRouteWeightElement.id = `${i}-${j}`;
                        colElement.appendChild(inputRouteWeightElement);
                    }
                    rowElement.appendChild(colElement);
                }
            }
        }
        const wareHouseElement = document.createElement('th');
        let lastCellText;
        let addInput = false;
        switch (i) {
            case 0: lastCellText = 'Доставчици'; break;
            case rowCount - 1: lastCellText = ''; break;
            default: lastCellText = `Доставчик ${i}:  `; addInput = true; break;
        }
        wareHouseElement.innerHTML = lastCellText;
        if (addInput) {
            wareHouseElement.appendChild(createInputElement('deliveryValue'));
        }

        rowElement.appendChild(wareHouseElement);

        tableElement.appendChild(rowElement);
    }

    tableContainer.appendChild(tableElement);

    const calculateButtonElement = document.getElementById('calculateButton');
    calculateButtonElement.hidden = false;
}

function solve() {
    resetVariables();

    const deliveryValueElements = document.getElementsByClassName('deliveryValue');
    for (const element of deliveryValueElements) {
        deliveryValues.push({
            amount: element.value,
            isFinished: false
        });
    }

    for (let i = 0; i < deliveryValues.length; i++) {
        console.log(`Delivery value ${i}: ${deliveryValues[i].amount}`);
        console.log(`Is finished ${i}: ${deliveryValues[i].isFinished}`);
        
    }

    const warehouseValueElements = document.getElementsByClassName('warehouseValue');
    for (const element of warehouseValueElements) {
        warehouseValues.push(element.value);
    }

    const routeWeightElements = document.getElementsByClassName('routeWeight');
    let currentCols = 0;
    let currentRows = 0;
    for (const element of routeWeightElements) {
        const weight = element.value;
        const position = element.id;
        console.log(weight);
        console.log(position);
    }
}

function resetVariables() {
    deliveryValues.length = 0;
    warehouseValues.length = 0;
    rows.length = 0;
}

function createInputElement(type) {
    const inputElement = document.createElement('input');
    inputElement.type = 'number';
    inputElement.value = 0;
    inputElement.classList.add(type);
    return inputElement;
}