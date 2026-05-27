package com.medhat.store.repositories;

import org.springframework.data.repository.CrudRepository;
import com.medhat.store.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
