<?php
    // Вариант 1:
    // $array = [4, -18, 7, 200, -66, 9];
    
    // Вариант 2:
    //$array = [-4, -18, -7, -200, -66, -9];

    // Вариант 3:
    $array = [10, 10, 10, 10, 10];

    $sum = 0;
    $positiveCount = 0;

    foreach ($array as $key => $value) {
        if ($value > 0) {
            $positiveCount++;
            $sum += $value;
        }    
    }

    if ($positiveCount == 0) {
        print('Няма нито едно положително число в този масив.');    
    } else {
        $positiveAverage = $sum / $positiveCount;
        print("Средноаритметичното на положителните числа от дадения масив е равно на $positiveAverage");
    }
?>