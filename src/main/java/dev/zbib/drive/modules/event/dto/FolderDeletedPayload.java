package dev.zbib.drive.modules.event.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FolderDeletedPayload implements EventPayload {

    @NotNull
    private UUID folderId;
}
