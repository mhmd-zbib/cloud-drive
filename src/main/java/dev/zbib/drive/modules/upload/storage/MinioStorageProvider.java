package dev.zbib.drive.modules.upload.storage;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.modules.upload.dto.StorageOutput;
import org.springframework.stereotype.Component;

@Component
public class MinioStorageProvider implements IStorageProvider {
    @Override
    public StorageProviderType getType() {
        return StorageProviderType.MINIO;
    }

    @Override
    public StorageOutput createUpload(String name, long totalChunks) {
        return null;
    }
}
