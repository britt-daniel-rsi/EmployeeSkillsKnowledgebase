<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <script src="/webjars/jquery/2.1.4/jquery.js" ></script>
        <script>
       (function() { $.getJSON( "ESK/jersey/user/list", function( data ) {
        	  var items = [];
        	  $.each( data, function( key, val ) {
        	    items.push( "<li id='" + key + "'>" + val + "</li>" );
        	  });
        	 
        	  $( "<ul/>", {
        	    "class": "my-new-list",
        	    html: items.join( "" )
        	  }).appendTo( "body" );
        	});
       })();
        </script>
    </head>
    <body>
        <%= new java.util.Date() %>
    </body>
</html>