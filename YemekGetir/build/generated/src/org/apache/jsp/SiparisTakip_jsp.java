package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import YemekGetirRestoran.Order1;
import Database.database;
import YemekGetirRestoran.User;
import YemekGetirRestoran.Restaurant;

public final class SiparisTakip_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      YemekGetirRestoran.User user = null;
      synchronized (session) {
        user = (YemekGetirRestoran.User) _jspx_page_context.getAttribute("user", PageContext.SESSION_SCOPE);
        if (user == null){
          user = new YemekGetirRestoran.User();
          _jspx_page_context.setAttribute("user", user, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("user"), request);
      out.write("\r\n");
      out.write("\r\n");
      Database.database database = null;
      synchronized (session) {
        database = (Database.database) _jspx_page_context.getAttribute("database", PageContext.SESSION_SCOPE);
        if (database == null){
          database = new Database.database();
          _jspx_page_context.setAttribute("database", database, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("database"), request);
      out.write('\r');
      out.write('\n');
      YemekGetirRestoran.Order1 order = null;
      synchronized (session) {
        order = (YemekGetirRestoran.Order1) _jspx_page_context.getAttribute("order", PageContext.SESSION_SCOPE);
        if (order == null){
          order = new YemekGetirRestoran.Order1();
          _jspx_page_context.setAttribute("order", order, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("order"), request);
      out.write('\r');
      out.write('\n');
      YemekGetirRestoran.Restaurant restoran = null;
      synchronized (session) {
        restoran = (YemekGetirRestoran.Restaurant) _jspx_page_context.getAttribute("restoran", PageContext.SESSION_SCOPE);
        if (restoran == null){
          restoran = new YemekGetirRestoran.Restaurant();
          _jspx_page_context.setAttribute("restoran", restoran, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("restoran"), request);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>Menu</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("     <link rel=\"stylesheet\" href=\"siparisTablosu.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div id='cssmenu'>\r\n");
      out.write("<ul>\r\n");
      out.write("    <li class='active'><a href='RestoranAnasayfa.html'><span>Anasayfa</span></a></li>\r\n");
      out.write("    <li><a href='SiparisTakip.jsp'><span>Sipariş Takip</span></a></li>\r\n");
      out.write("   <li><a href='Menu.html'><span>Menü</span></a></li>\r\n");
      out.write("    <li><a href='#'><span>Restoran Bilgisi</span></a></li>\r\n");
      out.write("   <li class='last'><a href='#'><span>Ürün Takip (Stok)</span></a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</div>\r\n");
      out.write("<br></br>\r\n");
      out.write(" \r\n");
      out.write("      <div ><table class=\"siparisTablosu\" width=\"100%\" >\r\n");
      out.write("       \r\n");
      out.write("<thead>\r\n");
      out.write("    <tr><th>Tutar</th>\r\n");
      out.write("        <th>Adres</th>\r\n");
      out.write("        <th>Sipariş Verilen Ürünler</th>\r\n");
      out.write("        <th>Sipariş Durumu</th></tr>\r\n");
      out.write("</thead> \r\n");
      out.write("<tbody>\r\n");
      out.write("   \r\n");
      out.write("\r\n");

        String resName=null;
  database.startDB();
  Connection  conn= database.getConnection();
  String sql= "select *from yemekgetir.`order` where checked=?";
  PreparedStatement psmt= conn.prepareStatement(sql);
  psmt.setInt(1, 0); 
 
  while(true){
      
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("  ");
 ResultSet rs= psmt.executeQuery();
 
   while(rs.next()){
       
  
 
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("      \r\n");
      out.write("     <tr class=\"siparisTablosu\">\r\n");
      out.write("        <td class=\"siparisTablosu \"> \r\n");
      out.write("            <p class=\"tabloText\"><b> ");
      out.print( restoran.getRestaurantName(rs.getInt(8)) );
      out.write(" </b></p>\r\n");
      out.write("            <p class=\"tabloText\"><b>");
      out.print( rs.getString(1) );
      out.write("</b></p>\r\n");
      out.write("             <button class=\"button\">Yazdir</button>\r\n");
      out.write("        </td>\r\n");
      out.write("       <td>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: cadetblue;color: #FFFFE0\">Teslimat Bölgesi:</span>  bolge</b></p>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: #f96e5b;color: #FFFFE0\">Ad & Soyad:</span> ");
 user.bringUsername(rs.getInt(2)).toString(); 
      out.write(" </b></p>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: orange;color: #FFFFE0\">Sipariş Tarih & Saat:</span>  saat</b></p>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: darkorchid;color: #FFFFE0\">CepTelefonu</span>  Cep</b></p>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: limegreen;color: #FFFFE0\">Adres</span>  adres</b></p>    \r\n");
      out.write("       </td>\r\n");
      out.write("       \r\n");
      out.write("       <td>\r\n");
      out.write("           <p class=\"tabloText\"><b><span style=\"background-color: red;color: #FFFFE0\">adet:</span> x ürün</b></p>\r\n");
      out.write("       </td>\r\n");
      out.write("       \r\n");
      out.write("       <td>\r\n");
      out.write("           <button class=\"Durumbutonu\">Görüldü</button>\r\n");
      out.write("           <br></br>\r\n");
      out.write("           <button class=\"Durumbutonu\">TeslimEdildi</button>\r\n");
      out.write("            <p class=\"tabloText\"><b><span style=\"background-color: red;color: #FFFFE0\">Ödeme Şekli</span> </b></p>\r\n");
      out.write("            <p class=\"tabloText\"><b>ödemeşekli</b></p>\r\n");
      out.write("             \r\n");
      out.write("       </td></tr>\r\n");
      out.write("     \r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("</tbody>\r\n");
      out.write("</table></div>\r\n");
      out.write("    ");

   order.updateChecked();
}

      out.write(" \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");

   
  }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
