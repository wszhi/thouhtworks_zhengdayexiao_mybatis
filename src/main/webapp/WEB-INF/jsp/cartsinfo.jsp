<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>book</title>
</head>
<body>
<%@ include file="pagehead.jsp"  %>
<script type="text/javascript" src="js/cartorderjs.js"></script>
<div class="books" >
<div  id="cartlist">
    <input name="userid" disabled type="hidden" value="${user.name}"/>
    <c:forEach items="${carts }" var="cart">
        <div class="onecarinfo">
            <img src='${cart.imageurl}' data-details="${cart.bookid}">
            <span>${cart.title}</span>
            <span>作者：${cart.author}</span>
            <span>价格：${cart.price}</span>
            <span>
                数量: <input type="number" class="cartnum" min="0" max="50"
                           value="${cart.number}" cur-cartid="${cart.id}" cur-bookid="${cart.bookid}"
                           cur-userid="${user.name}" />
            </span>
            <span class="priceall">总价格：${cart.allprice}</span>
            <a href="delfromcart?cartid=${cart.id}&userid=${user.name}" >删除</a>
        </div>
    </c:forEach>
    <center>
        <a href="javascript:;"class="aasbutton" id="order" onClick="orderform.style.display='block';">提交订单</a>

</center>

</div>
</div>
<div id="orderform" style="display:none;"><center>
    <div class="bg"></div>
    <DIV class="loginbg" ><!--弹出框-->
        <div id="divOneStep" >
            <div class="loginhide">
                <a href="javascript:;" onClick="orderform.style.display='none';">关闭</a>&nbsp;
            </div>
            <div class="orderdetails">
                <h3>订单详情</h3>
                <p>你好！${user.name}用户</p>
                <p>本次购物：总计${allnum}本书，一共${allprice}元</p>
                <button class="yesorder">确认</button>
                <button class="noorder">取消</button>
            </div>
        </div>
    </DIV>
</center>
</div>

</body>
</html> 