<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Къде може да гледате филм, в който участва Keanu Reeves</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<?php
    include("db.php");

    $query = "SELECT cinemas.CinemaName, cinemas.Address, projections.Price, actorsMovies.Role, projections.DateTime FROM cinemas, projections, movies, actorsMovies, actors 
    WHERE actors.ActorName = 'Keanu Reeves' 
    AND actorsMovies.ActorId = actors.Id 
    AND actorsMovies.MovieId = movies.Id 
    AND projections.MovieId = movies.Id 
    AND projections.CinemaId = cinemas.Id;
";
    $res = mysqli_query($sql, $query);

    print('<h1 class="col-4 offset-4">Къде може да гледате филм, в който участва Keanu Reeves</h1>');
    print('<br>');

    print('<table class="table col-8 offset-2">');
    print('
        <tr>
            <th>КиноАрена</th>
            <th>Адрес</th>
            <th>Дата и час на прожекция</th>
            <th>Keanu Reeves ще е в ролята на:</th>
            <th>Цена</th>
        </tr>');
    
    while ($row = mysqli_fetch_array($res)) {
        echo '
        <tr>
            <td>',$row[0],' </td>
            <td>',$row[1],' </td>
            <td>',$row[4],' </td>
            <td>',$row[3],' </td>
            <td>',$row[2],' </td>
        </tr>';

    }
    print("</table>");
    
?>
    <a class="col-4 offset-4" href="http://localhost/php-with-db/home.php">Обратно</a>
</body>
</html>

