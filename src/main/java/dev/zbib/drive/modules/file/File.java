package dev.zbib.drive.modules.file;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.Visibility;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "files", indexes = {
        @Index(name = "idx_files_parent_id", columnList = "parentId"),
        @Index(name = "idx_files_owner_id", columnList = "ownerId"),
        @Index(name = "idx_files_checksum", columnList = "checksum")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;
    private String extension;
    private String mimeType;
    private long size;
    private long version;
    private String storageKey;
    private String checksum;
    private boolean isFolder;
    private UUID parentId;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    private Instant lastAccessedAt;
}