package com.demo.app.service;

import com.demo.domain.model.Product;
import com.demo.infra.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
 * ClassName: ProductService
 * Package: com.demo.app.service
 * Description:
 *
 * @author ayp
 * @version 1.0
 * @since 2026/1/7 14:57
 */

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Long create(Product product) {
        productMapper.insert(product);
        return product.getId();
    }

    public Product getById(Long id) {
        return productMapper.selectById(id);
    }
}
