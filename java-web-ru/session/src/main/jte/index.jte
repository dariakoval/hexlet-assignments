@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

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
<div class="mx-auto p-4 py-md-5">
    <main>
        @if(page.getName().toString().length() == 0)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @else
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <p>Hello, ${page.getName().toString()}</p>
                <input type="submit" class="btn btn-primary" value="Выйти" />
            </form>
        @endif
    </main>
</div>
</body>
</html>
