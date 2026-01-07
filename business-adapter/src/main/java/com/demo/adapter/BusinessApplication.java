package com.demo.adapter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * ClassName: BusinessApplication
 * Package: com.demo.adapter
 * Description:
 *
 * @author ayp
 * @version 1.0
 * @date 2025/12/25 16:50
 */

@SpringBootApplication
@MapperScan("com.demo.infra.mapper")
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
