package dev.zbib.drive.modules.changes;

import dev.zbib.drive.modules.changes.dto.ChangeInput;
import dev.zbib.drive.modules.file.File;
import dev.zbib.drive.modules.file.FileService;
import dev.zbib.drive.modules.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChangeService {

    private final IChangeRepository changeRepository;
    private final FileService fileService;

    @Transactional
    public void createBatch(User user, List<ChangeInput> inputs) {
        filterDuplicates(inputs);
        Map<UUID, File> fileMap = getFileMap(user, inputs);
        List<Change> changes = buildChanges(user, inputs, fileMap);
        changeRepository.saveAll(changes);
    }

    private void filterDuplicates(List<ChangeInput> inputs) {
        Set<UUID> existingChangeIds = changeRepository.findExistingChangeIds(
                inputs.stream().map(ChangeInput::getChangeId).toList()
        );
        inputs.removeIf(input -> existingChangeIds.contains(input.getChangeId()));
    }

    private Map<UUID, File> getFileMap(User user, List<ChangeInput> inputs) {
        List<UUID> fileIds = inputs.stream().map(ChangeInput::getFileId).toList();
        List<File> files = fileService.getAllByIdAndOwnerId(user.getId(), fileIds);
        return files.stream().collect(Collectors.toMap(File::getId, f -> f));
    }

    private List<Change> buildChanges(User user, List<ChangeInput> inputs, Map<UUID, File> fileMap) {
        return inputs.stream()
                .filter(input -> fileMap.containsKey(input.getFileId()))
                .map(input -> Change.builder()
                        .changeId(input.getChangeId())
                        .file(fileMap.get(input.getFileId()))
                        .user(user)
                        .deviceId(input.getDeviceId())
                        .storageKey(input.getStorageKey())
                        .eventType(input.getEventType())
                        .clientTimestamp(input.getClientTimestamp())
                        .build())
                .toList();
    }
}
