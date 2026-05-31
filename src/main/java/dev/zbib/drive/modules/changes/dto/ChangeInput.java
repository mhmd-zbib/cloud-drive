package dev.zbib.drive.modules.changes.dto;

import dev.zbib.drive.common.types.EventType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public class ChangeInput {

    @NotNull
    private UUID changeId;

    @NotNull
    private UUID deviceId;

    @NotNull
    private UUID fileId;

    @NotNull
    private EventType eventType;

    @NotNull
    private Instant clientTimestamp;

    private String storageKey;

    @Valid
    private ChangePayload payload;
}
