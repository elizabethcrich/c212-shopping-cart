<%@ page language="java" import="java.util.*" %>
<%@ page import="inventory.Item, inventory.InventoryManager" %>

<jsp:include page="header.jsp"></jsp:include>

<% String show = request.getParameter("show");
   if (show != null) {
     if (show.equals("all")) { %>

<p>Here's what we are selling: </p>
<ul>
  <li> <a href="model.jsp?show=100">Low Gap Trail Map</a></li>
  <li> <a href="model.jsp?show=200">Pate Hollow Trail Map</a></li>
  <li> <a href="model.jsp?show=300">Three Lakes Trail Map</a></li>
  <li> <a href="model.jsp?show=400">Nebo Ridge Trail Map</a></li>
  <li> <a href="model.jsp?show=500">Peninsula Trail Map</a></li>
  <li> <a href="model.jsp?show=600">Sycamore Loop Trail Map</a></li>
  <li> <a href="model.jsp?show=700">Tecumseh Trail Map</a></li>
  <li> <a href="model.jsp?show=800">Adventure Hiking Trail Map</a></li>
  <li> <a href="model.jsp?show=900">Knobstone Trail Map</a></li>

</ul>

<%   } else { %>
        <% Item item = new Item();
                        item = InventoryManager.getItem(Integer.parseInt(request.getParameter("show"))); %>
        <div>
                        <% out.println("<h3>" + item.getName() + "</h3>"); %>
                        <% out.println("<p>Price: $" + item.getPrice() + " || <a href='index.jsp?action=add&what=" + item.getSku() + "'>Add to cart</a></p>"); %>
                        <% out.println("<img src='" + item.getImage() + "' width='600' />"); %>
        </div>
<%      }
   }   else {

   }
 %>

<jsp:include page="footer.jsp"></jsp:include>
