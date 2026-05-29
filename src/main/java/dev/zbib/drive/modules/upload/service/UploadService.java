package dev.zbib.drive.modules.upload.service;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.common.types.UploadStatus;
import dev.zbib.drive.modules.upload.IUploadRepository;
import dev.zbib.drive.modules.upload.dto.ChunkingOutput;
import dev.zbib.drive.modules.upload.dto.InitUploadInput;
import dev.zbib.drive.modules.upload.dto.InitUploadOutput;
import dev.zbib.drive.modules.upload.dto.StorageOutput;
import dev.zbib.drive.modules.upload.entity.UploadSession;
import dev.zbib.drive.modules.upload.storage.IStorageProvider;
import dev.zbib.drive.modules.upload.storage.StorageProviderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadService {

    private StorageProviderFactory storageProviderFactory;
    private ChunkingService chunkingService;
    private IUploadRepository uploadRepository;

    public InitUploadOutput initUpload(InitUploadInput input) {

        ChunkingOutput chunkingOutput = chunkingService.getChunkingStrategy(input.getTotalSize());
        IStorageProvider provider = storageProviderFactory.get(StorageProviderType.S3);
        StorageOutput storageOutput = provider.createUpload(input.getFileName(), chunkingOutput.getTotalChunks());
        String fileExtension = getFileExtension(input.getFileName());

        UploadSession uploadSession = UploadSession.builder()
                .totalChunks(chunkingOutput.getTotalChunks())
                .extension(fileExtension)
                .uploadId(storageOutput.getUploadId())
                .uploadedChunks(0)
                .mimeType(input.getMimeType())
                .fileName(input.getFileName())
                .checksum(input.getChecksum())
                .status(UploadStatus.PENDING)
                .build();

        uploadRepository.save(uploadSession);

        return InitUploadOutput.builder()
                .chunkSize(chunkingOutput.getChunkSize())
                .totalChunks(chunkingOutput.getTotalChunks())
                .uploadId(storageOutput.getUploadId())
                .presignedUrls(storageOutput.getPresignedUrls())
                .build();

    }

    private String getFileExtension(String fileName) {
        int lastDot = fileName.lastIndexOf(".");
        if (lastDot == -1 || lastDot == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(lastDot + 1).toLowerCase();
    }

}
