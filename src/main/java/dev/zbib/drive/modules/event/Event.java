package dev.zbib.drive.modules.event;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.EventType;
import dev.zbib.drive.modules.file.File;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "events", indexes = {
        @Index(name = "idx_events_event_id", columnList = "eventId", unique = true),
        @Index(name = "idx_events_file_id", columnList = "file_id"),
        @Index(name = "idx_events_device_id", columnList = "deviceId"),
        @Index(name = "idx_events_created_at", columnList = "createdAt")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event extends BaseEntity {

    @Column(nullable = false, unique = true)
    private UUID eventId;

    @Column(nullable = false)
    private UUID deviceId;

    private String storageKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private Instant clientTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private File file;
}