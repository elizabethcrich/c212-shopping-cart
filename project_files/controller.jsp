<%-- from Index.jsp --%>
<% String action = request.getParameter("action");
   if (action != null) {
     if (action.equals("browse")) { %>
<%--        <jsp:include page="model.jsp">
		<jsp:param name="show" value="all" />
       </jsp:include> --%>
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
       String what = request.getParameter("what");
       if (what != null) {
         Object howMany = session.getAttribute(what);
         if (howMany == null) {
           session.setAttribute(what, new Integer(1));
         } else {
           session.setAttribute(what, 1 + (Integer)howMany);
         }
       } out.println("The item (" + request.getParameter("what") + ") has been added to your cart.");
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
 
 <%-- from Model.jsp --%>
 <% String show = request.getParameter("show");
   if (show != null) {
     if (show.equals("all")) { %>
	
<%   } else { %>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="item">
			<% out.println("<h3 id='itemName'>Nicolas Cage for " + request.getParameter("show") + "</h3>"); %>
			<% out.println("<p>Price: $23.67 || <a href='index.jsp?action=add&what=" + request.getParameter("show") + "'>Add to cart</a></p>"); %>
			<% out.println("<img src='https://www.placecage.com/" + request.getParameter("show") + "/" + request.getParameter("show") + "' />"); %>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<%      }
   }   else {

   }
 %>
