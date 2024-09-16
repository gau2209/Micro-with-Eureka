package com.example.productservice;

import com.example.productservice.Entity.Product;
import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.Request.ProductRequest;
import com.example.productservice.Response.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
//    @Container
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));
//@Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @Autowired
//    private ProductRepository productRepository;
//
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry properties){
//        properties.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
//
//    }
//
//    @Test
//    void shouldCreateProduct() throws Exception {
//        ProductRequest p = getProductRequest();
//        String productRequest = objectMapper.writeValueAsString(p);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(productRequest))
//                .andExpect(MockMvcResultMatchers.status().isCreated());
//        Assertions.assertEquals(1, productRepository.findAll().size());
//    }
//
//    @Test
//    void shouldGetAll() throws Exception {
//        List<ProductResponse> Prod = getAllProductRes();
//        String ProductResponse = objectMapper.writeValueAsString(Prod);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/product/GetAllProd")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(ProductResponse))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
//    }
//
//    private ProductRequest getProductRequest() {
//        return ProductRequest.builder()
//                .name("Iphone 13").
//                description("Iphone 13").
//                price(BigDecimal.valueOf(13000))
//                .build();
//    }
//
//    private List<ProductResponse> getAllProductRes(){
//        List<Product> prod = productRepository.findAll();
//        List<ProductResponse> pRes = new ArrayList<>();
//        for (Product p : prod) {
//            ProductResponse pres = ProductResponse.builder()
//                    .id(p.getId())
//                    .name(p.getName())
//                    .description(p.getDescription())
//                    .price(p.getPrice())
//                    .build();
//            pRes.add(pres);
//        }
//        return pRes;
//    }

}
