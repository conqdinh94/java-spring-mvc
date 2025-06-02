<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
                    crossorigin="anonymous">
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="d-flex justify-content-between">
                            <h3>Table users</h3>
                            <a href="/admin/user/create" class="btn btn-primary d-flex align-item-center">Create a
                                User</a>
                        </div>
                    </div>

                    <hr>

                    <table class="table table-hover table-bordered">
                        <thead>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Full Name</th>
                            <th>Action</th>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${listUser}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>
                                        <a class="btn btn-success" href="/admin/user/${user.id}">View</a>
                                        <a class="btn btn-warning" href="/admin/user/update/${user.id}">Update</a>
                                        <a class="btn btn-danger" href="/admin/user/delete/${user.id}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </body>

            </html>