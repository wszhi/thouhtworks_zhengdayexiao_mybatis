<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>book</title>
    <link rel="stylesheet" type="text/css" href="css/bookstyle2.css" />
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/books.js"></script>
    <script type="text/javascript" src="js/booklists.js"></script>
</head>
<body>
<div id="loginform" style="display:none;"><center>
    <div class="bg"></div>
    <DIV class="loginbg" ><!--弹出框-->
        <div id="divOneStep" >
            <div class="loginhide">
                <a href="javascript:;" onClick="loginform.style.display='none';">关闭</a>&nbsp;
            </div>
            <div>
                <form  action="login" method="post">
                    <h1>登录</h1>
                    <p>
                        <label  class="uname"  >用户名：</label>
                        <input  id="user_id"   border="1" name="name" required="required" />
                    </p>
                    <p>
                        <label  class="youpasswd" >密码：</label>
                        <input id="user_pw" type="password"  required="required" name="psw" />
                    </p>
                    <p >
                        <input  type="submit" class="buttonstyle"  value="登录" />
                    </p>
                </form>
            </div>
        </div>
    </DIV>
</center>
</div>
<div class="nav">
    <img class="logo" src="http://pic.qiantucdn.com/58pic/14/89/40/02u58PIC3pa_1024.jpg" />
    <a href="index?userid=${user.name}">首页</a>
    <div class="nav-items" value="2">
        <ul value="1">
            <li class="items"  value="儿童文学">儿童文学</li>
            <li class="items" value="小说">小说</li>
            <li class="items" value="原文">原文</li>
            <li class="items" value="教材">教材</li>
            <li class="items" value="生活">生活</li>
        </ul>

    </div>
    <div class="headuser">
        <a href="javascript:;" onClick="loginform.style.display='block';">${islogin}</a>
        <span class='username'>${user.name}</span>
        <span class='mycart'>我的购物车</span>
    </div>
</div>
<div class='search'>
    <input type ="text" id="search-content" placeholder="搜索书籍" />
    <button id='search-btn'>搜索</button>
</div>
<div class="books">
    <div id="top">顶部</div>
</div>


</body>
</html> 