package com.medhat.store.transactions;

import com.medhat.store.models.Address;
import com.medhat.store.models.Product;
import com.medhat.store.models.User;
import com.medhat.store.repositories.AddressRepository;
import com.medhat.store.repositories.ProductRepository;
import com.medhat.store.repositories.UserRepository;
import com.medhat.store.repositories.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final AddressRepository addressRepo;
    private final ProductRepository productRepo;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityState() {

        var user = User.builder()
                .email("Medhat@s.COM")
                .password("123456")
                .name("Medhatx")
                .build();

        // TRANSIENT STATE
        if (entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }

        var address = Address.builder()
                .city("Giza")
                .street("1121 st")
                .zip("123123")
                .state("non")
                .build();

        // synchronize both sides
        address.setUser(user);
        user.getAddresses().add(address);

        // save parent only
        userRepo.save(user);

        // PERSISTENT STATE
        if (entityManager.contains(user)) {
            System.out.println("Persistent");
        } else {
            System.out.println("Transient / Detached");
        }
    }

    public void showAddress() {

        var address = addressRepo.findById(1L)
                .orElseThrow();

        System.out.println(address);
    }

    public void deleteAddress() {
        addressRepo.deleteById(1L);
    }

    @Transactional
    public void fetchUser()
    {
        var user = userRepo.findByEmail("Medhat@s.COM").orElseThrow();
        System.out.println(user.getId());

    }

    public void fetchUserByAddress()
    {
        var users = userRepo.findAllWithAddress();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });

    }
    public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Product> spec = Specification.where((Specification<Product>) null);

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }
        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        productRepo.findAll(spec).forEach(System.out::println);
    }

}