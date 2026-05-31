package dev.zbib.drive.modules.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FileCreatedPayload implements EventPayload {

    @NotNull
    private UUID fileId;

    @NotNull
    private UUID parentId;

    @NotBlank
    private String name;

    @NotBlank
    private String storageKey;

    @NotBlank
    private String mimeType;

    @NotNull
    @Positive
    private Long size;
}
