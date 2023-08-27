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
                                    <a href="DOHome.jsp" class="dash_title" style="font-size: 25px;">DO HOME</a>
                                </div>
                            </div>
                            <!-- HOURS -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash hours_dash">
                                <a href="Store.jsp" class="dash_title" style="font-size: 25px;">Encrypt Message</a>
                                </div>
                            </div>
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash hours_dash">
                                <a href="StoreMessages.jsp" class="dash_title" style="font-size: 25px;">Stored Messages</a>
                                </div>
                            </div>
                            <!-- MINUTES -->
                            <!-- SECONDS -->
                            <div class="col-md-3" data-scroll-reveal="enter bottom move 25px, after 0.3s">
                                <div class="dash seconds_dash">
                                    <a href="index.html" class="dash_title" style="font-size: 25px;">Sign Out</a>
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
                    <% String uid=(String)session.getAttribute("name"); %>
                        <h4><%=uid %> HOME</h4>
                        <div class="line-separate line-white text-center"><span></span></div>
                    </div> <!-- end Our Location -->
                </div> <!-- end row -->
                <!-- CONTACT FORM -->
            </div> <!-- end container -->
        </section> <!-- end Contact -->

        <!-- =========================
                 FOOTER
        ========================== -->
            
        <!-- JAVASCRIPTS -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.lwtCountdown-1.0.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/animated.js"></script>
        <script src="js/main.js"></script>
	</body>
</html>