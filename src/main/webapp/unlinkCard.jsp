<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2020/8/26
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>LinkCard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container-md bg-default p-3">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <div class="card">
                <div class="card-body">
                    <%
                        if (request.getParameter("error") != null) {
                    %>
                    <div class="alert alert-danger"><%=request.getParameter("error")%></div>
                    <%}%>
                    <form action="linkController" method="POST">
                        <div class="form-group">
                            <label>Card Number</label>
                            <input type="text" class="form-control" name="cardNumber">
                            <input type="hidden" class="form-control" name="action" value="unlink">
                        </div>
                        <button type="submit" class="btn btn-danger">Unlink</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
