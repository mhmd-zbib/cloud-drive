package dev.zbib.drive.common.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    private UUID id;

    private boolean deleted;
    private Instant deletedAt;

    private Instant createdAt;

    private Instant updatedAt;
}
