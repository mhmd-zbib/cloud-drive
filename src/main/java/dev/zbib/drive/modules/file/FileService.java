package dev.zbib.drive.modules.file;

import dev.zbib.drive.modules.file.dto.FileOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private IFileRepository fileRepository;

    public File create() {
        return null;
    }

    public File getById(UUID id) {
        return null;
    }

    public File getByIdAndOwnerId(UUID id, UUID ownerId) {
        return null;
    }

    public List<File> getAllByIdAndOwnerId(UUID ownerId, List<UUID> id ) {
        return null;
    }
}
