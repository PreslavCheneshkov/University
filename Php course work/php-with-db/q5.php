<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Къде можете да гледате Sci-Fi филм</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<?php
    include("db.php");

    $query = "SELECT * FROM cinemas, projections, movies, actorsMovies, actors 
    WHERE movies.Category = 'Sci-Fi' 
    AND projections.CinemaId = cinemas.Id 
    AND projections.MovieId = movies.Id 
    AND actorsMovies.MovieId = movies.Id 
    AND actorsMovies.ActorId = actors.Id;
";
    $res = mysqli_query($sql, $query);

    print('<h1 class="col-4 offset-4">Къде можете да гледате Sci-Fi филм</h1>');
    print('<br>');

    print('<table class="table col-8 offset-2">');
    print('
        <tr>
            <th>Филм</th>
            <th>КиноАрена</th>
            <th>Адрес</th>
            <th>Дата и час на прожекция</th>
            <th>Директор</th>
            <th>Цена</th>
        </tr>');
    
    while ($row = mysqli_fetch_array($res)) {
        echo '
        <tr>
            <td>',$row[8],' </td>
            <td>',$row[1],' </td>
            <td>',$row[4],' </td>
            <td>',$row[5],' </td>
            <td>',$row[10],' </td>
            <td>',$row[6],' </td>
        </tr>';

    }
    print("</table>");
    
?>
    <a class="col-4 offset-4" href="http://localhost/php-with-db/home.php">Обратно</a>
</body>
</html>

