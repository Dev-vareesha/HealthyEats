
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Customize - HealthyEats</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
  <h2>Build Your Bowl</h2>
  <form action="/customize/add" method="post" class="row g-3 mt-2">
    <div class="col-md-4">
      <label class="form-label">Base</label>
      <select class="form-select" name="base" required>
        <option value="Quinoa Base">Quinoa Base</option>
        <option value="Brown Rice Base">Brown Rice Base</option>
        <option value="Greens Base">Greens Base</option>
      </select>
    </div>
    <div class="col-md-4">
      <label class="form-label">Protein</label>
      <select class="form-select" name="protein">
        <option value="">None</option>
        <option value="Grilled Paneer">Grilled Paneer</option>
        <option value="Tofu">Tofu</option>
        <option value="Chickpeas">Chickpeas</option>
      </select>
    </div>
    <div class="col-md-4">
      <label class="form-label">Extra</label>
      <select class="form-select" name="extra">
        <option value="">None</option>
        <option value="Avocado">Avocado</option>
        <option value="Roasted Seeds">Roasted Seeds</option>
        <option value="Extra Veggies">Extra Veggies</option>
      </select>
    </div>
    <div class="col-12">
      <label class="form-label">Price</label>
      <input type="number" step="0.01" min="0" class="form-control" name="price" value="249" required>
    </div>
    <div class="col-12">
      <button class="btn btn-success" type="submit">Add to Cart</button>
    </div>
  </form>
</div>
</body>
</html>
