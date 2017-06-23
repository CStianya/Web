<%--
  Created by IntelliJ IDEA.
  User: CS
  Date: 2017/6/22
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<! DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>

    <div id="global">
        <form action="product_save" method="post">
            <fieldset>
                <legend>Add a Product</legend>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name" value="" tabindex="1"><br>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" tabindex="2"><br>
                <label for="price">Price:</label>
                <input for="price" id="price" name="price" tabindex="3"><br>
                <div id="buttons">
                    <label> </label>
                    <input type="reset" id="reset" tabindex="4">
                    <input type="submit" id="subimit" tabindex="5" value="Add Produce">
                </div>
            </fieldset>
        </form>
    </div>

</body>
</html>
