package dev.zbib.drive.modules.upload.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InitUploadOutput {

    private String uploadId;
    private long chunkSize;
    private int totalChunks;
    private List<String> presignedUrls;

}
