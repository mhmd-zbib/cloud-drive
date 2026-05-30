package dev.zbib.drive.modules.upload;

import dev.zbib.drive.common.entity.BaseEntity;
import dev.zbib.drive.common.types.UploadStatus;
import dev.zbib.drive.modules.file.File;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "upload_sessions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadSession extends BaseEntity {
    private String fileName;
    private String extension;
    private String mimeType;
    private long totalSize;
    private int totalChunks;
    private int uploadedChunks;
    private String checksum;
    private String uploadId;

    @OneToOne
    @JoinColumn(name = "file_id")
    private File file;

    @Enumerated(EnumType.STRING)
    private UploadStatus status;

    private Instant expiresAt;
}