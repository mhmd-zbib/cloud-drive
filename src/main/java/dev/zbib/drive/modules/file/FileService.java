package dev.zbib.drive.modules.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private IFileRepository fileRepository;

    public File create() {
        return null;
    }

}
