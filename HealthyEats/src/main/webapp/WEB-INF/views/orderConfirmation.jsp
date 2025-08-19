<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Order Confirmation - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container text-center py-5">
  <h2 class="text-success">🎉 Thank You for Your Order!</h2>
  <p>Your order has been placed successfully.</p>
  <p><strong>Order ID:</strong> ${orderId}</p>
  <p>You will receive delivery details via email/SMS shortly.</p>
  <a href="/menu" class="btn btn-primary mt-3">Continue Shopping</a>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
