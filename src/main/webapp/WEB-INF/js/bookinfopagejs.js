$('document').ready(function() {

    var book_url = $("#bookurlinfo").val();
    $.ajax({
        type: "get",
        url: book_url,
        dataType: 'jsonp',
        success: function (bookdetailsdata) {
            morebookdetails(bookdetailsdata);
        },
    });
    function morebookdetails(bookdetailsdata) {
        var booktags = "";
        $.each(bookdetailsdata.tags, function (index, tag) {
            var booktag = tag.name;
            booktags += booktag + " ";
        });
        var bookDetail = "<form ><div>" +
            "<img src='" + bookdetailsdata.image + "'>" +
            "<div class='book-details'>" +
            "<h3 class='book-names' data-detail='" + bookdetailsdata.url + "'>" + bookdetailsdata.title + "</h3>" +
            "<p class='book-infos'>" +
            "<span>作者：" + bookdetailsdata.author.join('/') + "/</span><br />" +
            "<span>出版社：" + bookdetailsdata.publisher + "</span><br />" +
            "<span>页数：" + bookdetailsdata.pages + "</span><br />" +
            "<span>价格：" + bookdetailsdata.price + "</span><br />" +
            "<span>出版日期：" + bookdetailsdata.pubdate + "</span><br />" +
            "<span>ISBN：" + bookdetailsdata.isbn13 + "</span><br /></p>" +
            "<h4>内容简介……</h4>" +
            "<div id='summary'>" + bookdetailsdata.summary + "</div><br />" +
            "<h4>作者简介……</h4>" +
            "<div id='authorinfo'>" + bookdetailsdata.author_intro + "</div><br />" +
            "<h4>目录……</h4>" +
            "<div id='catalog'>" + bookdetailsdata.catalog + "</div><br />" +
            "<h4>豆瓣成员常用的标签……</h4>" +
            "<div class='tag'>" + booktags + "</div><br />"+
            "<a class='aasbutton' href='addintocart?userid="+$(".username").html()+"&bookid="+bookdetailsdata.url+"&title="+bookdetailsdata.title+"&author=" + bookdetailsdata.author.join('/') +
            "/&price=" + bookdetailsdata.price + "&imageurl=" + bookdetailsdata.image + "'>加入购物车</a></div></div></form>";

        $("#book-moredetails").append(bookDetail);
    }

})
