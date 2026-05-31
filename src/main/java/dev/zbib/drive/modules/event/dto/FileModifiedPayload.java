package dev.zbib.drive.modules.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FileModifiedPayload implements EventPayload {

    @NotNull
    private UUID fileId;

    @NotBlank
    private String storageKey;

    @NotBlank
    private String mimeType;

    @NotNull
    @Positive
    private Long size;
}
