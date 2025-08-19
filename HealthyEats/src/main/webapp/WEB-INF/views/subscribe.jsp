<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Subscription Plans - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container py-5">
  <h2 class="text-center mb-4">Choose Your Subscription Plan</h2>
  <div class="row g-4">

    <!-- Loop through plans from backend -->
    <c:forEach var="sub" items="${subscriptions}">
      <div class="col-md-4">
        <div class="card shadow-sm h-100">
          <div class="card-body d-flex flex-column">
            <h4 class="card-title">${sub.name}</h4>
            <p class="text-muted">${sub.description}</p>
            <h5 class="fw-bold text-success">₹ ${sub.price}</h5>
            <p><b>${sub.meals}</b> Meals Included</p>

            <ul>
              <c:forEach var="feature" items="${sub.features}">
                <li>${feature}</li>
              </c:forEach>
            </ul>

            <div class="mt-auto">
              <a href="/checkout?planId=${sub.id}" class="btn btn-success w-100">Subscribe</a>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>

    <!-- Custom Plan Card -->
    <div class="col-md-4">
      <div class="card border-info h-100">
        <div class="card-body text-center d-flex flex-column justify-content-center">
          <h4 class="card-title">Custom Plan</h4>
          <p class="text-muted">Need something different? Contact us for a personalized subscription.</p>
          <a href="/contact" class="btn btn-outline-info">Contact Sales</a>
        </div>
      </div>
    </div>

  </div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
