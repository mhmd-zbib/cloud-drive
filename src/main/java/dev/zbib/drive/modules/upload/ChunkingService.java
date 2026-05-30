package dev.zbib.drive.modules.upload;

import dev.zbib.drive.modules.upload.dto.ChunkingOutput;
import org.springframework.stereotype.Component;

@Component
public class ChunkingService {

    private static final long MIN_CHUNK_SIZE = 5 * 1024 * 1024;   // 5 MB
    private static final long MAX_CHUNK_SIZE = 100 * 1024 * 1024; // 100 MB
    private static final long SMALL_FILE_THRESHOLD = 100 * 1024 * 1024; // 100 MB

    public ChunkingOutput getChunkingStrategy(long size) {
        if (size <= SMALL_FILE_THRESHOLD) {
            return new ChunkingOutput(1, size);
        }

        long targetChunkSize = size / 100;
        long chunkSize = Math.max(MIN_CHUNK_SIZE, Math.min(targetChunkSize, MAX_CHUNK_SIZE));

        int totalChunks = (int) Math.ceil((double) size / chunkSize);

        return ChunkingOutput.builder()
                .totalChunks(totalChunks)
                .chunkSize(chunkSize)
                .build();
    }
}
