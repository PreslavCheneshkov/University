<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Актьори в Interstellar</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<?php
    include("db.php");

    $query = "SELECT ActorName, Role
FROM actors, actorsMovies, movies
WHERE movies.MovieName = 'Interstellar'
AND actorsMovies.ActorId = actors.Id
AND actorsMovies.MovieId = movies.Id;";
    $res = mysqli_query($sql, $query);

    print('<h1 class="col-4 offset-4">Всички актьори, които участват в Interstellar</h1>');
    print('<br>');

    print('<table class="table col-4 offset-4">');
    print('
        <tr>
            <th>Име на актьор</th>
            <th>Роля</th>
        </tr>');
    
    while ($row = mysqli_fetch_array($res)) {
        echo '
        <tr>
            <td>',$row[0],' </td>
            <td>',$row[1],' </td>
        </tr>';

    }
    print("</table>");
    
?>
    <a class="col-4 offset-4" href="http://localhost/php-with-db/home.php">Обратно</a>
</body>
</html>

