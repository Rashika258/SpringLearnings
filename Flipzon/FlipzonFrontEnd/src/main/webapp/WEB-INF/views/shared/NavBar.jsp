<!--  add security tag library to it.-->

<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
	<script>
		window.userRole = '${userModel.role}';
	</script>

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
                    
                    <security:authorize access="hasAuthority('ADMIN')">
                    
	                    <li id="manageProduct">
	                        <a href="${contextRoot}/manage/product">Manage Product</a>
	                    </li>					
	                    
					</security:authorize>
					
                    <li id="about">
                    	<a href="${contextRoot}/about">About</a>
                    </li>
                    
                    <li id="contact">
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                    
                </ul>
                
                  <ul class="nav navbar-nav navbar-right">
                  
			    	<security:authorize access="isAnonymous()">
			    	
	                    <li id="registration">
	                        <a href="/FlipzonFrontEnd/src/main/webapp/WEB-INF/views/flows/registration/signup-flow.xml">Sign Up</a>
	                    </li>
	                    
						<li id="login">
	                        <a href="${contextRoot}/login">Login</a>
	                    </li>
	                     			    	
			    	</security:authorize>
			    	
			    	<security:authorize access="isAuthenticated()">
			    	
						<li class="dropdown" id="userModel">
						
						  <a class="btn btn-default dropdown-toggle" href="javascript:void(0)" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
						     ${userModel.fullName}
						    <span class="caret"></span>
						  </a>
						  
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						  
		                    <security:authorize access="hasAuthority('USER')">
		                    
			                    <li id="cart">
			                        <a href="${contextRoot}/cart/show">
			                        	<span class="glyphicon glyphicon-shopping-cart"></span>&#160;<span class="badge">${userModel.cart.cartLines}</span> - &#8377; ${userModel.cart.grandTotal} 
			                        </a>
			                    </li>
			                    		     
			                	<li role="separator" class="divider"></li>	 
			                	                                  
		                    </security:authorize>
		                    
							<li id="logout">
		                        <a href="${contextRoot}/logout">Logout</a>
		                    </li>       
		                                 			    	
						  </ul>		
						</li>    			    
			    	</security:authorize>                    
			    </ul>           
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>