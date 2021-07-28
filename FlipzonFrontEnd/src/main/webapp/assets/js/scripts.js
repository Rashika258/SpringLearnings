$(function() {
	//solving the active menu problem
	switch(menu) {
		//get the page title from PageController and since it is assigned a id use it to add active class
		case 'About':
				$('#about').addClass('active');
				break;
		case 'Contact':
				$('#contact').addClass('active');
				break;
		case 'All Products':
				$('#listProducts').addClass('active');
				break;
		default:
				if(menu == 'Home') 
				break;
				$('#listProducts').addClass('active');
				$('a_'+menu).addClass('active');
				break;		
	}
	
	//code for jquery datatable
	//creating a dataset
	
	/*
	var products= [
		['1','ABC'],
		['2','bcd'],
		['3','def'],
		['4','efg'],
		['5','fgh'],
		['6','ijk']
	];
	*/
	
	var $table=$('#productListTable');
	//execute the code only when we have table
	//Code the javascript to fill the table with the some dummy data. Here the data will be a collection of some products. We will be using the data property to provide the dummy data. For more information on other property you can refer to the jQuery datatable documentation on how to use different data.
	if($table.length) {
		console.log("Inside the table");
		
		//prepare the jsonUrl in javascript to fetch the data in JSON format from the respective controller for this we will be using the contextRoot that was added previously.

		
		var jsonUrl = '';
		//user is asking for all the products
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		}
		
		// Modify the jQuery dataTable code to display the data. We will be using the following properties: ajax -> url and dataSrc columns
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 3,
			//data:products
			ajax: {
				url:jsonUrl,
				dataSrc:'' //bcs json returns only list of objects without any name
			},
			columns:[
				{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot+ '/resources/images/' + data+ '.jpg" class="dataTableImg"/>';

								}
		},
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data:'unitPrice',
					//rupee opcode - 8377
					mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
				},
				{
					data:'quantity',
					mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;
								}
				},
				{
					//to get dynamic url for add to cart and view products button
					data:'id',
					//to disable sorting
					bSortable : false,
					mRender:function(data, type, row) {
						//space opcode - 160
						var str='';
						str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
						
						if (row.quantity < 1) 
						{
											str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						} else 
						{
	
											str += '<a href="'+ window.contextRoot+ '/cart/add/'+ data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
										
						return str;
					}
					
				}
			]
		});
	}
	
});