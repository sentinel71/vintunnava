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
  <link rel="stylesheet" type="text/css" href="resources/css/listing.css">
  
  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Roboto:300' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:300' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:700' rel='stylesheet' type='text/css'>
  <script src="resources/js/jquery-1.10.2.min.js"></script>
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
     <li class="active"><a href="${pageContext.request.contextPath}/search">Home</a></li>
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
               <button class="btn btn-lg btn-primary btn-block btn-fb">Log in with Facebook</button>
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
  <div class="jumbotron">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <h1 class="main-name">Kerala</h1>
        </div>
        <div class="col-md-5">
          <p class="desc">Kerala is God's Own County and it has a lot of natural tourist attractions</p>
        </div>
        <iframe class="col-md-4" src="http://player.vimeo.com/video/26208536?byline=0&badge=0&title=0" width="WIDTH" height="203px" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
      </div>
    </div>
  </div>
  <div class="gallery" >
    <div class="container" >  
      
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="${pageContext.request.contextPath}/viewDetail" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>   
        </div>
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="#" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>  
        </div>
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="#" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>  
        </div>
      
      
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="#" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>   
        </div>
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="#" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>  
        </div>
        <div class="col-md-4 col-sm-6" >
          <div class="item">
            <img src="resources/img/image_@.jpg" class="img-responsive">
            <div class="package-name"><a href="#" >Incredible Kerala</a></div>
            <div class="price-bar">
              <div class="price-desc ">
                On a Twin Sharing Basis
              </div>
              <div class="price">
                &#8377; 3,500 
              </div>
            </div>
          </div>  
        </div>
    
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
</body>
</html>