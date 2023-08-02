package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> companies = getCompanies();
        String queryString = request.getQueryString();
        var words = queryString.trim().split("=");
        String searchValue = words[1];

        PrintWriter out = response.getWriter();

        if (queryString == null || words.length == 1) {
            companies.stream()
                    .forEach(x -> out.println(x));
        }
        List<String> result = companies.stream()
                .filter(x -> x.contains(searchValue))
                .collect(Collectors.toList());


        if (result.isEmpty()) {
            out.println("Companies not found");
        } else {
            for (String company : result) {
                out.println(company);
            }
        }
        // END
    }
}
