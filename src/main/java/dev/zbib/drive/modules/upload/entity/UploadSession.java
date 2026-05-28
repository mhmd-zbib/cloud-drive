package dev.zbib.drive.modules.upload.entity;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.UploadStatus;
import dev.zbib.drive.modules.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "upload_sessions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadSession extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    private String fileName;
    private String extension;
    private String mimeType;
    private long totalSize;
    private int totalChunks;
    private int uploadedChunks;
    private String checksum;
    private UUID parentId;

    @Enumerated(EnumType.STRING)
    private UploadStatus status;

    private Instant expiresAt;
}