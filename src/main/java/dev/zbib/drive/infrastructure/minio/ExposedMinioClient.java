package dev.zbib.drive.infrastructure.minio;

import io.minio.MinioClient;

public class ExposedMinioClient extends MinioClient {
    protected ExposedMinioClient(MinioClient client) {
        super(client);
    }
}
