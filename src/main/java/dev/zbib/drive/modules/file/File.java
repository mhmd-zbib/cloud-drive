package dev.zbib.drive.modules.file;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.Visibility;
import dev.zbib.drive.modules.folder.Folder;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "files", indexes = {
        @Index(name = "idx_files_parent_id", columnList = "parent_id"),
        @Index(name = "idx_files_owner_id", columnList = "owner_id"),
        @Index(name = "idx_files_checksum", columnList = "checksum")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File extends BaseEntity {

    private String name;
    private String extension;
    private String mimeType;
    private long size;
    private long version;
    private String storageKey;
    private String checksum;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Folder parent;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private Instant lastAccessedAt;
}
