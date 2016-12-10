<link href="https://fonts.googleapis.com/css?family=Noto+Sans|Rammetto+One" rel="stylesheet">
<style type="text/css">
        h1, h2 { font-family: "Rammetto One", Arial, sans-serif; }
		h1 a { color: black; text-decoration: none; }
        body { font-family: "Noto Sans", Arial, sans-serif; background-color: #436497; }
        td { width: auto; padding: 2px 10px; }
        td form { margin:0; }
        .main { width: 840px; margin: 0 auto; padding: 10px 20px; background-color: #FFFFFF; }
		.signature { width: 840px; margin: 0 auto; padding: 10px 20px; text-align: center; }
</style>

<div class="main">
<h1><a href="/shopping-cart">Welcome to the store!</a></h1>
<table>
        <tr>
                <td>Search: </td>
                <td>
                        <form>
                                <input type="text" name="for">
                                <input type="hidden" name="action" value="search">
                        </form>
                </td>
                <td><a href="?action=view_cart">View Cart</a></td>
                <td><a href="?action=browse&show=all">Browse Merchandise</a></td> <!-- added show=all to test controller -->
        </tr>
</table>