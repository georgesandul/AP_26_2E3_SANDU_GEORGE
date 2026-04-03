<!DOCTYPE html>
<html>
<head>
    <title>Movie Database Report</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<h1>Official Movie Report</h1>
<table>
    <tr>
        <th>Title</th>
        <th>Release Date</th>
        <th>Score</th>
        <th>Genre</th>
    </tr>
    <#list movies as movie>
        <tr>
            <td>${movie.title}</td>
            <td>${movie.release_date}</td>
            <td>${movie.score}</td>
            <td>${movie.genre}</td>
        </tr>
    </#list>
</table>
</body>
</html>