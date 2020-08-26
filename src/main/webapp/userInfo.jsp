<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2020/8/26
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/userInfo.css">
</head>
<body>

<div class="container bootstrap snippets bootdey">
    <div class="row ng-scope">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body text-center">
                    <div class="pv-lg"></div>
                    <h3 class="m0 text-bold">Shuo Zhang</h3>
                    <div class="mv-lg">
                        <p>Hello, Have fun!</p>
                    </div>
                    <!--           button         -->
                    <div class="text-center"><a class="btn btn-primary" href="linkCard.jsp">Link Card</a></div>
                </div>
            </div>
            <div class="panel panel-default hidden-xs hidden-sm">
                <div class="panel-heading">
                    <div class="panel-title text-center">Your Card</div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="h4 text-center">User Profile</div>
                    <div class="row pv-lg">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-8">
                            <form class="form-horizontal ng-pristine ng-valid">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact1">Name</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact1" type="text" placeholder="" value="Shuo Zhang">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact2">Email</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact2" type="email" value="mail@example.com">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact3">Password</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact3" type="text" value="*********">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact4">Phone</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact4" type="text" value="(12) 123 987 465">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact5">Mobile</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact5" type="text" value="(61) 045 9876 465">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact6">Address</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" id="inputContact6" row="4">109 Street, 1234</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact7">Postcode</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact7" type="text" value="2220">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label" for="inputContact8">Company</label>
                                    <div class="col-sm-10">
                                        <input class="form-control" id="inputContact8" type="text" placeholder="No Company">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button class="btn btn-info" type="submit">Update</button>
                                    </div>
                                </div>
                            </form>
                            <div class="text-right"><a class="btn btn-primary" href="/main.jsp">Main Page</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>


</body>
</html>
