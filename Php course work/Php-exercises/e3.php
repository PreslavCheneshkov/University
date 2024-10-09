<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>Hi, 
        <?php
            $firstName="Александър";
            $lastName="Петров";
            $title="Г-н";
            print("$title $lastName. "); 
        ?>
        Мога ли да Ви наричам
        <?php
            Print("$firstName");
        ?>
        ?
    </p>
</body>
</html>