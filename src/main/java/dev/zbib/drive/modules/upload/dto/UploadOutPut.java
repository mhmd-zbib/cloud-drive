package dev.zbib.drive.modules.upload.dto;

import dev.zbib.drive.common.types.UploadStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
public class UploadOutPut {

    private int chunkSize;
    private int maxCocurrent;
    private String uploadUrl;
    private String completionEndpoint;

}
