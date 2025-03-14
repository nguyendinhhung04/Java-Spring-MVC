<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>

                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link href="/css/demo.css" rel="stylesheet"> -->

            </head>

            <body>
                <div class="container mt-5 d-flex justify-content-between align-items-center border-bottom pb-2">
                    <h2 class="fw-bold">Table users</h2>
                    <a href="/user/create">
                        <button class="btn btn-primary">Create a user</button>
                    </a>
                </div>
                <div class="container mt-5">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Email</th>
                                <th scope="col">FullName</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td class="col-1">${user.id}</td>
                                    <td class="col-3">${user.email}</td>
                                    <td class="col-3">${user.fullname}</td>
                                    <td class="col">
                                        <a href="/admin/user/view/${user.id}">
                                            <button class="btn btn-secondary">View</button>
                                        </a>
                                        <a href="/admin/user/modify/${user.id}">
                                            <button class="btn btn-warning">Modify</button>
                                        </a>
                                        <a href="https://example.com">
                                            <button class="btn btn-danger">Delete</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </body>

            </html>