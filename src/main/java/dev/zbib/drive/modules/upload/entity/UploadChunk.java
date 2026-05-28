package dev.zbib.drive.modules.upload.entity;

import dev.zbib.drive.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "upload_chunks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadChunk extends BaseEntity {

    private UUID sessionId;

    private int chunkIndex;
    private long size;
    private String storageKey;
    private String checksum;
    private boolean received;
}