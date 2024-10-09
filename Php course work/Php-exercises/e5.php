<?php
    $fruit[1] = 5.6;
    $fruit[7] = 'banana';
    $fruit[] = 'pear';
    print("Извеждане на първите 9 елемента на масива<br>");
    for($i=1; $i <= 9; $i++) {
        if (Empty($fruit[$i])) {
            print("fruit[$i]=<br>");
        } else {
            print("fruit[$i] = $fruit[$i]<br>");
        }
    }
    print("Извеждане само на заредените елементи от масива <br>");
    for($i= 1; $i <= 9; $i++) {
        if (IsSet($fruit[$i])) {
            print("fruit[$i] = $fruit[$i]<br>");
        }
    }
    $sizeOfFruit = sizeof($fruit);
    print("Използване на sizeof()<br>Броят на елементите е => $sizeOfFruit<br>");
        
    print("<font color=blue>Изтривам елемента $fruit[7]</font><br>");
    unset($fruit[7]);
    $sizeOfFruit = sizeof($fruit);
    print("Използване на count()<br>Броят на елементите е => $sizeOfFruit<br>");

    $states = array(
        'България' => 'София',
        'Англия' => 'Лондон',
        'Франция' => 'Париж',
        'Германия' => 'Берлин'
    );

    foreach($states as $key => $value) {
        print("Столицата на <font color=red><b>$key</b></font> е <font color=green><b>$value</b></font><br>");
    }
?>