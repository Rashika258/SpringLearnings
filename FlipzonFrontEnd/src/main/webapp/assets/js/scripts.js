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
				$('#listProducts').addClass('active');
				$('a_'+menu).addClass('active');
				break;		
		
	}
	
});