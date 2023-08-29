@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

<!-- BEGIN -->
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
@if (page.getName() != null)
    <h1 class="mb-3"> Добро пожаловать, ${page.getName().toString()}</h1>
    <form action="${NamedRoutes.logoutPath()}" method="post">
        <input type="submit" value="Выйти">
    </form>
@else
    <h1 class="mb-3"> Добро пожаловать, гость</h1>
    <form action="${NamedRoutes.buildSessionPath()}" method="get">
        <input type="submit" value="Войти">
    </form>
@endif
</body>
</html>
<!-- END -->
