<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Product Discount Calculator</title>
<style>body{font-family:Arial,sans-serif;margin:0;min-height:100vh;display:grid;place-items:center;background:#f8fafc}main{width:min(400px,80vw);padding:30px;background:white;border-radius:12px;box-shadow:0 4px 16px #0001}h1{font-size:24px;color:#1b2a7a}label{display:block;margin-top:18px}input,button{width:100%;padding:12px;margin-top:6px;box-sizing:border-box;border:1px solid #ccc;border-radius:6px}button{margin-top:22px;background:#1b2a7a;color:white;cursor:pointer}</style></head>
<body><main><h1>Product Discount Calculator</h1><form action="display-discount" method="POST">
<label for="description">Product Description</label><input id="description" name="description" maxlength="500" required>
<label for="listPrice">List Price</label><input id="listPrice" name="listPrice" type="number" min="0" step="0.01" required>
<label for="discountPercent">Discount Percent (%)</label><input id="discountPercent" name="discountPercent" type="number" min="0" max="100" step="0.01" required>
<button type="submit">Calculate Discount</button></form></main></body></html>
