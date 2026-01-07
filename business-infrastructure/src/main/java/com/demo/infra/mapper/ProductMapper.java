package com.demo.infra.mapper;

import com.demo.domain.model.Product;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: ProductMapper
 * Package: com.demo.infra.mapper
 * Description:
 *
 * @author ayp
 * @version 1.0
 * @since 2026/1/6 16:11
 */
public interface ProductMapper {
    /**
     * 插入商品（返回影响行数）
     * 插入成功后，希望 product.id 能自动回填（后面 XML 配置）
     */
    int insert(Product product);

    /**
     * 按 id 查询商品
     */
    Product selectById(@Param("id") Long id);
}
