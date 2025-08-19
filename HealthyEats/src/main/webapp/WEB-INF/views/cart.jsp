
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Cart - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <h2>Your Cart</h2>
  <c:choose>
    <c:when test="${empty cartItems}">
      <p>Your cart is empty.</p>
      <a href="/menu" class="btn btn-outline-success">Browse Menu</a>
    </c:when>
    <c:otherwise>
      <table class="table">
        <thead><tr><th>Item</th><th>Qty</th><th>Price</th><th>Total</th><th></th></tr></thead>
        <tbody>
        <c:forEach var="item" items="${cartItems}">
          <tr>
            <td>${item.name}</td>
            <td>${item.quantity}</td>
            <td>₹ ${item.price}</td>
            <td>₹ ${item.price * item.quantity}</td>
            <td>
              <form action="/cart/delete/${item.id}" method="post">
                <button class="btn btn-link text-danger p-0">Remove</button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <div class="d-flex justify-content-between align-items-center">
        <h4>Total: ₹ ${totalPrice}</h4>
        <a class="btn btn-success" href="/checkout">Proceed to Checkout</a>
      </div>
    </c:otherwise>
  </c:choose>
</div>
</body>
</html>
