package dev.zbib.drive.modules.upload;

import dev.zbib.drive.common.types.StorageProviderType;
import dev.zbib.drive.modules.upload.dto.UploadInput;
import dev.zbib.drive.modules.upload.storage.IStorageProvider;
import dev.zbib.drive.modules.upload.storage.StorageProviderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UploadService {


    private StorageProviderFactory storageProviderFactory;

    public void upload(UploadInput input) {
        IStorageProvider provider = storageProviderFactory.get(StorageProviderType.MINIO);



    }

    private void getChunkingStrategy(int size){

    }

}
