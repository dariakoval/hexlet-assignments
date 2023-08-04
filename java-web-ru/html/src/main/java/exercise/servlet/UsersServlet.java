package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String path = "src/main/resources/users.json";
        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        String content = "";

        try {
            content = Files.readString(fullPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> usersList = mapper.readValue(content, new TypeReference<>() { });
        return usersList;
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        List<Map<String, String>> usersList = getUsers();

        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Users</title>
                    </head>
                    <body>
                        <table>
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>fullName</th>
                                </tr>
                            </thead>
                            <tbody>
                """);

        for (Map<String, String> user : usersList) {
            String id = user.get("id");
            String firstName = user.get("firstName");
            String lastName = user.get("lastName");

            body.append("<tr>" + "<td>").append(id).append("</td>");
            body.append("<td>" + "<a href=\"/users/4\">").append(firstName).append(" ").append(lastName);
            body.append("</a>").append("</td>").append("</tr>");
        }

        body.append("""
                            </tbody>
                        </table>
                    </body>
                </html>
                """);

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        List<Map<String, String>> usersList = getUsers();
        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>User
                """);
        body.append(id + "</title>\n" + "</head>\n" + "<body>\n");

        for (Map<String, String> user : usersList) {
            String firstName = user.get("firstName");
            String lastName = user.get("lastName");
            String email = user.get("email");

            if (user.containsValue(id)) {
                body.append("<table>" + "<thead>\n" + "<tr>\n" + "<th>id</th>\n"
                        + "<th>firstName</th>\n" + "<th>lastName</th>\n" + "<th>email</th>\n"
                        + "</tr>\n" + "</thead>\n" + "<tbody>");
                body.append("<tr>" + "<td>").append(id).append("</td>");
                body.append("<td>").append(firstName).append("</td>");
                body.append("<td>").append(lastName).append("</td>");
                body.append("<td>").append(email).append("</td>" + "</tr>");
                body.append("</tbody>" + "</table>" + "</body>" + "</html>");

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(body);
                return;
            }
        }
        response.sendError(HttpServletResponse.SC_NOT_FOUND);

        // END
    }
}
