<% String show = request.getParameter("show");
   if (show != null) {
     if (show.equals("all")) { %>

<p>Here's what we are selling: </p>
<ul>
<%

    Map<Item, String> inventory = new HashMap<>();
    inventory = InventoryManager.displayInventory("database");
    int sku = 100;
    for (Item item : inventory.keySet()) {
      out.println("<li><a href='model.jsp?show=" + sku + "'>" 
					+ item.name + "</a> $" + item.price 
					+ "</li>");
    }

%>
</ul>

<%   } else { %>
	<%--<jsp:include page="header.jsp"></jsp:include>--%>
	<div class="item">
			<% out.println("<h3>" + item.name + "</h3>"); %>
			<% out.println("<p>Price: $" + item.price + " || <a href='index.jsp?action=add&what=" + request.getParameter("show") + "'>Add to cart</a></p>"); %>
			<% out.println("<p>Quantity: " + inventory.get(item)); %>
			<% out.println("<img src='" + item.image + "' />"); %>
	</div>
	<%--<jsp:include page="footer.jsp"></jsp:include>--%>
<%      }
   }   else {

   }
 %>
