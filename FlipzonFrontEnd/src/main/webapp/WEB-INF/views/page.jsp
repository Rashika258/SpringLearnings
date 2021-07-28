<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!-- The JSTL core tag provide variable support, URL management, flow control, etc. The URL for the core tag is http://java.sun.com/jsp/jstl/core. The prefix of core tag is c. -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- The Spring MVC form tags can be seen as data binding-aware tags that can automatically set data to Java object/bean and also retrieve from it. Here, each tag provides support for the set of attributes of its corresponding HTML tag counterpart, making the tags familiar and easy to use. 
    To load external css and js files linked to the project
    -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--  Create three variables name css, js and images using spring:url element. 
    These 3 urls will get values from dispatcher servlet and mapped to assets folder-->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!-- To get the path of every url -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Flipzon-${title}</title>
    <!-- Add a small script element in the head section and create a new property with the name of menu in the window global object. -->
    <script type="text/javascript">
    	window.menu='${title}';
    	
    	//Modify the page.jsp file to add the contextRoot to window global object
    	window.contextRoot='${contextRoot}';
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">
    
    <!-- add a theme to the project download a theme from bootswatch.com -->
    <!-- Bootstrap Theme CSS -->
    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
    
    <!-- Add the other files in the project which is required for making dataTable boostrapish -->
       <!-- Bootstrap Datatable CSS -->
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${css}/myapp.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<!-- Wrap the entire body code inside another div element -->

        <!-- Navigation-->
        <div class="wrapper">
        
       <%@include file="./shared/NavBar.jsp" %>
        <!-- Header-->

<!-- Page Content -->
        <!-- Section-->
        <!-- Wrap the page content section inside another div element -->
        
        <div class="content">
		        <!-- receives it from the front controller here, pageController -->
		       <c:if test="${userClicksHome == true }">
		        <%@ include file="home.jsp" %>
		        </c:if>
		        
		        <c:if test="${userClicksAbout == true }">
		        <%@ include file="about.jsp" %>
		        </c:if>
		        
		        <c:if test="${userClicksContact == true }">
		        <%@ include file="contact.jsp" %>
		        </c:if>
		        
		        <c:if test="${userClicksCategoryProducts == true or userClicksAllProducts==true }">
		        <%@ include file="listProducts.jsp" %>
		        </c:if>
		        
		        <c:if test="${userClicksShowProduct == true}">
		        <%@ include file="singleProduct.jsp" %>
		        </c:if>
		        
        </div>
        
         <%@include file="./shared/footer.jsp" %>
      
        <!-- jQuery -->
    <script src="${js}/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/bootstrap.min.js"></script>
    
    <!--  From this website to download the jQuery DataTable plugin.
				https://datatables.net/
				 Add the jquery.dataTable.js file to the proper location and link it in our project master page in
				proper order.
     -->
    
    <!-- Bootstrap Core JavaScript -->
    <script src="${js}/jquery.dataTables.js"></script>
    
        <!-- Bootstrap Datatable JavaScript -->
    <script src="${js}/dataTables.bootstrap.js"></script>
    
    <!-- Custom JavaScript -->
    <script src="${js}/scripts.js"></script>
   </div>
</body>

</html>

