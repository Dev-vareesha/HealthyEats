<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Checkout - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container py-5">
  <h2 class="mb-4">Checkout</h2>

  <form action="/checkout/confirm" method="post" class="row g-3">
    <!-- Delivery -->
    <div class="col-md-6">
      <label class="form-label">Full Name</label>
      <input type="text" name="name" class="form-control" required>
    </div>
    <div class="col-md-6">
      <label class="form-label">Phone</label>
      <input type="text" name="phone" class="form-control" required>
    </div>
    <div class="col-12">
      <label class="form-label">Address</label>
      <textarea name="address" class="form-control" rows="2" required></textarea>
    </div>
    <div class="col-md-6">
      <label class="form-label">City</label>
      <input type="text" name="city" class="form-control" required>
    </div>
    <div class="col-md-6">
      <label class="form-label">Pincode</label>
      <input type="text" name="pincode" class="form-control" required>
    </div>

    <!-- Payment -->
    <div class="col-12">
      <h5 class="mt-4">Payment Method</h5>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="paymentMethod" value="COD" checked>
        <label class="form-check-label">Cash on Delivery</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="paymentMethod" value="UPI">
        <label class="form-check-label">UPI</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="paymentMethod" value="CARD">
        <label class="form-check-label">Credit/Debit Card</label>
      </div>
    </div>

    <!-- Summary -->
    <div class="col-12">
      <h5 class="mt-4">Order Summary</h5>
      <jsp:include page="cartSummary.jsp" />
    </div>

    <div class="col-12">
      <button type="submit" class="btn btn-success w-100">Place Order</button>
    </div>
  </form>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
