<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BootStrap</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cardManagement.css">

</head>
<body>
<!----------------------Navbar----------------------------------------------------------------------------------------------------------------------------------------------------------->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">Opera Card</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="./jsp/main.jsp">HomePage</a></li>
                <li><a href="#">Account Management</a> </li>
                <li><a href="#">Payment</a> </li>
                <li class="active"><a href="#">Card Management</a> </li>
                <li><a href="#">About</a> </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li align="right"><a href="#">Log out</a></li>
            </ul>
        </div>
    </div>
</nav>


<!----------------------information panel----------------------------------------------------------------------------------------------------------------------------------------------------------->
<div class="container">
    <div class="starter" >
        <div class="Head">
            <h2>Card Management</h2>
        </div>

        <div class="panel panel-primary">
            <div class="panel-heading">
                Card Status
            </div>

            <div class="panel-body" id="resultTable">
                <div class="card">

                    <table class="table table-hover table-bordered table-responsive table-curved" style="width: 55%; height: auto;" align="center">
                        <tbody>
                        <tr>
                            <td align="left">Card Number:</td>
                            <td>2331 6514 3213 7642</td>
                        </tr>
                        <tr>
                            <td align="left">Card Type:</td>
                            <td>Adult</td>
                        </tr>
                        <tr>
                            <td align="left">Card Balance:</td>
                            <td>$45.00</td>
                        </tr>
                        <tr>
                            <td align="left">Card Status:</td>
                            <td>Activated</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <!----------------------Activete & Confirmation----------------------------------------------------------------------------------------------------------------------------------------------------------->
                <div align="center" style="padding: 30px;">
                    <!button type="button" class="btn btn-primary">
                    <button class="btn btn-primary btn-md" data-toggle="modal" data-target="#activeModal">
                        Activate
                    </button>
                    <div class="modal fade" id="activeModal" tabindex="-1" role="dialog" aria-labelledby="activateLabel" aria-hidden="true">

                        <div class="modal-dialog">

                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="activateLabel">
                                        <p> Activate - Review and confirm </p>
                                    </h4>
                                </div>

                                <div class="modal-body">
                                    <div>
                                        <table class="table table-hover table-bordered table-responsive" style="width: 55%; height: auto;" align="center">
                                            <tbody>
                                            <tr>
                                                <td align="left">Card Number:</td>
                                                <td>2331 6514 3213 7642</td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Type:</td>
                                                <td>Adult</td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Balance:</td>
                                                <td>$45.00</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel
                                    </button>
                                    <button type="button" class="btn btn-primary">
                                        Apply
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!----------------------Freeze Button & confirmation---------------------------------------------------------------------->

                    <button class="btn btn-default btn-md" data-toggle="modal" data-target="#freezeModal">
                        Freeze
                    </button>
                    <div class="modal fade" id="freezeModal" tabindex="-1" role="dialog" aria-labelledby="freezeLabel" aria-hidden="true">

                        <div class="modal-dialog">

                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="freezeLabel">
                                        <p>Freeze - Review and confirm</p>
                                    </h4>
                                </div>

                                <div class="modal-body">
                                    <div>
                                        <table class="table table-hover table-bordered table-responsive" style="width: 55%; height: auto;" align="center">
                                            <tbody>
                                            <tr>
                                                <td align="left">Card Number:</td>
                                                <td>2331 6514 3213 7642</td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Type:</td>
                                                <td>Adult</td>
                                            </tr>
                                            <tr>
                                                <td align="left">Card Balance:</td>
                                                <td>$45.00</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel
                                    </button>
                                    <button type="button" class="btn btn-primary">
                                        Apply
                                    </button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!----------------------pagination------------------------------------------------------------------------------------->

<div align="center">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item disabled"> <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&laquo;</a> </li>
            <li class="page-item active" aria-current="page"> <a class="page-link" href="#">1 <span class="sr-only">(current)</span></a> </li>
            <li class="page-item"> <a class="page-link" href="#">2</a> </li>
            <li class="page-item"> <a class="page-link" href="#">3</a> </li>
            <li class="page-item">
                <a class="page-link" href="#">&raquo;</a>
            </li>
        </ul>
    </nav>
</div>




</body>
</html>