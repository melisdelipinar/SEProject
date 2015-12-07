<%-- 
    Document   : frame5
    Created on : Dec 7, 2015, 12:12:50 PM
    Author     : Kerem
--%>

<%@ page import = "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            .plus{
 border:1px solid #91b41a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #b6e026; background-image: -webkit-gradient(linear, left top, left bottom, from(#b6e026), to(#abdc28));
 background-image: -webkit-linear-gradient(top, #b6e026, #abdc28);
 background-image: -moz-linear-gradient(top, #b6e026, #abdc28);
 background-image: -ms-linear-gradient(top, #b6e026, #abdc28);
 background-image: -o-linear-gradient(top, #b6e026, #abdc28);
 background-image: linear-gradient(to bottom, #b6e026, #abdc28);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#b6e026, endColorstr=#abdc28);
 text-align: center ;
 width: 30px ;
            }

.plus{
 border:1px solid #718c14;
 background-color: #95b91a; background-image: -webkit-gradient(linear, left top, left bottom, from(#95b91a), to(#8bb41d));
 background-image: -webkit-linear-gradient(top, #95b91a, #8bb41d);
 background-image: -moz-linear-gradient(top, #95b91a, #8bb41d);
 background-image: -ms-linear-gradient(top, #95b91a, #8bb41d);
 background-image: -o-linear-gradient(top, #95b91a, #8bb41d);
 background-image: linear-gradient(to bottom, #95b91a, #8bb41d);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#95b91a, endColorstr=#8bb41d);
}
            
            
            
            table, td, th, th2 {
                border: 1px solid black;
            }
            
            table {
                border-collapse: collapse;
                width: 100%;
            }
            
            th {
                text-align: center;
                font-size: 30px ;
            }
            
            th2 {
                text-align: left ;
                background-color: gray ;
                color: white ;
                font-size: 50px ;
            }
            </style>
    </head>
    
    <body>
        <table>
            <tr>
                <th2>MENU</th2>
            </tr>
        </table>
        
        
        
        <%
            
            
            
            
                    try {
            
                Class.forName("com.mysql.jdbc.Driver") ;
                System.out.println("Driver loaded!") ;
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/yemekgetir", "root", "") ;
                System.out.println("Database connected!") ;
                
                //Statement stmt = conn.createStatement() ;
                
                PreparedStatement pStmt = conn.prepareStatement("select menuItemName,description from menuItem where menuItem.menuId = 1000002") ;
                
                ResultSet rs = pStmt.executeQuery() ;
                
                while(rs.next()) {   %>
                    
                    <%--System.out.println(rs.getString(1)) ;--%>
                    <table>
                        <tr>
                            <th> <p align="left"><%= rs.getString(1)  %></p>    <a class="plus" href="frame3.jsp" style="float: left">+</a>      <font size="3px" color="gray"> <%= rs.getString(2)  %> </font></th>
                        </tr>
                    </table>
                
                <%}
                
                conn.close() ;
                
                }
                    //PreparedStatement pStmt = conn.prepareStatement("select name from restaurant") ;
                    
                    
            
             catch (Exception ex) {
                out.println(ex) ;
                ex.printStackTrace() ;
            }
                
            %>
        
        
        
        
    </body>
    
</html>
