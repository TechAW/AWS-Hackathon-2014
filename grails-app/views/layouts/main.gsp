<%@ page import="com.twilio.sdk.resource.instance.Account" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><g:layoutTitle default="Grails"/></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap Core CSS -->
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'grayscale.css')}" type="text/css">

        <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">


        <!-- Custom Fonts -->
        <link rel="stylesheet" href="${resource(dir: 'font-awesome-4.2.0/css', file: 'font-awesome.min.css')}" type="text/css">

        <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

        <!-- jQuery -->
        <g:javascript src="jquery.js" />
        <g:javascript src="bootstrap.min.js" />
        <g:javascript src="jquery.easing.min.js" />

        <!-- Custom Theme JavaScript -->
        <g:javascript src="grayscale.js" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

        <g:javascript src="sweet-alert.min.js" />
        <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
        <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
        <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'sweet-alert.css')}" type="text/css">
        <g:layoutHead/>
        <g:javascript library="application"/>
        <r:layoutResources />

        <script src="https://maps.googleapis.com/maps/api/js"></script>
    </head>

    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

        <!-- Navigation -->
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand page-scroll" href="/">
                        <img src="${resource(dir: 'images', file: 'aw-small.png')}" alt="Atrocity Watch"/></a>
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                        <li class="hidden">
                            <a href="#page-top"></a>
                        </li>
                        <sec:ifNotLoggedIn>
                            <li>
                                <a class="page-scroll" href="/login/auth">Login</a>
                            </li>
                            <li>
                                <a class="page-scroll" href="/account/create">Create Account</a>
                            </li>
                        </sec:ifNotLoggedIn>
                        <sec:ifLoggedIn>
                            <li><a class="page-scroll" href="/home/createEvents">Trigger Events</a></li>
                            <li><a class="page-scroll" href="/account/track">Track Me</a></li>
                            <li><a class="page-scroll" href="/account/map">Event Map</a></li>
                            <li><a class="page-scroll" href="/account/profile">Profile</a></li>
                            <li><a class="page-scroll" href="#"><sec:username /></a></li>
                        </sec:ifLoggedIn>
                        <li>
                            <a class="page-scroll" href="#contact">Contact</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Intro Header -->
        <section class="container content-section">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <g:layoutBody/>
                    <div class="footer" role="contentinfo"></div>
                    <r:layoutResources />
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer>
            <div class="container text-center">
                <p>Copyright #reinvent Hackathon Atrocity Watch Team 11</p>
            </div>
        </footer>
    </body>
</html>
