<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fill the form to find a car</title>
</head>
<body background="big_bend_texas_landscape.jpg">
<h1 style="text-align: center"><%= "Fill the form" %></h1>
<hr/>
<br/>
<form style="text-align: center" action="form">
    Car type: <input type = "text" name = "Type">
    <br />
    Brand: <input type = "text" name = "Brand">
    <br />
    Model: <input type = "text" name = "Model">
    <br />
    Production year: <input type = "text" name = "Prod">
    <br />
    Fuel Consumption: <input type = "text" name = "Fuel">
    <br />
    Mileage: <input type = "text" name = "Mileage" />

    <br/><br/>
        <button type="submit">Enter</button>
</form>
<br/>
<hr/>
<br/>
</body>
</html>