package dev.zbib.drive.modules.storage;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StorageOutput {
    private String uploadId;
    private List<String> presignedUrls;
}
