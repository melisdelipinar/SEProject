<%-- 
    Document   : login
    Created on : 28.Kas.2015, 22:08:39
    Author     : xxxxxxxxx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="YemekGetirRestoran.Restaurant"%>
<jsp:useBean    id="restoran"  class="YemekGetirRestoran.Restaurant" scope="session"></jsp:useBean>
<jsp:setProperty name="restoran" property="*"/>
<!DOCTYPE html>
<html>
 
<body>
    <% 
    boolean result=restoran.checkPassword();
    if(result){
    %>
    <jsp:forward page = "RestoranAnasayfa.html" /> 
    
    <%  }
    else{
    
    %>
    <h1>Error: Invalid password. <a href="restoran_giris.html">Try again</a></h1>
    
   
      
  <%}
    
  %>
</body>
</html>
