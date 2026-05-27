package com.medhat.store.transactions;


import com.medhat.store.models.User;
import com.medhat.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepo;
    private EntityManager entityManager;

  /*   @Transactional
   public void showEntityState() {
        var user = User.builder()
                .email("M@Mx.COM")
                .password("123456")
                .name("Medhatx")
                .build();
        if (entityManager.contains(user))
        {
            System.out.println("Persistent");
        }
        else
        {
            System.out.println("Transit / Deattached");
        }
        userRepo.save(user);
        if(entityManager.contains(user))
        {
            System.out.println("Persistent");
        }
        else
        {
            System.out.println("Transit / Deattached");
        }
        userRepo.findById(1L).orElseThrow();

    }*/



}
