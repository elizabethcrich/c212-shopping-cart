<%@ page language="java" import="java.util.*" %>
<%@ page import="inventory.Item, inventory.InventoryManager" %>

<jsp:include page="header.jsp"></jsp:include>

<% String view = request.getParameter("view");
   if (view != null) {
     if (view.equals("all")) { %>

<p><a href="admin.jsp?view=inventory">View current inventory</a></p>
<p><a href="admin.jsp?view=orders">View current orders</a></p>

<%   } else if (view.equals("inventory")) { %>
        <h3>Current inventory:</h3>
		<ul>
		<% Map<Item, Integer> inventory = InventoryManager.getInventory(); // returns HashMap
			for (Item item : inventory.keySet()) {
			  out.println("<li><strong>" + item.toString() + "</strong><br/>Stock: " + inventory.get(item) + "<br/>SKU: " + item.getSku() + "</li>");
			}
		%>
		</ul>
<%   } else if (view.equals("orders")) { %>
        <h3>Current orders:</h3>
		
		
<%      }
   }   else {
	   
   }
 %>

<jsp:include page="footer.jsp"></jsp:include>
