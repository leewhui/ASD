<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/payment.css">
</head>
<body>

<h2>Payment</h2>
<p></p>
<div class="row">
    <div class="col-75">
        <div class="container">
            <form>
                <div class="row">
                    <div class="col-50">
                        <h3>Billing Address</h3>
                        <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                        <input type="text" id="fname" name="firstname" placeholder="John Smith">
                        <label for="email"><i class="fa fa-envelope"></i> Email</label>
                        <input type="text" id="email" name="email" placeholder="john.smith@gmail.com">
                        <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                        <input type="text" id="adr" name="address" placeholder="22 Jane St.">
                        <label for="city"><i class="fa fa-institution"></i> City</label>
                        <input type="text" id="city" name="city" placeholder="Sydney">

                        <div class="row">
                            <div class="col-50">
                                <label for="state">State</label>
                                <input type="text" id="state" name="state" placeholder="NSW">
                            </div>
                            <div class="col-50">
                                <label for="postcode">Postcode</label>
                                <input type="text" id="postcode" name="postcode" placeholder="2112">
                            </div>
                        </div>
                    </div>

                    <div class="col-50">
                        <h3>Card Detail</h3>
                        <label for="amount">Top up amount</label>
                        <input list="amounts" name="cardAmount" id="amount">
                        <datalist id="amounts">
                            <option value="$5">
                            <option value="$10">
                            <option value="$25">
                            <option value="$50">
                            <option value="$100">
                        </datalist>
                        <label for="cname">Name on Card</label>
                        <input type="text" id="cname" name="cardname" placeholder="John Smith">
                        <label for="ccnum">Credit card number</label>
                        <input type="text" id="ccnum" name="cardnumber" placeholder="****-****-****-****">
                        <label for="expmonth">Exp Month</label>
                        <input type="text" id="expmonth" name="expmonth" placeholder="September">
                        <div class="row">
                            <div class="col-50">
                                <label for="expyear">Exp Year</label>
                                <input type="text" id="expyear" name="expyear" placeholder="2020">
                            </div>
                            <div class="col-50">
                                <label for="cvv">CVV</label>
                                <input type="text" id="cvv" name="cvv" placeholder="***">
                            </div>
                        </div>
                    </div>

                </div>
                <label>
                    <input type="checkbox" checked="checked" name="sameadr"> allowed to Auto Recharge when Remain card balance below $5
                </label>
                <input type="submit" value="Confirm" class="btn">
            </form>
        </div>
    </div>
    <div class="col-25">
        <div class="container">
            <h4>Select cards <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> Remain balance </span></h4>
            <p><input type="checkbox"  id="opalCard1" value=""> opalCard1<span class="price">$20</span></p>
            <p><input type="checkbox"  id="opalCard2" value=""> opalCard2<span class="price">$15</span></p>
            <p><input type="checkbox"  id="opalCard3" value=""> opalCard3<span class="price">$10</span></p>
            <p><input type="checkbox"  id="opalCard4" value=""> opalCard4<span class="price">$5</span></p>
        </div>
    </div>
</div>

</body>
</html>
