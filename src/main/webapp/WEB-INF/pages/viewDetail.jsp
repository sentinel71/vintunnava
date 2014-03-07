<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Trip to Paradise </title>
	<!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="resources/css/datepicker.css">
  <link href="resources/css/bootstrap.css" rel="stylesheet">
  <!-- Custom Stylesheet -->

  <link type="text/css" rel="Stylesheet" href="resources/css/bjqs.css" />
  <link rel="stylesheet" type="text/css" href="resources/css/view-details.css">
  
  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:700' rel='stylesheet' type='text/css'>
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

   <li class="dropdown ">
    <a href="#" class="dropdown-toggle user" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> <b class="caret"></b></a>
    <ul class="dropdown-menu">
      <li><a href="#">Profile</a></li>
      <li><a href="#">Booking History</a></li>
      <li class="divider"></li>
      <li><a href="#">Log Out</a></li>

    </ul>
  </li>
  <button class="btn btn-primary btn-login" data-toggle="modal" data-target="#authModal">Log In  |  Sign Up</button>

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
                  <form>
                    <input type="text" class="form-control" placeholder="Username">
                    <input type="password" class="form-control" placeholder="Password">
                    <label class="checkbox">
                      <input type="checkbox" value="remember-me"> Remember me
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
                <input type="text" class="form-control" placeholder="Username">
                <input type="email" class="form-control" placeholder="Email">
                <input type="password" class="form-control" placeholder="Password">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
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
<div id="MyCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#MyCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#MyCarousel" data-slide-to="1"></li>
    <li data-target="#MyCarousel" data-slide-to="2"></li>
  </ol>
  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/img/kerala.jpg" alt="">
      <div class="carousel-caption">
        Kerala House Boat
      </div>
    </div>
    <div class="item">
      <img src="resources/img/kerala.jpg" alt="">
      <div class="carousel-caption">
        Kerala House Boat
      </div>
    </div>
    <div class="item">
      <img src="resources/img/kerala.jpg" alt="">
      <div class="carousel-caption">
        Kerala House Boat
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#MyCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
  </a>
  <a class="right carousel-control" href="#MyCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
  </a>
</div>

<div class="main-content">
  <div class="container">
    <div class="row">
      <div class="col-md-8 ">
         <!-- Nav tabs -->
        <ul class="nav nav-tabs" id="MyTab">
          <li class="active"><a href="#rate-plan" data-toggle="tab">Rate-Plan</a></li>
          <li><a href="#itenary" data-toggle="tab">Itenary</a></li>
          <li><a href="#amenities" data-toggle="tab">Amenities</a></li>
          <li><a href="#meal" data-toggle="tab">Meal</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
          <div class="tab-pane active" id="rate-plan">
            <div class="table-responsive">
              <table class="table">
                <thead style="font-family:'Roboto Slab'; font-size:1.5em;color:rgb(100,100,100)">
                  <tr>
                    <th>Room Type</th>
                    <th>Price (INR)</th>
                  </tr>
                </thead>
                <tbody style="font-family:'Roboto';font-weight:300;">
                  <tr>
                    <td class="type"><input type="radio" name="q" value="&#8377; 4,300" checked> STANDARD</td>
                    <td class="price">&#8377; 4,300</td>
                  </tr>
                  <tr>
                    <td class="type"><input type="radio" name="q" value="&#8377; 5,600"> DELUXE</td>
                    <td class="price">&#8377; 5,600</td>
                  </tr>
                  <tr>
                    <td class="type"><input type="radio" name="q" value="&#8377; 6,500"> PREMIUM</td>
                    <td class="price">&#8377; 6,500</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <div class="tab-pane" id="itenary">...</div>
          <div class="tab-pane" id="amenities">...</div>
          <div class="tab-pane" id="meal">...</div>
        </div>
      </div>
      <div class="col-md-1"></div>
      <div class="col-md-3 details">
        <p class="title">MAKE A RESERVATION</p>
        <hr>
        <p class="price">&#8377; 4,300</p>
        <p class="price-per-adult">(Price per Adult)</p>
        <div class="row">
          <div class="col-md-6">
              <input type="text" class="form-control" placeholder="Check-In" id="datepicker1">
          </div>
          <div class="col-md-6">       
              <input type="text" class="form-control" placeholder="Check-Out" id="datepicker2">
          </div>
        </div>
           <div class="row">
        <div class="col-md-6">
          <select>
            <option value="">Adult</option>
            <option value="1">1 Adult</option>
            <option value="2">2 Adult</option>
            <option value="3">3 Adult</option>
            <option value="4">4 Adult</option>
            <option value="5">5 Adult</option>
            <option value="6">6 Adult</option>
            <option value="7">7 Adult</option>
            <option value="8">8 Adult</option>
            <option value="9">9 Adult</option>
            <option value="10">10 Adult</option>
          </select>
        </div>
        <div class="col-md-6">
          <select>
            <option value="">Child</option>
            <option value="1">1 Child</option>
            <option value="2">2 Child</option>
            <option value="3">3 Child</option>
            <option value="4">4 Child</option>
            <option value="5">5 Child</option>
            <option value="6">6 Child</option>
            <option value="7">7 Child</option>
            <option value="8">8 Child</option>
            <option value="9">9 Child</option>
            <option value="10">10 Child</option>
          </select>
        </div>
      </div>
      	<form id="bookForm" action="plainBooking" method="post">
        	<button type="submit" class="btn btn-lg btn-primary btn-book">Book Now !</button>
        </form>
      </div>
   
      <div class="col-md-1 ">
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
<script type="text/javascript">
$(document).ready(function () {

  $('#datepicker1').datepicker();  
  $('#datepicker2').datepicker(); 
});
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="resources/js/bjqs-1.3.min.js"></script>
<script src="resources/js/jquery.secret-source.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
</body>
</html>