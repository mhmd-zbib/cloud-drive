package dev.zbib.drive.modules.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FolderRenamedPayload implements EventPayload {

    @NotNull
    private UUID folderId;

    @NotBlank
    private String oldName;

    @NotBlank
    private String newName;
}
