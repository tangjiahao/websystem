
function deletespecifictags(tr){
	//先找到所在表的第几行，在调用delete方法
    var i=tr.parentNode.rowIndex;
//  alert(i);
    document.getElementById('acetable').deleteRow(i);
    totalPrice();
}
function increase(obj){
	var tdnum = obj.parentNode;
	var inputnum = tdnum.children[1];
	var num = parseInt(inputnum.value);
	num += 1;
	inputnum.value = num;
	subPrice(obj.parentNode.parentNode);
	
	totalPrice();
}
function cut(obj){
	var tdnum=obj.parentNode;
	var inputnum=tdnum.children[1];
	var num=parseInt(inputnum.value);
	if(num==1)
	return null;
	num-=1;
	inputnum.value=num;
	subPrice(obj.parentNode.parentNode);
	totalPrice();
}
function turnpage(){
	window.location.href="https://www.alipay.com/";
	
}
function checkAll(obj){
	var chkItems = document.getElementsByClassName("chkItem");
	for(var i = 0;i < chkItems.length; i++){
		var it = chkItems[i];
		it.checked = obj.checked;
	}
	totalPrice();
}

function subPrice(tr){
	var tds = tr.children;
	var price = parseFloat(tds[2].innerHTML);
	var num = parseInt(tds[3].children[1].value);
	var td_price = tds[4];
	var subPrice = price * num;
	td_price.innerHTML = "￥"+parseFloat(subPrice);
	return parseFloat(subPrice);
}

function totalPrice(){
	var tbody = document.getElementsByTagName("tbody")[0];
	
	var trs = tbody.children;
	var total = 0;
	for(var i = 0; i < trs.length-1; i++){
		var chk_item = trs[i].children[0].children[0];
		if(chk_item.checked){
			total += subPrice(trs[i]);
		}
	}
	
	var html = '总价：'+total+'&nbsp;&nbsp;<input type="button" onclick="turnpage()" class="btn" value="结算"/>';
	document.getElementById("td_total").innerHTML = html;
}


