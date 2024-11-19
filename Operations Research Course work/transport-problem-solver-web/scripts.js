function drawTable() {
    console.log('in draw table');
    const tableContainer = document.getElementById('table-container');

    while (tableContainer.lastElementChild) {
        tableContainer.removeChild(tableContainer.lastElementChild);
    }

    let rowCount = Number.parseInt(document.getElementById('suppliersCountInput').value);
    let colCount = Number.parseInt(document.getElementById('warehousesCountInput').value);

    rowCount += 2;
    colCount += 2;

    const tableElement = document.createElement('table');
    tableElement.classList.add('table');
    tableElement.classList.add('col-6');
    tableElement.classList.add('offset-2');
    //tableElement.classList.add('table-light')
    tableElement.classList.add('table-striped')


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


            } else {
                if (j === 0) {
                    const rowHeadElement = document.createElement('th');
                    rowHeadElement.innerHTML = `U${i}`;
                    rowElement.appendChild(rowHeadElement);
                } else {
                    const colElement = document.createElement('td');
                    const inputElement = document.createElement('input');
                    inputElement.type = 'number';
                    inputElement.value = 0;
                    colElement.appendChild(inputElement);
                    rowElement.appendChild(colElement);
                }
            }
        }
        tableElement.appendChild(rowElement);
    }
    tableContainer.appendChild(tableElement);
}