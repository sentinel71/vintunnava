<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Trip to Paradise </title>
	<!-- Bootstrap -->
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" type="text/css" href="resources/css/booking.css">
	<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:300' rel='stylesheet' type='text/css'>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <header class="navbar navbar-inverse " role="navigation">
    <div class="container">
     <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
       <span class="sr-only">Toggle navigation</span>
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
     </button>
     <a class="navbar-brand" href="#"><img src="resources/img/logo.png" class="logo"></a>
   </div>
   <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav">
     <li class="active"><a href="#">Home</a></li>
     <li><a href="#" data-toggle="modal" data-target="#aboutModal">About</a></li>
     <!-- About Modal-->
     <div class="modal fade" id="aboutModal" tabindex="-1" role="dialog" aria-labelledby="aboutModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">About</h4>
          </div>
          <div class="modal-body">
          </div>
        </div>
      </div>
    </div>

    <li><a href="#">Blog</a></li>
    <li><a href="#" data-toggle="modal" data-target="#contactModal">Contact</a></li>
    <!-- Contact Modal-->
    <div class="modal fade" id="contactModal" tabindex="-1" role="dialog" aria-labelledby="contactModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">Contact</h4>
          </div>
          <div class="modal-body">
          </div>
        </div>
      </div>
    </div>

  </ul>



  <ul class="nav navbar-nav navbar-right">
  <c:choose>
 <c:when test="${loggedInUser=='yes'}"> 
   <li class="dropdown ">
    <a href="#" class="dropdown-toggle user" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
      <li><a href="${pageContext.request.contextPath}/bookingHistory">Booking History</a></li>
      <li class="divider"></li>
      <li><a href="#">Change Password</a></li>
      <li class="divider"></li>
      <li><a id="logoutLink" href="${pageContext.request.contextPath}/logout">Log Out</a></li>

    </ul>
  </li>
  </c:when>
  <c:otherwise> 
  	<button id="loginSignUpButton" class="btn btn-primary btn-login" data-toggle="modal" data-target="#authModal">Log In  |  Sign Up</button>
  </c:otherwise>
</c:choose>
  <!-- Authentication Modal-->

  <div class="modal fade " id="authModal" tabindex="-1" role="dialog" aria-labelledby="authModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">

        <div class="modal-body">
          <!-- Nav tabs -->
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <ul class="nav nav-tabs tabs">
            <li class="active"><a href="#login" data-toggle="tab">Log In</a></li>
            <li><a href="#signup" data-toggle="tab">Sign Up</a></li>
          </ul>

          <!-- Tab panes -->
          <div class="tab-content">
            <div class="tab-pane  active" id="login">
              <div class="row login_form" >
                <div class="col-md-5 ">
                 <form id="loginform" action="login"  method="post">
					  <input id="loginEmail" type="text" class="form-control" placeholder="Email" name="loginEmail" required="required"/>
                      <input id="loginPassword" type="password" class="form-control" placeholder="Password" name="loginPassword" required="required"/>
                      <p id="loginmessage"></p>
                      <label class="checkbox">
                        <input id="loginCheckbox" type="checkbox" value="remember-me"> Remember me
                      </label>
                      <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
                   </form>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-5">
                 <button class="btn btn-lg btn-primary btn-block btn-fb" >Log in with Facebook</button>
                 <button class="btn btn-lg btn-primary btn-block btn-g" >Log in with Google</button>
                 <button class="btn btn-lg btn-primary btn-block btn-t" >Log in with Twitter</button>
               </div>
             </div>
           </div>

           <div class="tab-pane " id="signup">
            <div class="row login_form" >
              <div class="col-md-5 ">
                <form id="signupform" method="post" action="signup">
                  <input id="signupemail" type="email" class="form-control" placeholder="Email" name="signupemail" required="required" />
                  <input id="signuppword" type="password" class="form-control" placeholder="Password" name="signuppword" required="required"/>
                  <p id="message"></p>
                  <label class="checkbox" style="font-size: 10px;">
                        <input id="signupCheckbox" type="checkbox" value="policy-adhere" required="required"> I agree to the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a>
                  </label>
                  <button id="signupButton" class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
                </form>
              </div>
              <div class="col-md-2"></div>
              <div class="col-md-5">
               <button class="btn btn-lg btn-primary btn-block btn-fb" >Log in with Facebook</button>
               <button class="btn btn-lg btn-primary btn-block btn-g" >Log in with Google</button>
               <button class="btn btn-lg btn-primary btn-block btn-t" >Log in with Twitter</button>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
 </div> 



</div>
</ul>	
</div> <!--/.nav-collapse -->
</div>
</header>


<div class="main-content">
  <div class="container">
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class="payment-body">
          <div class="photo">
            <img src="resources/img/image_3.jpg" class="img-responsive">
          </div>
          <div class="title">
            Allepey House Boat
          </div>
          <div class="divider"></div>
          <div class="item">
            <div class="number">1</div> &emsp; &emsp; Trip Summary
            <div class="item-details">
              <span class="head">Check In</span>  &emsp;<span class="tail">29/3/2014</span><br>
              <span class="head">Check Out</span> &emsp;<span class="tail">4/4/2014</span><br>
              <br><div class="divider"></div><br>
              <span class="head">Charges</span><br>
              <span class="tail">2 nights</span> &emsp; <span class="head" style="font-weight:normal">&#8377; 7000</span><br>
              <span class="tail">Tax &amp; fees</span> &emsp; <span class="head" style="font-weight:normal">&#8377; 400</span><br>
              <br><div class="divider"></div><br>
              <span class="head">Grand Total</span> &emsp; <span class="head" style="font-weight:normal">&#8377; 7400</span>
            </div>
          </div>
          <div class="divider"></div>
          <div class="item"> 
            <div class="number">2</div> &emsp; &emsp; Traveller Details
            <div class="item-details">
              <div class="row">
                <div class="col-md-6"><input value="${user.firstName}" class="form-control" type="text" placeholder="First Name"></div>
                <div class="col-md-6"><input value="${user.lastName}" class="form-control" type="text" placeholder="Last Name"></div>
              </div>
              <div class="row">
                <div class="col-md-6"><input value="${user.email}" class="form-control" type="email" placeholder="Email"></div>
                <div class="col-md-6"><input value="${user.contactNo}" class="form-control" type="number" placeholder="Mobile No."></div>
              </div>
            </div>
          </div>
          <div class="divider"></div>
          <div class="item">
            <div class="number">3</div> &emsp; &emsp; Payment Details
            <div class="item-details">
              <!-- Nav tabs -->
              <ul class="nav nav-tabs">
                <li class="active"><a href="#debit-card" data-toggle="tab">Debit Card</a></li>
                <li><a href="#online-banking" data-toggle="tab">Online Banking</a></li>
                <li><a href="#credit-card" data-toggle="tab">Credit Card</a></li>
              </ul>

              <!-- Tab panes -->
              <div class="tab-content">
                <div class="tab-pane active" id="debit-card">...</div>
                <div class="tab-pane" id="online-banking">...</div>
                <div class="tab-pane" id="credit-card">...</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-1"></div>
    </div>
  </div>
</div>

<div class="footer">
  <div class="container">
   <div class="row">
    <div class="col-md-10 copy" >
      &copy; Trip to paradise  2014 
    </div>
    <div class="col-md-2 social-icons">
      <a href="#"><img src="resources/img/facebook.png"></a>
      <a href="#"><img src="resources/img/twitter.png"></a>
      <a href="#"><img src="resources/img/linkedin.png"></a>
      <a href="#"><img src="resources/img/googleplus.png"></a>
    </div>
  </div>


</div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.10.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">
$(function() {
	  $('#signupform').submit(function(event) {
	    var form = $(this);
	    $.ajax({
	      type: form.attr('method'),
	      url: form.attr('action'),
	      data: form.serialize()
	    }).done(function(responseText) {
	    	$('#message').replaceWith(responseText);    
	    	$('#signupemail').val('');
	    	$('#signuppword').val('');
	    	$('#signupCheckbox').prop('checked', false); 
	    });
	    event.preventDefault(); // Prevent the form from submitting via the browser.
	  });  
	});
	$(function() {
		  $('#loginform').submit(function(event) {
		    var form = $(this);
		    $.ajax({
		      type: form.attr('method'),
		      url: form.attr('action'),
		      data: form.serialize()
		    }).done(function(responseText) {
		    	$('#loginmessage').replaceWith(responseText);    
		    	$('#loginEmail').val('');
		    	$('#loginPassword').val('');
		    	$('#loginCheckbox').prop('checked', false); 
		    	if ($.trim(responseText).length == 0) {
		    		location.reload();
		    	}
		    });
		    event.preventDefault(); // Prevent the form from submitting via the browser.
		  });  
		});
	$(function() {
		  $('#logoutLink').click(function(event) {
			  event.preventDefault();
			  var ele = $(this);
			  $.ajax({
	              type:"GET",
	              url:ele.attr('href'),
	          }).done(function(){
				  location.reload();
			  });
		  });  
	});

	$(function() {
		  $('#loginSignUpButton').click(function(event) {
			  	$('#loginEmail').val('');
		    	$('#loginPassword').val('');
		    	$('#loginCheckbox').prop('checked', false); 
			  
			  	$('#signupemail').val('');
		    	$('#signuppword').val('');
		    	$('#signupCheckbox').prop('checked', false); 
		  });  
	});		  

</script>
</div>
</body>
</html>