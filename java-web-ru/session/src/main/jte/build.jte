@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

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
@if(page.getError().length() != 0)
    <div class="mb-3">
        <p>${page.getError()}</p>
    </div>
@endif

<div class="mx-auto p-4 py-md-5">
    <form action="${NamedRoutes.loginPath()}" method="post">
        <div class="mb-3">
            <label class="form-label">
                Имя
                <input type="text" class="form-control" name="name" value="${page.getName()}" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Пароль
                <input type="text" class="form-control" name="password" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить" />
    </form>
</div>
</body>
</html>
