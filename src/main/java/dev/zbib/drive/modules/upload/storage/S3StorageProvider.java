package dev.zbib.drive.modules.upload.storage;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.infrastructure.s3.S3Properties;
import dev.zbib.drive.modules.upload.dto.StorageOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

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
    public StorageOutput createUpload(String name, long totalChunks) {

        return null;
    }


}
