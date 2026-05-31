package dev.zbib.drive.modules.changes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FileRenamedPayload implements ChangePayload {

    @NotNull
    private UUID fileId;

    @NotBlank
    private String oldName;

    @NotBlank
    private String newName;
}
