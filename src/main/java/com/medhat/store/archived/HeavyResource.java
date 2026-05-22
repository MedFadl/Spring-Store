package com.medhat.store.archived;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HeavyResource {
    HeavyResource() {
        System.out.println("HeavyResource Created");
    }
}
