package dev.zbib.drive.modules.file;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.Visibility;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "files")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String name;

    private String extension;

    private long version;

    private String mimeType;

    private long size;

    private String storageKey;

    private String checksum;

    private boolean isFolder;

    private UUID parentId;

    private UUID ownerId;

    private Visibility visibility;

    private boolean deleted;

    private Instant lastAccessedAt;
}
