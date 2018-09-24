package ch.heigvd.amt.mvcsimple.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/registrationForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        List<String> errors = new ArrayList<>();
        if (firstName == null || firstName.trim().equals("")) {
            errors.add("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().equals("")) {
            errors.add("Last name cannot be empty");
        }
        if (email == null || email.trim().equals("")) {
            errors.add("Email cannot be empty");
        } else {
            if (email.indexOf('@') == -1) {
                errors.add("Invalid format for email.");
            }
        }

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        if (errors.size() == 0) {
            request.setAttribute("fullName", firstName + " " + lastName);
            request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/registrationForm.jsp").forward(request, response);
        }

    }

}
