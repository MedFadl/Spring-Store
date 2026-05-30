package com.medhat.store.repositories;

import com.medhat.store.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaAPI {
    List<Product> findByCategory(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
