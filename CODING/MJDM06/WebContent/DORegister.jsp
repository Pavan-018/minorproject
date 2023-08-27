<!DOCTYPE html>
<!--
	Indus by TEMPLATE STOCK
	templatestock.co @templatestock
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->

<html lang="en" class="no-js">
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <title>



        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/et-lineicon.css" />
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500,400italic,500italic,700' rel='stylesheet' type='text/css'>
        <!--[if IE]>
        	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
	</head>
	<body>

        <!-- Preloader -->
        <div class="animationload">
            <div class="loader">
                Loading...
            </div>
        </div> 
        <!-- End Preloader -->

        <!-- =========================
                 HOME
        ========================== -->

		<section id="home">
			<div class="content">
                <div id="large-header" class="large-header">
                    <canvas id="demo-canvas"></canvas>
                    <div id="countdown_dashboard" class="home-main container">
                        <div class="row">
                            <div class="logo">
                                <h1 style="color: white"> 

cyber-physical cloud environment</h1>
                            </div>
                            <br><br>
                            <div class="row">
                            <!-- DAYS -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash days_dash">
                                    <a href="CloudControllerLogin.jsp" class="dash_title" style="font-size: 25px;">Cloud Controller</a>
                                </div>
                            </div>
                            <!-- HOURS -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash hours_dash">
                                <a href="PKGLogin.jsp" class="dash_title" style="font-size: 25px;">PKG</a>
                                </div>
                            </div>
                            <!-- MINUTES -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash minutes_dash">
                                    <a href="DORegister.jsp" class="dash_title" style="font-size: 25px;">Data Owner</a>
                                </div>
                            </div>
                            <!-- SECONDS -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash seconds_dash">
                                    <a href="DCRegister.jsp" class="dash_title" style="font-size: 25px;">Data Consumer</a>
                                </div>
                            </div>
                        </div> <!-- END ROW -->
                        </div>
                    </div> <!-- END COUNTDOWN -->
                </div> <!-- LARGE HEADER -->
            </div> <!-- END CONTENT -->
        </section>
        <!-- =========================
                 CONTACT
        ========================== -->

        <section id="contact" class="contact">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12">
                        <h4>DATA OWNER LOGIN</h4>
                        <div class="line-separate line-white text-center"><span></span></div>
                    </div> <!-- end Our Location -->
                </div> <!-- end row -->
                <!-- CONTACT FORM -->
                <div id="cformSuccessMsg" style="display: none;" class="confirm-message"></div>
                <form action="DORegister" method="POST" >
                    <div class="row">
                     <div class="col-lg-4 col-md-4 col-lg-offset-2 col-md-offset-2">
                            <input class="" type="text" name="name" placeholder="DO Name" />
                        </div> 
                        <div class="col-lg-4 col-md-4 col-lg-offset-2 col-md-offset-2">
                            <input class="" type="email" name="email" id="contact_email" placeholder="DO Email ID" />
                        </div> <!-- end Name -->
                        <div class="col-lg-4 col-md-4 col-lg-offset-2 col-md-offset-2">
                        <fieldset data-role="controlgroup">
      					<legend>Choose your gender:</legend>
        				<label for="male">Male</label>
       				    <input type="radio" name="gender" id="male" value="Male">
      				    <label for="female">Female</label>
       				    <input type="radio" name="gender" id="female" value="Female">
                        </fieldset>
                        </div> 
                         <div class="col-lg-4 col-md-4 col-lg-offset-2 col-md-offset-2">
                            <input class="" type="text" name="mobile" placeholder="DO Mobile" />
                        </div> 
                        <div class="col-lg-4 col-md-4 col-lg-offset-2 col-md-offset-2">
                            <input class="" type="password" name="password"  placeholder="DO Password" />
                        </div> <!-- end Email -->
                    </div>
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <div class="text-right">
                                <button class="btn btn-custom" id="contact_submit_btn" name="contact_submit_btn"><span>Register</span></button>
                            <a href="DOLogin.jsp" class="btn btn-custom" id="contact_submit_btn"><span>Existing DO ? </span></a>
                           </div>
                        </div>
                    </div> <!-- end button -->
                </form><!-- END FORM -->
            </div> <!-- end container -->
        </section> <!-- end Contact -->
            
        <!-- JAVASCRIPTS -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.lwtCountdown-1.0.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/animated.js"></script>
        <script src="js/main.js"></script>
	</body>
</html>