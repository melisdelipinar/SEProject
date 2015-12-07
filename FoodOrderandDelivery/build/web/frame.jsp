<%-- 
    Document   : frame
    Created on : Dec 6, 2015, 3:58:37 PM
    Author     : Kerem
--%>

<%@ page import = "java.sql.*" %>
<%@ page import = "FoodOrder.Frame" %>
<jsp:useBean id = "frameId" class = "FoodOrder.Frame" scope = "session"></jsp:useBean>
<jsp:setProperty name = "frameId" property = "*" />
<%@page  contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <style>
            
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
            
            .plus{
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
            
            .plus:hover{
                border:4px solid #1090c3;
                background-color: #1ab0ec; background-image: -webkit-gradient(linear, left top, left bottom, from(#1ab0ec), to(#1a92c2));
                background-image: -webkit-linear-gradient(top, #1ab0ec, #1a92c2);
                background-image: -moz-linear-gradient(top, #1ab0ec, #1a92c2);
                background-image: -ms-linear-gradient(top, #1ab0ec, #1a92c2);
                background-image: -o-linear-gradient(top, #1ab0ec, #1a92c2);
                background-image: linear-gradient(to bottom, #1ab0ec, #1a92c2);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#1ab0ec, endColorstr=#1a92c2);
            }
                
                
            
            </style>
    </head>
    
    <body>
        
        <table>
            <tr>
                <th2>RESTAURANTS</th2>
            </tr>
        </table>
        
        <%
            
            
            
            String ilce = frameId.getIlce() ;
            
                if (ilce.equals("Acibadem")) {
                    try {
            
                Class.forName("com.mysql.jdbc.Driver") ;
                System.out.println("Driver loaded!") ;
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/yemekgetir", "root", "") ;
                System.out.println("Database connected!") ;
                
                //Statement stmt = conn.createStatement() ;
                
                PreparedStatement pStmt = conn.prepareStatement("select name from restaurant where restaurantId=10000") ;
                PreparedStatement pStmt2 = conn.prepareStatement("select name from restaurant where restaurantId=10001") ;
                PreparedStatement pStmt3 = conn.prepareStatement("select name from restaurant where restaurantId=10002") ;
                PreparedStatement pStmt4 = conn.prepareStatement("select name from restaurant where restaurantId=10003") ;
                
                ResultSet rs = pStmt.executeQuery() ;
                ResultSet rs2 = pStmt2.executeQuery() ;
                ResultSet rs3 = pStmt3.executeQuery() ;
                ResultSet rs4 = pStmt4.executeQuery() ;
                
                while(rs.next()) {   %>
                    
                    <table>
                        <tr>
                            <th><a href="frame2.jsp" ><%= rs.getString(1)  %></th>
                        </tr>
                    </table>
                
                <%   
                
                }
                
                while(rs2.next()) { %>
                
                    <table>
                        <tr>
                            <th><a href="frame4.jsp" ><%= rs2.getString(1)  %></th>
                        </tr>
                    </table>
                    
                <%
                }
                
                while(rs3.next()) {   %>
                    
                    <table>
                        <tr>
                            <th><a href="frame5.jsp" ><%= rs3.getString(1)  %></th>
                        </tr>
                    </table>
                
                <%   
                
                }
                
                while(rs4.next()) { %>
                
                    <table>
                        <tr>
                            <th><a href="frame6.jsp" ><%= rs4.getString(1)  %></th>
                        </tr>
                    </table>
                    
                <%
                }
                
                conn.close() ;
                
                }
                    //PreparedStatement pStmt = conn.prepareStatement("select name from restaurant") ;
                    
                    
            
             catch (Exception ex) {
                out.println(ex) ;
                ex.printStackTrace() ;
            }
                } else {
                    out.print("") ;
                }
                
            %>
        
        
        
    </body>
    
</html>
