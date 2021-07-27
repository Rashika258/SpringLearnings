<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- To solve active menu problem add id to all nav links and add active class using jquery -->
                <a class="navbar-brand" href="${contextRoot}/home">Flipzon</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <!-- To -->
                <ul class="nav navbar-nav">
                    <li id="listProducts">
                        <a href="${contextRoot}/show/all/products">Products</a>
                    </li>
                    <li id="about">
                    	<a href="${contextRoot}/about">About</a>
                        
                    </li>
                    <li id="contact">
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>