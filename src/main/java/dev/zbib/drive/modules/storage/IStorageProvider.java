package dev.zbib.drive.modules.storage;

import dev.zbib.drive.common.types.StorageProviderType;

public interface IStorageProvider {
    StorageProviderType getType();

    StorageOutput createUpload(String filePath, long totalChunks);
}
