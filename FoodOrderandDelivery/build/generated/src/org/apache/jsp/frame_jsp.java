package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import FoodOrder.Frame;

public final class frame_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      FoodOrder.Frame frameId = null;
      synchronized (session) {
        frameId = (FoodOrder.Frame) _jspx_page_context.getAttribute("frameId", PageContext.SESSION_SCOPE);
        if (frameId == null){
          frameId = new FoodOrder.Frame();
          _jspx_page_context.setAttribute("frameId", frameId, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("frameId"), request);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            String ilce = frameId.getIlce() ;
            out.print(ilce) ;
                if (ilce == "Acibadem") {
                    try {
            
                Class.forName("com.mysql.jdbc.Driver") ;
                System.out.println("Driver loaded!") ;
                
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/yemekgetir", "root", "") ;
                System.out.println("Database connected!") ;
                
                //Statement stmt = conn.createStatement() ;
                
                PreparedStatement pStmt = conn.prepareStatement("select name from restaurant") ;
                
                ResultSet rs = pStmt.executeQuery() ;
                
                while(rs.next()) {   
      out.write("\n");
      out.write("                    \n");
      out.write("                    ");
      out.write("\n");
      out.write("                    <p>You entered the following data</p>\n");
      out.write("                    ");
      out.print( rs.getString(1)  );
      out.write("\n");
      out.write("                \n");
      out.write("                ");
}
                
                conn.close() ;
                
                }
            
             catch (Exception ex) {
                out.println(ex) ;
                ex.printStackTrace() ;
            }
                }
                
            
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
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
