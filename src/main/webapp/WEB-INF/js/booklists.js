$('document').ready(function(){
	var currentCount = 0;
	var defaultCount = 20;
	var ifsearch=0;
	var fields = "id,images,title,url,author,publisher,price,pubdate,summary";
	var tagtitle="儿童文学";
	var bookurl="";
	searchallBook();
	$(".loginform").hide();
	$(".username").show();
	$(".loginflag").click(function(){
		if($(".loginflag").html() == "login"){
			$(".loginform").show();
		}
		if($(".loginflag").html() == "welcome!"){
			$(".username").show();
		}
	});
	$(".mycart").click(function(){
		var user_id = $(".username").html();
		window.location="getcartlist?userid="+user_id;

	});
	$("#top").click(function(){
		$('body').scrollTop(0);
	});
	$(".items").click(function(){
		ifsearch=2;
		$('#book-list').html("");
		tagtitle=$(this).html();
		currentCount = 0;
		$("#tag-title").html("关于"+$(this).html()+"的书 (豆瓣)");
		searchallBook();
	});
	$(".load-more").bind('click', function(){
		if(ifsearch == 0){
			tagtitle="儿童文学";
			searchallBook();
		}
		else if(ifsearch == 1)
			searchBook();
		else if(ifsearch == 2)
			searchallBook();
	});
	$("#nav-search-btn").bind('click', function(){
		ifsearch=2;
		$('#book-list').html("");
		if($("#nav-search-content").val()){
			tagtitle=$("#nav-search-content").val();
			currentCount = 0;
			$("#tag-title").html("关于"+$("#nav-search-content").val()+"的书 (豆瓣)");
			searchallBook();
		}
		else{
			currentCount = 0;
			tagtitle="儿童文学";
			searchallBook();
		}
	});
	$("#search-btn").bind('click', function(){
		ifsearch=1;
		$('#book-list').html("");
		if($("#search-content").val()){
			currentCount = 0;
			searchBook();
		}
		else{
			currentCount = 0;
			tagtitle="儿童文学";
			searchallBook();
		}
	});
	function searchallBook(){
		$.ajax({
			type:"get",
			url:"https://api.douban.com/v2/book/search?tag="+tagtitle+"&start="+currentCount+"&fields="+fields,
			dataType: 'jsonp',
			success:function(data){
				moreBook(data);
				currentCount+=defaultCount;
			},
		});
	}
	function searchBook(){
		$.ajax({
			type:"get",
			url:"https://api.douban.com/v2/book/search?q="+$("#search-content").val()+"&start="+currentCount+"&fields="+fields,
			dataType: 'jsonp',
			success:function(data){
				moreBook(data);
				currentCount+=defaultCount;
			},
		});
	}

	function moreBook(data) {
		var bookItems = "";
		$.each(data.books, function(index, book){	
			var bookItem = "<li><a href='getbookinfo?bookurl="+book.url+"&userid="+$(".username").html()+"'>"+
                "<img src='"+book.images.medium+"'>"+
                "<div class='book-detail'><div class='gotobookinfo'>"+
                	"<h4 class='bookname' data-detail='"+book.url+"'>"+book.title+"</h4>"+
                    "<p class='book-info'>"+
                        "<span class='author' >"+book.author.join('/')+"/</span>"+
                        "<span class='publisher' >"+book.publisher+"/</span>"+
                        "<span class='price' >"+book.price+"/</span>"+
                        "<span class='pubdate' >"+book.pubdate+"</span></p>"+
                    "</div></div></a></li>"
        	
        	bookItems += bookItem;
		
		});
		$("#book-list").append(bookItems);
	}
})
