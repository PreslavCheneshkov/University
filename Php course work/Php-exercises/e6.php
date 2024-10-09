<?php
    // Вариант 1:
    // $cars[1] = 'Лада';
    // $cars[4] = 'Mercedes';
    // $cars[] = 'Ford';

    // Вариант 2:
    // $cars[] = 'Ford';
    // $cars[1] = 'Лада';
    // $cars[4] = 'Mercedes';

    // Вариант 1:
    $cars[1] = 'Лада';
    $cars[] = 'Ford';
    $cars[4] = 'Mercedes';

    print("Извеждане на първите 10 елемента на масива cars<br>");
    for ($i = 0; $i < 10; $i++) {
        if (isset($cars[$i])) {
            print("cars[$i] = $cars[$i]<br>");
        } else {
            print("cars[$i] = <br>");
        }
    }
    print("<br>");
    print("Извеждане само на заредените елементи в масива cars<br>");
    for ($i = 0; $i < 10; $i++) {
        if (isset($cars[$i])) {
            print("cars[$i] = $cars[$i]<br>");    
        }
    }
?>