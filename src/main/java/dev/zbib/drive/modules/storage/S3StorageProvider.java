package dev.zbib.drive.modules.storage;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.infrastructure.s3.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedUploadPartRequest;
import software.amazon.awssdk.services.s3.presigner.model.UploadPartPresignRequest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class S3StorageProvider implements IStorageProvider {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;
    private final S3Properties s3Properties;

    @Override
    public StorageProviderType getType() {
        return StorageProviderType.S3;
    }

    @Override
    public StorageOutput createUpload(String filePath, long totalChunks) {
        try {
            CreateMultipartUploadResponse response = s3Client.createMultipartUpload(
                    CreateMultipartUploadRequest.builder()
                            .bucket(s3Properties.getBucket())
                            .key(filePath)
                            .build()
            );

            String uploadId = response.uploadId();

            List<String> presignedUrls = new ArrayList<>();
            for (int partNumber = 1; partNumber <= totalChunks; partNumber++) {
                UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
                        .bucket(s3Properties.getBucket())
                        .key(filePath)
                        .uploadId(uploadId)
                        .partNumber(partNumber)
                        .build();
                PresignedUploadPartRequest presigned = s3Presigner.presignUploadPart(
                        UploadPartPresignRequest.builder()
                                .uploadPartRequest(uploadPartRequest)
                                .signatureDuration(Duration.ofMinutes(s3Properties.getPresignedUrlExpiryMinutes()))
                                .build()
                );

                presignedUrls.add(presigned.url().toString());
            }

            return StorageOutput.builder()
                    .uploadId(uploadId)
                    .presignedUrls(presignedUrls)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
