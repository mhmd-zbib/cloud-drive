package dev.zbib.drive.modules.upload.storage;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.modules.upload.dto.StorageOutput;

public interface IStorageProvider {
    StorageProviderType getType();

    StorageOutput createUpload(String filePath, long totalChunks);
}
