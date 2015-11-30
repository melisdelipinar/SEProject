<%-- 
    Document   : SiparisTakip
    Created on : 29.Kas.2015, 02:09:17
    Author     : xxxxxxxxx
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="YemekGetirRestoran.Order1"%>
<%@page import="Database.database"%>
<%@page import="YemekGetirRestoran.User"%>
<%@page import="YemekGetirRestoran.Restaurant"%>
<%@page import="YemekGetirRestoran.Restaurant"%>
<%@page import="YemekGetirRestoran.Distinct"%>
<%@page import="YemekGetirRestoran.Address"%>
<%@page import="YemekGetirRestoran.Shoppingcart"%>
<%@page import="YemekGetirRestoran.Payment"%>
<jsp:useBean    id="payment"  class="YemekGetirRestoran.Payment" scope="session"></jsp:useBean>
<jsp:setProperty name="payment" property="*"/>
<jsp:useBean    id="address"  class="YemekGetirRestoran.Address" scope="session"></jsp:useBean>
<jsp:setProperty name="address" property="*"/>
<jsp:useBean    id="cart"  class="YemekGetirRestoran.Shoppingcart" scope="session"></jsp:useBean>
<jsp:setProperty name="cart" property="*"/>
<jsp:useBean    id="user"  class="YemekGetirRestoran.User" scope="session"></jsp:useBean>
<jsp:setProperty name="user" property="*"/>
<jsp:useBean    id="distinct"  class="YemekGetirRestoran.Distinct" scope="session"></jsp:useBean>
<jsp:setProperty name="distinct" property="*"/>
<jsp:useBean    id="database"  class="Database.database" scope="session"></jsp:useBean>
<jsp:setProperty name="database" property="*"/>
<jsp:useBean    id="order"  class="YemekGetirRestoran.Order1" scope="session"></jsp:useBean>
<jsp:setProperty name="order" property="*"/>
<jsp:useBean    id="restoran"  class="YemekGetirRestoran.Restaurant" scope="session"></jsp:useBean>
<jsp:setProperty name="restoran" property="*"/>

<!DOCTYPE html>
<html>
  <head>
    <title>Menu</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
     <link rel="stylesheet" href="siparisTablosu.css">
   <link rel="stylesheet" href="SiparisSatir.css">
</head>
<body>
    <div id='cssmenu'>
<ul>
    <li class='active'><a href='RestoranAnasayfa.html'><span>Anasayfa</span></a></li>
    <li><a href='SiparisTakip.jsp'><span>Sipariş Takip</span></a></li>
   <li><a href='Menu.html'><span>Menü</span></a></li>
    <li><a href='#'><span>Restoran Bilgisi</span></a></li>
   <li class='last'><a href='#'><span>Ürün Takip (Stok)</span></a></li>
</ul>
</div>
<br></br>
 
      <div ><table class="siparisTablosu" width="100%" >
       
<thead>
    <tr><th>Tutar</th>
        <th>Adres</th>
        <th>Sipariş Verilen Ürünler</th>
        <th>Sipariş Durumu</th></tr>
</thead> 
<tbody>
   

<%
        String resName=null;
  database.startDB();
  Connection  conn= database.getConnection();
  String sql= "select *from yemekgetir.`order` where checked=?";
  PreparedStatement psmt= conn.prepareStatement(sql);
  psmt.setInt(1, 0); 
  while(true){
      %>
     
  <% ResultSet rs= psmt.executeQuery();
 String[] mycart;
   while(rs.next()){
       
  
 %>
 <div ><table class="siparisSatir" width="100%" >
  <tr >
        <td 
            > 
            <p class="tabloText"><b> <%= restoran.getRestaurantName(rs.getInt(8)) %> </b></p>
            <p class="tabloText"><b>Sipariş No :<%= rs.getString(1) %></b></p>
             <button class="button">Yazdir</button>
        </td>
       <td>
           <p class="tabloText"><b><span style="background-color: cadetblue;color: #FFFFE0">Teslimat Bölgesi:</span>  <%= distinct.getDistinctName(rs.getInt(7)) %></b></p>
           <p class="tabloText"><b><span style="background-color: #f96e5b;color: #FFFFE0">Ad & Soyad:</span> <%= user.bringUsername(rs.getInt(2)) %> </b></p>
           <p class="tabloText"><b><span style="background-color: orange;color: #FFFFE0">Sipariş Tarih & Saat:</span><%= order.bringOrderTime(rs.getInt(1)) %></b></p>
           <p class="tabloText"><b><span style="background-color: darkorchid;color: #FFFFE0">CepTelefonu</span> <%= user.bringUserPhoneNumber(rs.getInt(2)) %></b></p>
           <p class="tabloText"><b><span style="background-color: limegreen;color: #FFFFE0">Adres</span>  <%= address.bringAdressDetails(rs.getInt(7)) %> </b></p>    
       </td>
       
       <td>
           <p class="tabloText"><b><span style="background-color: red;color: #FFFFE0"><% mycart=cart.bringCartinfo(rs.getInt(3)); %><%= mycart[1] %></span> x <%= mycart[0] %></b></p>
       </td>
            <td>
           <button class="Durumbutonu">Görüldü</button>
           <br></br>
           <button class="Durumbutonu">TeslimEdildi</button>
            <p class="tabloText"><b><span style="background-color: red;color: #FFFFE0">Ödeme Şekli</span> </b></p>
            <p class="tabloText"><b><%= payment.bringPaymentType(1) %></b></p>
             
       </td></tr>

</tbody>
</table></div>
    <%
  order.updateChecked();
}
%> 

</body>
</html>
<%
   
  }
%>