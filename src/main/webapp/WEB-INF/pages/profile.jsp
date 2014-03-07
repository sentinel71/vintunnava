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

  <link rel="stylesheet" type="text/css" href="resources/css/profile.css">
  <link rel="stylesheet" type="text/css" href="resources/css/datepicker.css">
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
     <li><a href="${pageContext.request.contextPath}/search">Home</a></li>
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
     <li class="dropdown active">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
        <li><a href="${pageContext.request.contextPath}/bookingHistory">Booking History</a></li>
        <li class="divider"></li>
        <li><a href="#">Change Password</a></li>
        <li class="divider"></li>
        <li><a id="logoutLink" href="${pageContext.request.contextPath}/logout">Log Out</a></li>

      </ul>
    </li>


  </div>
</div>
</ul>	
</div> <!--/.nav-collapse -->
</div>
</header>
<div class="container">
  <!-- Nav tabs -->
  <ul class="nav nav-tabs nav-profile">
    <li class="active "><a href="#profile" class="profile-tabs" data-toggle="tab">Profile</a></li>
    <li><a href="#address " class="profile-tabs" data-toggle="tab">Address</a></li>
    <li><a href="#history " class="profile-tabs" data-toggle="tab">Booking History</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div class="tab-pane active "  id="profile">
      <div class="profile">
        <div class="title" style="margin-top: -15px;">Personal Profile</div>
        	<div class="panel-body">
        	<form id="profileform" action="profile"  method="post">
				<table align="center" width="100%" cellpadding="0" cellspacing="2px" border="0"> 
					<tr>
						<td>*Title</td>
						<td>
								<select id="selectTitle" name="selectTitle" class="form-control" style=" width: 50%;" required="required" >
									<option value="Mr">Mr.</option>
									<option value="Ms">Ms.</option>
									<option value="Mrs">Mrs.</option>
									<option value="Dr">Dr.</option>
								</select>
						</td>
					</tr>
					<tr>
						<td>*First Name</td>
						<td><input value="${user.firstName}" id="firstname" name="firstname" type="text" class="form-control" placeholder="First Name" style=" width: 50%;" required="required"/></td>
					</tr>
					<tr>
						<td>Middle Name</td>
						<td><input value="${user.middleName}" id="middlename" name="middlename" type="text" class="form-control" placeholder="Middle Name" style=" width: 50%;"/></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input value="${user.lastName}" id="lastname" name="lastname" type="text" class="form-control" placeholder="Last Name" style=" width: 50%;"/></td>
					</tr>
					<tr>
						<td>*Date of Birth</td>
						<td><input value="${user.dateOfBirth}" id="dob" name="dob" type="date" class="form-control" placeholder="mm/dd/yyyy" /></td>
					</tr>
					<tr>
						<td>*Mobile No.</td>
						<td><input value="${user.contactNo}" id="mobileno" name="mobileno" type="number" class="form-control" placeholder="Mobile No." style=" width: 50%;" required="required"/></td>
					</tr>
					<tr>
						<td>Alternative Mobile No.</td>
						<td><input value="${user.alternateContactNo}" id="altmobileno" name="altmobileno" type="number" class="form-control" placeholder="Alternative Mobile No." style=" width: 50%;"/></td>
					</tr>	
					<tr>
						<td>Email</td>
						<td><input value="${user.email}" type="text" class="form-control" readonly="readonly" style=" width: 50%;"/></td>
					</tr>				
				</table>	
				<button id="profileformSubmit" class="btn btn-lg btn-primary btn-block" type="submit" style="margin-left: 90%;width: 10%;display: none;" >Save</button>
				</form>
<!-- 				<div class="horizontal-divider" style="margin-top: 1%;"></div> -->
			</div>
      </div>
    </div>
    <div class="tab-pane" id="address">
      <div class="profile">
        <span class="title" style="margin-top: -15px;">Address</span>
        <div class="panel-body">
        <form id="addressform" action="address"  method="post">
          <table align="center" width="100%" cellpadding="0" cellspacing="2px" border="0">
          	<tr>
						<td>*Address Type</td>
						<td>
								<select value="${user.addresses[0].addresstype.name}" id="selectAddressType" name="selectAddressType" class="form-control" style=" width: 50%;" required="required">
									<option value="Home">Home</option>
									<option value="Work">Work</option>
									<option value="School">School</option>
								</select>
						</td>
			</tr>
          	<tr>
				<td>*Address Line 1</td>
				<td><input value="${user.addresses[0].addressLine1}" id="addressLine1" name="addressLine1" type="text" class="form-control" placeholder="Address Line 1" style=" width: 50%;" required="required"/></td>
			</tr>
			<tr>
				<td>Address Line 2</td>
				<td><input value="${user.addresses[0].addressLine2}" id="addressLine2" name="addressLine2" type="text" class="form-control" placeholder="Address Line 2" style=" width: 50%;"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input value="${user.addresses[0].cityStateCountry}" id="city" name="city" type="text" class="form-control" placeholder="City,State,Country" style=" width: 50%;"/></td>
			</tr>
			<tr>
				<td>Zipcode</td>
				<td><input value="${user.addresses[0].zipcode}" id="zipcode" name="zipcode" type="number" class="form-control" placeholder="Zipcode" style=" width: 50%;"/></td>
			</tr>
          </table>
          <button  class="btn btn-lg btn-primary " type="submit" style="display:inline-block !important;margin-right:30px;margin-left:69%;margin-top:30px;visibility: hidden;">Add Another Address</button><button id="profileformSubmit" class="btn btn-lg btn-primary" type="submit" style="display: inline-block !important;margin-top:30px;">Save</button>
          </form>
        </div>
      </div>
    </div>
    <div class="tab-pane" id="history">
      <div class="booking-history">
        <span class="title">Booking History</span>
        <div class="table-responsive">
          <table class="table">
            <thead>
              <tr>
              <th>Date</th>
              <th>Name</th>
              <th>Booking ID</th>
              <th>Package</th>
              <th>Price</th>
            </tr>
            </thead>
            <tbody>
              <tr>
              <td class="date">

                <span class="month">FEB</span>
                <span class="day">14</span>
                <span class="year">2014</span>
              </td>
              <td class="name">Dinesh Padisetti</td>
              <td class="booking-id">TTP2022014 <br> <a href="#"><span class="small">View Invoice</span></a></td>
              <td class="package"><a href="#">A Keralan Getaway</a></td>
              <td class="price">Rs. 4000 /-</td>
            </tr>
            <tr>
              <td class="date">

                <span class="month">FEB</span>
                <span class="day">14</span>
                <span class="year">2014</span>
              </td>
              <td class="name">Dinesh Padisetti</td>
              <td class="booking-id">TTP2022014 <br> <a href="#"><span class="small">View Invoice</span></a></td>
              <td class="package"><a href="#">A Keralan Getaway</a></td>
              <td class="price">Rs. 4000 /-</td>
            </tr>
            <tr>
              <td class="date">

                <span class="month">FEB</span>
                <span class="day">14</span>
                <span class="year">2014</span>
              </td>
              <td class="name">Dinesh Padisetti</td>
              <td class="booking-id">TTP2022014 <br> <a href="#"><span class="small">View Invoice</span></a></td>
              <td class="package"><a href="#">A Keralan Getaway</a></td>
              <td class="price">Rs. 4000 /-</td>
            </tr>
            <tr>
              <td class="date">

                <span class="month">FEB</span>
                <span class="day">14</span>
                <span class="year">2014</span>
              </td>
              <td class="name">Dinesh Padisetti</td>
              <td class="booking-id">TTP2022014 <br> <a href="#"><span class="small">View Invoice</span></a></td>
              <td class="package"><a href="#">A Keralan Getaway</a></td>
              <td class="price">Rs. 4000 /-</td>
            </tr>
            <tr>
              <td class="date">

                <span class="month">FEB</span>
                <span class="day">14</span>
                <span class="year">2014</span>
              </td>
              <td class="name">Dinesh Padisetti</td>
              <td class="booking-id">TTP2022014 <br> <a href="#"><span class="small">View Invoice</span></a></td>
              <td class="package"><a href="#">A Keralan Getaway</a></td>
              <td class="price">Rs. 4000 /-</td>
            </tr>
            </tbody>
            
          </table>
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
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.10.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">


$( "#profileform tbody tr td input" ).on( "focus", function() {
	$("#profileformSubmit" ).css("display", "block");
});

$( "#profileform tbody tr td select" ).on( "focus", function() {
	$("#profileformSubmit" ).css("display", "block");
});
	
$(function() {
  $('#profileform').submit(function(event) {
    var form = $(this);
    $.ajax({
      type: form.attr('method'),
      url: form.attr('action'),
      data: form.serialize()
    });
    event.preventDefault(); // Prevent the form from submitting via the browser.
    $("#profileformSubmit" ).css("display", "none");
  });  
});

$(function() {
	  $('#addressform').submit(function(event) {
	    var form = $(this);
	    $.ajax({
	      type: form.attr('method'),
	      url: form.attr('action'),
	      data: form.serialize()
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
		  top.location.href = '/Cruise/search';
	  });  
});



</script>
</body>
</html>