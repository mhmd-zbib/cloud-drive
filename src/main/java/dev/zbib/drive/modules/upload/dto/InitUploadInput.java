package dev.zbib.drive.modules.upload.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class InitUploadInput {

    @NotBlank
    private String fileName;

    @NotBlank
    private String mimeType;

    @Positive
    private long totalSize;

    @NotBlank
    private String checksum;
}
