package dev.zbib.drive.modules.upload.storage;

import dev.zbib.drive.common.types.StorageProviderType;

public interface IStorageProvider {
    StorageProviderType getType();
    String createFolder(String name);
}
