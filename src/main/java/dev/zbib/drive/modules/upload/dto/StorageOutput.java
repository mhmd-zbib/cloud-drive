package dev.zbib.drive.modules.upload.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class StorageOutput {
    private String uploadId;
    private List<String> presignedUrls;
}
