<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail ${id}</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="d-flex justify-content-between">
                            <h3>User information with id = ${id}</h3>
                        </div>
                    </div>

                    <hr>

                    <table class="table table-hover table-bordered" style="width: 40%;">
                        <tbody>
                            <tr>
                                <td>ID:</td>
                                <td>${user.id}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${user.email}</td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>${user.phone}</td>
                            </tr>
                            <tr>
                                <td>FullName:</td>
                                <td>${user.fullName}</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>${user.address}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </body>

            </html>