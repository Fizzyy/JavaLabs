package lb19;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class L2 implements HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public L2() {
        System.out.println("L2 instance has been created");
    }

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        System.out.println("---");
        System.out.println("Attribute Added: " + sbe.getName() + " " + sbe.getValue());
        System.out.println("Session ID: " + sbe.getSession().getId());
        System.out.println("---");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        System.out.println("---");
        System.out.println("Attribute removed: " + sbe.getName() + " " + sbe.getValue());
        System.out.println("Session ID: " + sbe.getSession().getId());
        System.out.println("---");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
        System.out.println("---");
        System.out.println("Attribute replaced: " + sbe.getName() + " " + sbe.getValue());
        System.out.println("Session ID: " + sbe.getSession().getId());
        System.out.println("---");
    }
}
