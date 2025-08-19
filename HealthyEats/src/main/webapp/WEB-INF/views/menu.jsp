
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="https://jakarta.ee/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Menu - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <h2 class="mb-4">Menu</h2>

  <div class="mb-3">
    <a href="/menu" class="btn btn-outline-secondary btn-sm">All</a>
    <a href="/menu?category=Fresh+Salads" class="btn btn-outline-secondary btn-sm">Fresh Salads</a>
    <a href="/menu?category=Energy+Bowls" class="btn btn-outline-secondary btn-sm">Energy Bowls</a>
    <a href="/menu?category=Cold-Pressed+Juices" class="btn btn-outline-secondary btn-sm">Cold-Pressed Juices</a>
    <a href="/menu?category=Detox+Smoothies" class="btn btn-outline-secondary btn-sm">Detox Smoothies</a>
    <a href="/menu?category=Healthy+Wraps" class="btn btn-outline-secondary btn-sm">Healthy Wraps</a>
  </div>

  <div class="row g-3">
    <c:forEach var="item" items="${items}">
      <div class="col-md-4">
        <div class="card h-100">
          <img class="card-img-top" src="${item.imageUrl}" alt="${item.name}">
          <div class="card-body">
            <h5 class="card-title">${item.name}</h5>
            <p class="card-text small">${item.description}</p>
            <div class="d-flex justify-content-between align-items-center">
              <span class="fw-bold">₹ ${item.price}</span>
              <form action="/cart/add" method="post">
                <input type="hidden" name="name" value="${item.name}"/>
                <input type="hidden" name="price" value="${item.price}"/>
                <button class="btn btn-success btn-sm" type="submit">Add to Cart</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
</body>
</html>
