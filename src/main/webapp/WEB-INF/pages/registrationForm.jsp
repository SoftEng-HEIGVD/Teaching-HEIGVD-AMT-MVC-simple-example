<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Registration</title>
  </head>
  <body>
    <h2>Registration</h2>
    Please provide the following information to register:

    <form action="${pageContext.request.contextPath}/register" method="post">
      <label for="firstName">First name</label>
      <input type="text" name="firstName" value="${firstName}">
      </div>
      <div>
        <label for="lastName">Last name</label>
        <input type="text" name="lastName" value="${lastName}"/>
      </div>
      <div>
        <label for="email">Email</label>
        <input type="text" name="email" value="${email}"/>
      </div>
      <button type="submit" name="Submit">Register</button>
    </form>
    <c:if test="${errors != null}">
      Errors:
      <ul>
        <c:forEach items="${errors}" var="error">
          <li>${error}</li>
        </c:forEach>
      </ul>
    </c:if>
  </body>
</html>
