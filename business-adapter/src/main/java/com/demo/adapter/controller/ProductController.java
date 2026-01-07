package com.demo.adapter.controller;

import com.demo.app.service.ProductService;
import com.demo.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * ClassName: ProductController
 * Package: com.demo.adapter.controller
 * Description:
 *
 * @author ayp
 * @version 1.0
 * @since 2026/1/7 15:05
 */

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public long create(@RequestParam("name") String name,
                       @RequestParam("price") BigDecimal price,
                       @RequestParam("stock") Integer stock) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        p.setStock(stock);
        p.setStatus(1);

        return productService.create(p);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }
}
