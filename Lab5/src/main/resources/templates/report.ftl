<!DOCTYPE html>
<html>
<head>
    <title>Catalog Report</title>
</head>
<body>
<h1>My Bibliography Catalog</h1>
<ul>
    <#list items as item>
        <li><b>${item.title}</b> by ${item.author} (${item.year}) - <a href="${item.location}">Link</a></li>
    </#list>
</ul>
</body>
</html>