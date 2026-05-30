DELIMITER $$

CREATE PROCEDURE findProductByPrice(
    IN minPrice DECIMAL(10,2),
    IN maxPrice DECIMAL(10,2)
)

BEGIN
SELECT
    products.id,
    products.name,
    products.description,
    products.price,
    products.category_id
FROM products
WHERE products.price BETWEEN minPrice AND maxPrice
ORDER BY products.name;
END $$

DELIMITER ;