package dev.zbib.drive.modules.changes;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.EventType;
import dev.zbib.drive.modules.file.File;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "changes", indexes = {
        @Index(name = "idx_changes_change_id", columnList = "changeId", unique = true),
        @Index(name = "idx_changes_file_id", columnList = "file_id"),
        @Index(name = "idx_changes_device_id", columnList = "deviceId"),
        @Index(name = "idx_changes_user_id", columnList = "user_id"),
        @Index(name = "idx_changes_created_at", columnList = "createdAt")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Change extends BaseEntity {

    @Column(nullable = false, unique = true)
    private UUID changeId;

    @Column(nullable = false)
    private UUID deviceId;

    private String storageKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType eventType;

    @Column(nullable = false)
    private Instant clientTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", nullable = false)
    private File file;
}
