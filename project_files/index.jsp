<%@ page language="java" import="java.util.*" %>
<%@ page import="inventory.Item, inventory.InventoryManager" %>

<jsp:include page="header.jsp"></jsp:include>

<% String action = request.getParameter("action");
   if (action != null) {
     if (action.equals("browse")) { %>
       <jsp:include page="model.jsp">
       <jsp:param name="show" value="all" />
       </jsp:include>
<%   } else if (action.equals("view_cart")) {
       out.println("You want to View the Cart: <ul> "); // + session);
       int i = 0;
       for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); i++) {
         String attribName = (String) e.nextElement();
         Object attribValue = session.getAttribute(attribName);
         out.println("<li>" + attribName + ":" + attribValue);
       }
       if (i == 0) out.println( "Your cart is empty." );
       else out.println("</ul><p>Click <a href=\"?action=reset\">here</a> to reset your cart.");
     } else if (action.equals("add")) {
		Item item = new Item();
		item = InventoryManager.getItem(Integer.parseInt(request.getParameter("what")));
		String what = request.getParameter("what");
		if (what != null) {
			Object howMany = session.getAttribute(what);
			if (howMany == null) {
			session.setAttribute(what, new Integer(1));
			} else {
			session.setAttribute(what, 1 + (Integer)howMany);
         }
       } out.println("The item " + item.getName() + " has been added to your cart.");
     } else if (action.equals("reset")) {
       for (Enumeration e = session.getAttributeNames(); e.hasMoreElements(); ) {
         String attribName = (String) e.nextElement();
         session.removeAttribute(attribName);
       }
       out.println("Your cart is now empty.");
     } else if (action.equals("search")) {
       String search = request.getParameter("for");
       out.println("Searching for... <font size=+3>" + ( search == null ? "undefined" : search ) + "</font>");
     } else {
       out.println("Not sure what " + request.getParameter("action") + " is... ");
     }
   } else {
     out.println("Click on some of the links above...");
   }
 %>

<jsp:include page="footer.jsp"></jsp:include>
