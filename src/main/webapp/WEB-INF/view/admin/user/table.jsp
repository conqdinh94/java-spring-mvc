<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>

<body>
    <div class="container mt-5">
        <div class="row">
            <div class="d-flex justify-content-between">
                <h3>Table users</h3>
                <a href="/admin/user/create" class="btn btn-primary d-flex align-item-center">Create a User</a>
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
                <tr>
                    <td>1</td>
                    <td>nguyenvana@gmail.com</td>
                    <td>Nguyen Van A</td>
                    <td>
                        <button class="btn btn-primary">View</button>
                        <button class="btn btn-warning">Update</button>
                        <button class="btn btn-danger">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>tranvanb@gmail.com</td>
                    <td>Tran Van B</td>
                    <td>
                        <button class="btn btn-primary">View</button>
                        <button class="btn btn-warning">Update</button>
                        <button class="btn btn-danger">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</body>

</html>