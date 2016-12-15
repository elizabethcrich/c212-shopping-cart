<%@ page language="java" import="java.util.*" %>
<%@ page import="inventory.Item, inventory.InventoryManager" %>

<% String view = request.getParameter("view");
   if (view != null) {
     if (view.equals("all")) { %>

<p><a href="admin.jsp?view=orders">View current orders</a></p>
<p> <a href="admin.jsp?view=inventory">View current inventory</a></p>

<%   } else if (view.equals("orders")) { %>
        <p>Current orders:</p>
<%   } else if (view.equals("inventory")) { %>
        <p>Current inventory:</p>
<%      }
   }   else {
	   
   }
 %>
