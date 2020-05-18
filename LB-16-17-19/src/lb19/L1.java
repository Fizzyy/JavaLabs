package lb19;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class L1 implements ServletContextListener {

    // Public constructor is required by servlet spec
    public L1() {
        System.out.println("L1 instance has been created");
    }

    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ServletContext servletContext = sce.getServletContext();
        System.out.println("--- L1 context initialized ---");
        System.out.println("Context path: " + servletContext.getContextPath());
        System.out.println("Server info: " + servletContext.getServerInfo());
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      System.out.println("--- L1 context destroyed ---");
    }
}
