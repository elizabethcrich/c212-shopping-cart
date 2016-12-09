<% String show = request.getParameter("show");
   if (show != null) {
     if (show.equals("all")) { %>

<p>Here's what we are selling: </p>
<ul>
  <li> <a href="model.jsp?action=browse&show=100">Nicolas Cage for 100</a></li>
  <li> <a href="model.jsp?show=200">Nicolas Cage for 200</a></li>
  <li> <a href="model.jsp?show=300">Nicolas Cage for 300</a></li>
  <li> <a href="model.jsp?show=400">Nicolas Cage for 400</a></li>
  <li> <a href="model.jsp?show=500">Nicolas Cage for 500</a></li>
  <li> <a href="model.jsp?show=600">Nicolas Cage for 600</a></li>
  <li> <a href="model.jsp?show=700">Nicolas Cage for 700</a></li>
  <li> <a href="model.jsp?show=800">Nicolas Cage for 800</a></li>
</ul>

<%   } else { %>
	<%--<jsp:include page="header.jsp"></jsp:include>--%>
	<div class="item">
			<% out.println("<h3 id='itemName'>Nicolas Cage for " + request.getParameter("show") + "</h3>"); %>
			<% out.println("<p>Price: $23.67 || <a href='index.jsp?action=add&what=" + request.getParameter("show") + "'>Add to cart</a></p>"); %>
			<% out.println("<img src='https://www.placecage.com/" + request.getParameter("show") + "/" + request.getParameter("show") + "' />"); %>
	</div>
	<%--<jsp:include page="footer.jsp"></jsp:include>--%>
<%      }
   }   else {

   }
 %>
