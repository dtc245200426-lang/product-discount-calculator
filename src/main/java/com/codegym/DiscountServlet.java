package com.codegym;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="DiscountServlet", urlPatterns="/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String content;
        try {
            String description = request.getParameter("description");
            if (description == null || description.isBlank() || description.length() > 500) throw new IllegalArgumentException();
            BigDecimal price = number(request.getParameter("listPrice"));
            BigDecimal percent = number(request.getParameter("discountPercent"));
            if (percent.compareTo(new BigDecimal("100")) > 0) throw new IllegalArgumentException();
            BigDecimal amount = price.multiply(percent).multiply(new BigDecimal("0.01"));
            BigDecimal finalPrice = price.subtract(amount);
            content = "<h1>Discount Result</h1><dl><dt>Product Description</dt><dd>" + escape(description.trim())
                + "</dd><dt>List Price</dt><dd>" + money(price)
                + "</dd><dt>Discount Percent</dt><dd>" + percent.toPlainString()
                + "%</dd><dt>Discount Amount</dt><dd>" + money(amount)
                + "</dd><dt>Discount Price</dt><dd>" + money(finalPrice) + "</dd></dl>";
        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            content = "<h1>Invalid input</h1><p>Enter a product description, a non-negative list price and a discount from 0 to 100%.</p>";
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1'><title>Discount Result</title></head><body>");
            out.println(content);
            out.println("<a href='index.jsp'>Calculate another discount</a></body></html>");
        }
    }
    private static BigDecimal number(String value) {
        if (value == null || value.length() > 30 || !value.trim().matches("[0-9]+(\\.[0-9]{1,2})?")) throw new IllegalArgumentException();
        return new BigDecimal(value.trim());
    }
    private static String money(BigDecimal value) { return value.setScale(2, RoundingMode.HALF_UP).toPlainString(); }
    private static String escape(String value) { return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;"); }
}
