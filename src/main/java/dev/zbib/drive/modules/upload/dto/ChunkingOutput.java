package dev.zbib.drive.modules.upload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ChunkingOutput {
    int totalChunks;
    long chunkSize;
}
