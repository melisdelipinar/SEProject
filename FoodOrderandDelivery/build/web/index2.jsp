<%-- 
    Document   : index2
    Created on : Nov 29, 2015, 8:20:17 PM
    Author     : Kerem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="theme2.css">
        
    <input class="textbox5"type="text" placeholder="Kullanıcı Adı / E-posta"> 
        
        <style> 
            .textbox5 {
                padding: 3px 20px;
                margin-left: 500px ;
                border: 0;
                height: 25px;
                width: 275px;
                border-radius: 10px;
                -moz-border-radius: 10px;
                -webkit-border-radius: 10px;
                box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -moz-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-background-clip: padding-box;
                outline: 0;
            }
            
        </style>
        
        
    <input class="textbox6"type="text" placeholder="Şifre"> 
        
        <style> 
            .textbox6 {
                padding: 3px 20px;
                margin-left: 125px ;
                border: 0;
                height: 25px;
                width: 275px;
                border-radius: 10px;
                -moz-border-radius: 10px;
                -webkit-border-radius: 10px;
                box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -moz-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-background-clip: padding-box;
                outline: 0;
            }
            
            
            .giris{
border:1px solid #ffc826; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #ffd65e; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffd65e), to(#febf04));
 background-image: -webkit-linear-gradient(top, #ffd65e, #febf04);
 background-image: -moz-linear-gradient(top, #ffd65e, #febf04);
 background-image: -ms-linear-gradient(top, #ffd65e, #febf04);
 background-image: -o-linear-gradient(top, #ffd65e, #febf04);
 background-image: linear-gradient(to bottom, #ffd65e, #febf04);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#ffd65e, endColorstr=#febf04);
 margin-left: 350px ;
}

.giris:hover{
 border:1px solid #f7b800;
 background-color: #ffc92b; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffc92b), to(#ce9a01));
 background-image: -webkit-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -moz-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -ms-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -o-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: linear-gradient(to bottom, #ffc92b, #ce9a01);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#ffc92b, endColorstr=#ce9a01);
}

            .sifremiunuttum{
border:1px solid #ffc826; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #ffd65e; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffd65e), to(#febf04));
 background-image: -webkit-linear-gradient(top, #ffd65e, #febf04);
 background-image: -moz-linear-gradient(top, #ffd65e, #febf04);
 background-image: -ms-linear-gradient(top, #ffd65e, #febf04);
 background-image: -o-linear-gradient(top, #ffd65e, #febf04);
 background-image: linear-gradient(to bottom, #ffd65e, #febf04);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#ffd65e, endColorstr=#febf04);
 margin-left: 575px ;
}

.sifremiunuttum:hover{
 border:1px solid #f7b800;
 background-color: #ffc92b; background-image: -webkit-gradient(linear, left top, left bottom, from(#ffc92b), to(#ce9a01));
 background-image: -webkit-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -moz-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -ms-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: -o-linear-gradient(top, #ffc92b, #ce9a01);
 background-image: linear-gradient(to bottom, #ffc92b, #ce9a01);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#ffc92b, endColorstr=#ce9a01);
}

/* COLORED OUTSET BUTTONS */

.outset-colored {
	font-family: Helvetica, Verdana, Arial, sans-serif;
	font-size: 14px;
	list-style-type: none;
	margin: 10px 0 0 10px;
}

.outset-colored ul { list-style-type: none; display: block; }

.outset-colored li {
	float: left;
	height: 30px;
	margin: 0 8px 7px 0;
}

.outset-colored li a {
	color: #424242;
	float: left;
	font-size: 16px;
	font-weight: bold;
        margin-left: 715px ;
	height: 24px;
	padding-left: 27px;
	padding-top: 6px;
	position: relative;
	text-decoration: none;
	border: 1px solid #bfc1c6;
	border-radius: 5px;
	background-color: #D8D9DD;
	-moz-border-radius: 5px;
	-webkit-borer-radius: 5px;	
}


/* FACEBOOK */
.outset-colored li a.facebook {
	background: -moz-linear-gradient(#7aa3f7, #4c72c3 10%, #3b5998);
	background: -webkit-gradient(linear,left top,left bottom,color-stop(0, #7aa3f7),color-stop(.10, #4c72c3),color-stop(1, #3b5998));
	color: #f3f3f3;
	border: 3px solid #3b5998;
}

.outset-colored li a:hover.facebook {
	background: -moz-linear-gradient(#3b5998, #4c72c3 1%, #5c8aea 10%, #5c8aea);
	background: -webkit-gradient(linear,left top,left bottom,color-stop(0, #3b5998),color-stop(.01, #4c72c3),color-stop(.10, #5c8aea),color-stop(1, #5c8aea));
}

.outset-colored li a img {
	height: 16px;
	left: 7px;
	margin-right: 7px;
        margin-left: 70px ;
	position: absolute;
	top: 7px;
	width: 16px;
   border: none;
}

.outset-colored li a span {
	display: block;
	height: 22px;
	padding-right: 70px;
	overflow: hidden;
        margin-left: 70px ;
	/*width: 70px; Add a width here if you want all the buttons to be the same size.*/
}

span.site { font-size: 14px; line-height: 20px; }

hr {
    border-width: 3px;
    border-color: red ;
}


/* The CSS */
select {
    padding:10px;
    margin: 0;
    -webkit-border-radius:4px;
    -moz-border-radius:4px;
    border-radius:4px;
    -webkit-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    -moz-box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    box-shadow: 0 3px 0 #ccc, 0 -1px #fff inset;
    background: #f8f8f8;
    color:#888;
    border:none;
    outline:none;
    display: inline-block;
    -webkit-appearance:none;
    -moz-appearance:none;
    appearance:none;
    cursor:pointer;
    margin-left: 100px ;
    width: 600px ;
    text-align: center ;
}


label {position:relative}
label:after {
    content:'<>';
    font:15px "Consolas", monospace;
    color:#febf04 ;
    -webkit-transform:rotate(90deg);
    -moz-transform:rotate(90deg);
    -ms-transform:rotate(90deg);
    transform:rotate(90deg);
    right:8px; top:2px;
    padding:0 0 2px;
    border-bottom:1px solid #ddd;
    position:absolute;
    pointer-events:none;
}
label:before {
    content:'';
    right:6px; top:0px;
    width:20px; height:20px;
    background:#f8f8f8;
    position:absolute;
    pointer-events:none;
    display:block;
}

.ara{
border:4px solid #15aeec; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #49c0f0; background-image: -webkit-gradient(linear, left top, left bottom, from(#49c0f0), to(#2CAFE3));
 background-image: -webkit-linear-gradient(top, #49c0f0, #2CAFE3);
 background-image: -moz-linear-gradient(top, #49c0f0, #2CAFE3);
 background-image: -ms-linear-gradient(top, #49c0f0, #2CAFE3);
 background-image: -o-linear-gradient(top, #49c0f0, #2CAFE3);
 background-image: linear-gradient(to bottom, #49c0f0, #2CAFE3);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#49c0f0, endColorstr=#2CAFE3);
 margin-left: 100px ;
 width: 300px ;
 text-align: center ;
}

.ara:hover{
 border:4px solid #1090c3;
 background-color: #1ab0ec; background-image: -webkit-gradient(linear, left top, left bottom, from(#1ab0ec), to(#1a92c2));
 background-image: -webkit-linear-gradient(top, #1ab0ec, #1a92c2);
 background-image: -moz-linear-gradient(top, #1ab0ec, #1a92c2);
 background-image: -ms-linear-gradient(top, #1ab0ec, #1a92c2);
 background-image: -o-linear-gradient(top, #1ab0ec, #1a92c2);
 background-image: linear-gradient(to bottom, #1ab0ec, #1a92c2);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#1ab0ec, endColorstr=#1a92c2);
}


            
        
        
        
        </style>
        
        <style> 
            .textbox7 {
                padding: 10px 20px;
                margin-left: 100px ;
                border: 0;
                height: 25px;
                width: 500px;
                border-radius: 10px;
                -moz-border-radius: 10px;
                -webkit-border-radius: 10px;
                box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -moz-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-box-shadow: 1px 1px 0 0 #FFF, 5px 5px 40px 2px #BBB inset;
                -webkit-background-clip: padding-box;
                outline: 0;
            }
            
        </style>
        
        <title>JSP Page</title>
        
    </head>
    
    <body>
        
        <p class="topLine"><font face="Helvetica" size="15px" color="white"><label>     </label></font></p>
        
        
        <a class="sifremiunuttum" href="#">ŞİFREMİ UNUTTUM</a>
        <a class="giris" href="#">GİRİŞ YAP</a>
        
        <div class="outset-colored">

        <li>
			<a href="http://facebook.com" title="My Facebook Page" class="facebook">
				<img src="images/facebook_white.png" alt="Facebook icon" />
				<span class="site">Facebook ile Giriş Yap</span>
			</a>
		</li>

        </div>
        
        <br>
        <br>
        <br>
        
        <hr>
        
        <label>
    <select>
        <option selected> Semtler </option>
        <option>Acıbadem</option>
        <option>Adatepe</option>
        <option>Akatlar</option>
        <option>Aksaray</option>
        <option>Alibeyköy</option>
        <option>Altunizade</option>
        <option>Anadoluhisarı</option>
    </select>
</label>
        
        <input class="textbox7"type="text" placeholder="Yemek, mutfak veya restoran arayın.">
        
        <a class="ara" href="#">ARAŞTIR</a>

    </body>
    
</html>
