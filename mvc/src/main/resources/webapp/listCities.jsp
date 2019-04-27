<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cities</title>
    </head>
    <body>
        <h2>Cities</h2>

        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Population</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${cities}" var="city">
                <tr>
                    <td>${city.id}</td>
                    <td>${city.name}</td>
                    <td>${city.population}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>