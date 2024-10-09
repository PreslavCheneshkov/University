<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Таблица за деление</title>
</head>
<body>
    <h2 align="center">Таблица за деление</h2>
    <table border="2" align="center">
        <?php
            $startNum = 1;
            $endNum = 10;
            print('<tr>');
            print('<th>&nbsp;</th>');

            for ($c1 = $startNum; $c1 <= $endNum; $c1++) {
                print("<th>$c1</th>");
            }
            for ($c1 = $startNum; $c1 <= $endNum; $c1++) {
                print("<tr><th align=right>$c1</th>");
                for ($c2 = $startNum; $c2 <= $endNum; $c2++) {
                    $res = $c1 / $c2;
                    printf("<td align=right>%.3f</td>", $res);
                }    
                print("<tr>\n");
            }
        ?>
    </table>
</body>
</html>