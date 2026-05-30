package com.medhat.store.transactions;

import com.medhat.store.models.Category;
import com.medhat.store.models.Product;
import com.medhat.store.models.User;
import com.medhat.store.repositories.CategoryRepository;
import com.medhat.store.repositories.ProductRepository;
import com.medhat.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public void createProduct() {

        var category = Category.builder()
                .name("Electronics")
                .build();

        categoryRepository.save(category);

        var product = Product.builder()
                .name("Sample Product Electronic")
                .description("This is a sample product description.")
                .price(BigDecimal.valueOf(19.99))
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void addProductToCategory() {
        var category = categoryRepository.findById((byte) 1L).orElseThrow();
        var product = Product.builder().price(BigDecimal.valueOf(12.77)).description("WEWE").name("Sample Electronic").build();

        category.getProducts().add(product);
        categoryRepository.save(category);

        //shouldnt i do
        product.setCategory(category);
        productRepository.save(product);

    }

    @Transactional
    public void deleteProduct() {
        productRepository.deleteById(1L);
    }

    @Transactional
    public void productToWishlist() {

        var product = productRepository.findById(2L)
                .orElseThrow();

        var user = userRepository.findById(1L)
                .orElseThrow();

        user.getWishlist().add(product);
    }


    public void fetchProductByExample(){
        var product = new Product();
        product.setName("p");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);


        Example<Product> example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.findByCategory("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

}
