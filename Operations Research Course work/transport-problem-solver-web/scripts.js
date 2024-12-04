const rows = [];
const deliveryValues = [];
const warehouseValues = [];
let realRowCount = 0;
let realColCount = 0;
const routeWeights = [];

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

    // reset
    routeWeights.length = 0;

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
                        routeWeights.push({
                            row: i,
                            col: j,
                            // add value in solve()    
                        });
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

    let deliverySum = 0;
    let warehouseSum = 0;

    for (const element of deliveryValueElements) {
        deliveryValues.push({
            amount: element.value,
            isFinished: false
        });
        deliverySum += element.value;
    }

    const warehouseValueElements = document.getElementsByClassName('warehouseValue');
    for (const element of warehouseValueElements) {
        warehouseValues.push(element.value);
        warehouseSum += element.value;    
    }

    if (warehouseSum > deliverySum) {
        // TODO: handle
    }

    const routeWeightElements = document.getElementsByClassName('routeWeight');
    let currentCol = 0;
    let currentRow = 0;

    const routeValues = [ [] ];
    
    for (let i = 0; i < routeWeightElements.length; i++) {
        routeWeights[i].value = routeWeightElements[i].value;
        routeValues[currentCol].push(NaN);
        currentCol++;
        if (routeWeights[i].row != currentRow) {
            currentRow++;
            currentCol = 0;
            routeValues.push([]);
        }
    }

    // North-West angle:
    routeValues[0][0] = deliveryValues[0].amount  


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