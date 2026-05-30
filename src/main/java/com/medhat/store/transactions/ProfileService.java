package com.medhat.store.transactions;

import com.medhat.store.models.Profile;
import com.medhat.store.repositories.ProfileRepository;
import com.medhat.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ProfileService {
    private final UserRepository ur;
    private final ProfileRepository pr;

    @Transactional
    public void addProfileToUser()
    {

        ur.findById(1L).ifPresent(u -> {
            Profile profile = Profile.builder().
                    loyaltyPoints(20).phoneNumber("011").dateOfBirth(LocalDate.parse("2000-12-11"))
                    .build();
            profile.setUser(u);
            u.setProfile(profile);
            pr.save(profile);
            ur.save(u);
        });



    }

    @Transactional
    public void fetchProfile()
    {
        var users = ur.findByLoyaltyPointsGreaterThan(10);
        users.forEach(userSummary -> {
            System.out.println(userSummary.getId());
            System.out.println(userSummary.getEmail());
        });
    }
}
