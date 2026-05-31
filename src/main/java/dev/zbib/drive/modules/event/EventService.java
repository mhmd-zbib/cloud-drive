package dev.zbib.drive.modules.event;

import dev.zbib.drive.modules.event.dto.EventInput;
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
public class EventService {
    private final IEventRepository eventRepository;
    private final FileService fileService;

    @Transactional
    public void createBatch(User user, List<EventInput> inputs) {
//        filterDuplicates(inputs);
//        Map<UUID, File> fileMap = getFileMap(user, inputs);
//        List<Event> events = buildEvents(user, inputs, fileMap);
//        eventRepository.saveAll(events);
    }
//
//    private void filterDuplicates(List<EventInput> inputs) {
//        Set<UUID> existingEventIds = eventRepository.findExistingEventIds(
//                inputs.stream().map(EventInput::getEventId).toList()
//        );
//
//        inputs.removeIf(input -> existingEventIds.contains(input.getEventId()));
//    }
//
//    private Map<UUID, File> getFileMap(User user, List<EventInput> inputs) {
//        List<UUID> fileIds = inputs.stream().map(EventInput::getFileId).toList();
//        List<File> files = fileService.getAllByIdAndOwnerId(user.getId(), fileIds);
//        return files.stream().collect(Collectors.toMap(File::getId, f -> f));
//    }
//
//    private List<Event> buildEvents(User user, List<EventInput> inputs, Map<UUID, File> fileMap) {
//        return inputs.stream()
//                .filter(input -> fileMap.containsKey(input.getFileId()))
//                .map(input -> Event.builder()
//                        .file(fileMap.get(input.getFileId()))
//                        .user(user)
//                        .eventId(input.getEventId())
//                        .deviceId(input.getDeviceId())
//                        .storageKey(input.getStorageKey())
//                        .eventType(input.getEventType())
//                        .clientTimestamp(input.getTimestamp())
//                        .build())
//                .toList();
//    }
}
