<?php
    // Вариант 1:
    // $egn = [7, 9, 0, 9, 2, 8, 5, 6, 6, 1 ];
    
    // Вариант 2:
    $egn = `9907054060`;
    print(count_chars($egn, 0));
    if (count_chars($egn, 0) != 10) {
        print("Това не е валидно ЕГН!");
        exit(1);
    }

    $egnSum = 0;

    foreach ($egn as $key => $value) {
        $modifier;
        
        switch ($key) {
            case 0: $modifier = 2; break;
            case 1: $modifier = 4; break;
            case 2: $modifier = 8; break;
            case 3: $modifier = 5; break;
            case 4: $modifier = 10; break;
            case 5: $modifier = 9; break;
            case 6: $modifier = 7; break;
            case 7: $modifier = 3; break;
            case 8: $modifier = 6; break;
            default: $modifier = 0; break;
        }

        $egnSum += $modifier * $value;
    }
    $divisionResult = intdiv($egnSum, 11);

    $subtractionResult = $egnSum - ($divisionResult * 11);

    $validCondition = $subtractionResult == $egn[9];

    print("$subtractionResult <br>");

    if ($validCondition) {
        print("Това е валидно ЕГН!");
    } else {
        print("Това НЕ е валидно ЕГН!");
    }
?>