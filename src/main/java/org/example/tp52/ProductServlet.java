// ...existing code...
package org.example.tp52;

import dao.IDao;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.ProductDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    private IDao<Product> productDao;
    private ApplicationContext context;
    @Override
    public void init() throws ServletException {
        try {
            context = new AnnotationConfigApplicationContext(HibernateConfig.class);
            @SuppressWarnings("unchecked")
            IDao<Product> dao = (IDao<Product>) context.getBean("productDaoImpl");
            this.productDao = dao;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Impossible d'initialiser Spring", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDao.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        double price = 0.0;
        if (priceStr != null && !priceStr.isEmpty()) {
            try { price = Double.parseDouble(priceStr); } catch (NumberFormatException ignored) {}
        }
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        productDao.create(p);

        resp.sendRedirect(req.getContextPath() + "/products");
    }
}