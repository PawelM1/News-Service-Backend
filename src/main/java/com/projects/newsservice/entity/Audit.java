package com.projects.newsservice.entity;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.time.Instant;

@Embeddable
class Audit {
    private Instant createdOn;

    @PrePersist
    void prePersist() {
        createdOn = Instant.now();
    }
}
