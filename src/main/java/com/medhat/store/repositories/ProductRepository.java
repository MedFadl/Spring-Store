package com.medhat.store.repositories;

import com.medhat.store.models.Category;
import com.medhat.store.models.Product;
import com.medhat.store.projections.ProductSummary;
import com.medhat.store.projections.ProductSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> , ProductCriteriaAPI , JpaSpecificationExecutor<Product> {

    // =========================================================
    // BASIC STRING QUERIES
    // =========================================================

    List<Product> findByName(String name);

    List<Product> findByNameLike(String pattern);

    List<Product> findByNameNotLike(String pattern);

    List<Product> findByNameContaining(String keyword);

    List<Product> findByNameStartingWith(String prefix);

    List<Product> findByNameEndingWith(String suffix);

    List<Product> findByNameEndingWithIgnoreCase(String suffix);


    // =========================================================
    // NUMBER QUERIES
    // =========================================================

    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(
            BigDecimal min,
            BigDecimal max
    );


    // =========================================================
    // NULL CHECKS
    // =========================================================

    List<Product> findByDescriptionNull();

    List<Product> findByDescriptionNotNull();


    // =========================================================
    // MULTIPLE CONDITIONS
    // =========================================================

    List<Product> findByDescriptionNullAndNameNull();


    // =========================================================
    // SORTING
    // =========================================================

    List<Product> findByNameOrderByPrice(String name);

    List<Product> findByPriceBetweenOrderByName(
            BigDecimal min,
            BigDecimal max
    );


    // =========================================================
    // LIMITING RESULTS
    // =========================================================

    List<Product> findTop5ByNameOrderByPrice(String name);

    List<Product> findFirst5ByNameLikeOrderByPrice(String pattern);


    // =========================================================
    // NATIVE SQL QUERY
    // =========================================================

    @Query(
            value = """
                SELECT *
                FROM products p
                WHERE p.price BETWEEN :min AND :max
                ORDER BY p.name
                """,
            nativeQuery = true
    )
    List<Product> findProductsNative(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );


    // =========================================================
    // JPQL QUERY
    // =========================================================

    @Query("""
            SELECT p
            FROM Product p
            WHERE p.price BETWEEN :min AND :max
            ORDER BY p.name
            """)
    List<Product> findProductsJPQL(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );

    //when we use class we do differnet projection by typing new com.medhat.store.projections.blabla(p.id,p.name)


    // =========================================================
    // AGGREGATE FUNCTIONS
    // =========================================================

    @Query("""
            SELECT COUNT(p)
            FROM Product p
            WHERE p.price BETWEEN :min AND :max
            """)
    long countProducts(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max
    );


    // =========================================================
    // UPDATE QUERIES
    // =========================================================
    // IMPORTANT:
    // - Must run inside @Transactional service method
    // - @Modifying required for UPDATE / DELETE queries
    // =========================================================

    @Modifying
    @Query("""
            UPDATE Product p
            SET p.category.id = :categoryId
            WHERE p.id = :productId
            """)
    void updateProductCategory(
            @Param("productId") Long productId,
            @Param("categoryId") Long categoryId
    );
}
