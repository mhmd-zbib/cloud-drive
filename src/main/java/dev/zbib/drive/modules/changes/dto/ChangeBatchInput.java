package dev.zbib.drive.modules.changes.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ChangeBatchInput {

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private List<@Valid ChangeInput> eventInputs;

}
