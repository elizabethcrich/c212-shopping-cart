<%@ page language="java" import="java.util.*" %>
<%@ page import="inventory.Item, inventory.InventoryManager" %>

<% String show = request.getParameter("show");
   if (show != null) {
     if (show.equals("all")) { %>

<p>Here's what we are selling: </p>
<ul>
<%

    @SuppressWarnings("unchecked") Map<Item, String> inventory = (HashMap<Item, String>) InventoryManager.displayInventory(); // returns HashMap
    int sku = 100;
    for (Item item : inventory.keySet()) {
      out.println("<li><a href='model.jsp?show=" + sku + "'>" 
					+ item.getName() + "</a> $" + item.getPrice() 
					+ "</li>");
    }

%>
</ul>

<%   } else { %>
	<%--<jsp:include page="header.jsp"></jsp:include>--%>
	<div class="item">
			<% out.println("<h3>" + item.getName() + "</h3>"); %>
			<% out.println("<p>Price: $" + item.getPrice() + " || <a href='index.jsp?action=add&what=" + request.getParameter("show") + "'>Add to cart</a></p>"); %>
			<% out.println("<p>Quantity: " + inventory.get(item)); %>
			<% out.println("<img src='" + item.getImage() + "' />"); %>
	</div>
	<%--<jsp:include page="footer.jsp"></jsp:include>--%>
<%      }
   }   else {

   }
 %>
