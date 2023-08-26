@import exercise.dto.articles.NewArticlePage
@param NewArticlePage page

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
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>
                            ${error.getMessage()}
                        </li>
                    @endfor
                @endfor
            </ul>
        @endif

        <form action="/articles" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Название статьи
                    <input type="text" class="form-control" required name="title" value="${page.getTitle()}" />
                </label>
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">
                    Содержимое статьи
                    <textarea id="content" class="form-control" required name="content" rows="5" cols="33">
                        ${page.getContent()}
                    </textarea>
                </label>
            </div>
            <input type="submit" class="btn btn-primary" value="Создать" />
        </form>
    </div>
</body>
</html>
