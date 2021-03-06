<!-- Create a view called listProducts.jsp. This page will be further divided into two to display the
category on the side and other to display the data table.
 -->

<div class="container">

	<div class="row">

		<!-- To display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- To display actual products -->
		<div class="col-md-9">
			<!-- adding the bootstrap component of breadcrumb to test our page -->
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClicksAllProducts == true}">
					
							<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClicksCategoryProducts == true}">
					<script>
					//adding categoryId
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
					
				</div>
			</div>
			
			<!-- Create a new table element with some dummy fields inside the listProducts.jsp -->
			<div class="row">
				<div class="col-xs-12">
				<table id="productListTable" class="table table-striped table-borderd">
					<thead>
						
							<tr>
							<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty</th>
								<th></th>
							
							</tr>
						
						</thead>
						
						<tfoot>
						
							<tr>
							<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty</th>
								<th></th>
							
							</tr>
						
						</tfoot>
					

				</table>
			</div>
			
			</div>


		</div>



	</div>






</div>