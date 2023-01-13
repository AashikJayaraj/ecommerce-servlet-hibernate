/**
 * 
 */
 
 console.log("test");
const cartButton = document.getElementById("cart_button")
const productList = document.getElementById("product_list")
const cartList = document.getElementById("cart_list")
const productCategoryButton = document.getElementById("product_category_button")
const all_product_button = document.getElementById("all_product_button")

 cartButton.onclick = function(){
	cartList.style.display = "block";
	cartButton.classList.remove('btn-outline-success');
	cartButton.classList.add('btn-success');
    productList.style.display = "none";
    const categoryButton = document.getElementsByClassName("categoryButton");
	for (var i = 0; i < categoryButton.length; i++) {
		categoryButton[i].classList.add('btn-outline-primary');
	    categoryButton[i].classList.remove('btn-primary');
	}
	all_product_button.classList.add('btn-outline-primary');
	all_product_button.classList.remove('btn-primary');
}

 all_product_button.onclick = function(){
	
	const categoryButton = document.getElementsByClassName("categoryButton");
	for (var i = 0; i < categoryButton.length; i++) {
		categoryButton[i].classList.add('btn-outline-primary');
	    categoryButton[i].classList.remove('btn-primary');
	}
	
	cartButton.classList.add('btn-outline-success');
	cartButton.classList.remove('btn-success');
	all_product_button.classList.remove('btn-outline-primary');
	all_product_button.classList.add('btn-primary');
	cartList.style.display = "none"
	productList.style.display = "block";
}


function selectedCategory(id){
	const allCategory = document.getElementsByClassName("categoryButton");
	all_product_button.classList.add('btn-outline-primary');
	all_product_button.classList.remove('btn-primary');
	for (var i = 0; i < allCategory.length; i++) {
		allCategory[i].classList.add('btn-outline-primary');
	    allCategory[i].classList.remove('btn-primary');
	}

	const categoryButton = document.getElementsByClassName("categoryButton")[id];
	console.log(id)
	console.log(categoryButton)
	categoryButton.classList.remove('btn-outline-primary');
	categoryButton.classList.add('btn-primary');
	cartButton.classList.add('btn-outline-success');
	cartButton.classList.remove('btn-success');

		
}