package dev.zbib.drive.modules.changes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FolderDeletedPayload implements ChangePayload {

    @NotNull
    private UUID folderId;
}
