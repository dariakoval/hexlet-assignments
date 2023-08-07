<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Current user</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    </head>
    <body>
        <div class=\"container\">
            <c:forEach var="entry" items="${user.entrySet()}">
                <div>${entry.getKey()} : ${entry.getValue()}</div>
            </c:forEach>
            <a href="/users/delete?id=${user.get("id")}">Delete current user</a>
        </div>
    </body>
</html>
