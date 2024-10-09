<?php
    $day = date("Y-M-D");
    print("$day"." year<br>");

    //вариант 1:
    // $dd = substr($day, 9, 3);

    //вариант 2:
    $dd = substr($day, 0, 3);

    switch ($dd) {
        case 'Mon': print('Днес е понеделник'); break;
        case 'Tue': print('Днес е вторник'); break;
        case 'Wed': print('Днес е сряда'); break;
        case 'Thu': print('Днес е четвъртък'); break;
        case 'Fri': print('Днес е петък'); break;
        case 'Sat': print('Днес е събота'); break;
        case 'Sun': print('Днес е неделя'); break;
        default: print('Денят от седмицата не може да се определи! :-)');
    }
?>