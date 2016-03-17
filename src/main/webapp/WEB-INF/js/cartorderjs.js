$('document').ready(function(){
	$(".orderdetails").hide();
	$(".cartnum").click(function(){
		var num=$(this).val();
		var cartid=$(this).attr("cur-cartid");
		var bookid=$(this).attr("cur-bookid");
		var userid=$(this).attr("cur-userid");
		if(num == 0){
			window.location="delfromcart?cartid="+cartid+"&userid="+userid;
		}
		else{
			window.location="updateonecart?userid="+userid+"&bookid="+bookid+"&cartnumber="+num;

		}
	})
	$("#order").click(function(){
		$(".orderdetails").show();
	})
	$(".yesorder").click(function(){
		$(".orderdetails").html("已完成订单");
	})
	$(".noorder").click(function(){
		$(".orderdetails").html("已清空订单");
	})
})


