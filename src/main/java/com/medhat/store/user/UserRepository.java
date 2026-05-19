package com.medhat.store.user;


import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public void save(User user);
    User findByEmail(String email);
}
