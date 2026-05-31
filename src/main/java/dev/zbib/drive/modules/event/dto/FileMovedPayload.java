package dev.zbib.drive.modules.event.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class FileMovedPayload implements EventPayload {

    @NotNull
    private UUID fileId;

    @NotNull
    private UUID oldParentId;

    @NotNull
    private UUID newParentId;
}
