<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Списък на всички прожекции в КиноАрена Русе</title>
</head>
<body>
<?php
    include("db.php");

    $query = "SELECT * FROM cinemas, projections, movies 
    WHERE projections.CinemaId = cinemas.Id 
    AND cinemas.CinemaName = 'KinoArena Ruse' 
    AND movies.ID = projections.MovieID;";
    $res = mysqli_query($sql, $query);

    print('<h1 class="col-6 offset-3">Списък на всички прожекции в КиноАрена Русе</h1>');
    print('<br>');

    print('<table class="table col-6 offset-3">');
    print('
        <tr>
            <th>Име на филм</th>
            <th>Дата и час на прожекцията</th>
            <th>Категория</th>
            <th>Цена</th>
        </tr>');
    
    while ($row = mysqli_fetch_array($res)) {
        echo '
        <tr>
            <td>',$row[8],' </td>
            <td>',$row[5],' </td>
            <td>',$row[9],' </td>
            <td>',$row[6],' </td>
        </tr>';

    }
    print("</table>");
    
?>
    <a class="col-4 offset-4" href="http://localhost/php-with-db/home.php">Обратно</a>
</body>
</html>