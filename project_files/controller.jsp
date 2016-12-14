<%-- from Index.jsp --%>
<% String action = request.getParameter("action");
	// Action 
	if (action != null) {
		// Action -- Browse   
		if (action.equals("browse")) { %>
			<jsp:include page="model.jsp">
			<jsp:param name="show" value="all" />
			</jsp:include>
	<%   } 
		 // Action -- View Cart
		else if (action.equals("view_cart")) { %>
			<jsp:include page="index.jsp"></jsp:include>
<%
			out.println("You want to View the Cart: <ul> "); // + session);
			int i = 0;
			for (Enumeration<Object> e = session.getAttributeNames(); e.hasMoreElements(); i++) {
				String attribName = (String) e.nextElement();
				Object attribValue = session.getAttribute(attribName);
				out.println("<li>" + attribName + ":" + attribValue);
			}
			if (i == 0) out.println( "Your cart is empty." );
			else out.println("</ul><p>Click <a href=\"?action=reset\">here</a> to reset your cart.");
		} 
		// Action -- Add
		else if (action.equals("add")) {
			String what = request.getParameter("what");
			if (what != null) {
				Object howMany = session.getAttribute(what);
				if (howMany == null) {
					session.setAttribute(what, new Integer(1));
				} else {
				session.setAttribute(what, 1 + (Integer)howMany);
				}
			} out.println("The item (" + request.getParameter("what") + ") has been added to your cart.");
		} 
		// Action -- Reset
		else if (action.equals("reset")) {
			for (Enumeration<Object> e = session.getAttributeNames(); e.hasMoreElements(); ) {
				String attribName = (String) e.nextElement();
				session.removeAttribute(attribName);
			}
			out.println("Your cart is now empty.");
		} 
		// Action -- Search
		else if (action.equals("search")) {
			String search = request.getParameter("for");
			out.println("Searching for... <font size=+3>" + ( search == null ? "undefined" : search ) + "</font>");
		} 
		// Action -- other
		else {
			out.println("Not sure what " + request.getParameter("action") + " is... ");
		}
	} 
	// No Action selected
	else {
		out.println("Click on some of the links above...");
	}
 %>
 
 <%-- from Model.jsp --%>
 <% String show = request.getParameter("show");
	// Show
	if (show != null) {
		// Show -- All
		if (show.equals("all")) { %>
			<jsp:include page="model.jsp">
			<jsp:param name="show" value="all" />
			</jsp:include>
<%  	} 
		// Show -- item
		else { %>
			<jsp:include page="model.jsp">
			<jsp:param name="show" value="request.getParameter(\"show\")" />
			</jsp:include>
<%      }
	}
	// Show -- null
	else { %>
		<jsp:include page="index.jsp"></jsp:include>
<%
	}
 %>
