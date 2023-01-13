/**
 * 
 */
 

function addProduct(pId, pName, pImage, pPrice){

	calculateCartTotal(pPrice);
	var check = document.getElementsByClassName("item"+pId);
	if(check.length>0){
		quantity = check[0].innerText;
		quantity = parseInt(check[0].innerText) + 1;
		check[0].innerText = quantity;
		console.log(quantity)
		var updateQty = document.getElementsByClassName("qty-"+pId);
		console.log("inner text="+updateQty[0].innerText)
		updateQty[0].innerText = quantity;
	}
	else{
		
		var tableBody = document.getElementById("populatedList");
  		var tableRow = document.createElement("tr")
  	
  		var colName = document.createElement("td");
  		colName.classList.add("col");
  	
  		nameProduct = document.createElement("div");
  		nameProduct.innerText = pName
  		pid = document.createElement("div");
  		pid.style.display = "none";
  		pid.classList.add("item"+pId);
  		pid.innerText = 1;
  	
  		//colName.innerText = pName;
  		colName.appendChild(nameProduct);
  		colName.appendChild(pid);
  	
  		var colImage = document.createElement("td");
  		colImage.classList.add("col");
  		productImg = document.createElement("img")
  		productImg.src = "asset/productimages/"+pImage;
  		productImg.style.width = "48px";
  		productImg.style.height = "48px";
  		colImage.appendChild(productImg);
  	
  		var colQty = document.createElement("td");
  		colQty.classList.add("col","qty-"+pId);
  		colQty.innerText = "1";
  	
  		var colPrice = document.createElement("td");
  		colPrice.classList.add("col");
  		colPrice.innerText = pPrice;

  		var removeButton = document.createElement("button");
  		removeButton.classList.add("btn", "btn-danger")
  		removeButton.style.color ="black";
  		removeButton.style.marginTop ="15px";
  		removeButton.innerText = "Remove";

   		tableRow.appendChild(colImage);
   		tableRow.appendChild(colName);
   		tableRow.appendChild(colQty);
   		tableRow.appendChild(colPrice);
   		tableRow.appendChild(removeButton);
		
		var lastRow = document.getElementById(cartTotalValue);
   	
   		tableBody.appendChild(tableRow,lastRow);
	}
	
}

function calculateCartTotal(itemPrice){
	var price = document.getElementById("cartTotalValue");
	var updatedPrice = parseFloat(price.innerText) + parseFloat(itemPrice);
	price.innerText = updatedPrice;
}