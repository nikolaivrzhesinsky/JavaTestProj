package com.example.springtestwithmock;

import com.example.springtestwithmock.com.models.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
class SpringTestWithMockApplicationTests {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    @Autowired
    private TestMySQLRepository mySqlRepository;

    private static RestTemplate restTemplate;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }


    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port + "").concat("/products");
    }

    @Test
    void contextLoads() {
    }

    @Test
    @Sql(statements = "DELETE FROM PRODUCT_TBL",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testAddPersonTrue() {

        Product addProduct = new Product("phone", 2, 40000);
        Product productResponse = restTemplate.postForObject(baseUrl, addProduct, Product.class);

        assertNotNull(productResponse);
        assertEquals("phone", productResponse.getName());
        assertEquals(1, mySqlRepository.findAll().size());

    }

    @Test
    @Sql(statements = "INSERT INTO PRODUCT_TBL (id,name, quantity, price) VALUES (4,'AC', 1, 34000)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "INSERT INTO product_tbl (id,name,quantity,price) values (5,'bd',2,500)",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT_TBL",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testGetProducts() {
        List products = restTemplate.getForObject(baseUrl, List.class);
        assertEquals(products.size(), mySqlRepository.findAll().size());
    }

}
