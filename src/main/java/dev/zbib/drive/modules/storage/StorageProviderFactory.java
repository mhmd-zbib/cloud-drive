package dev.zbib.drive.modules.storage;

import dev.zbib.drive.common.types.StorageProviderType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StorageProviderFactory {

    private final Map<StorageProviderType, IStorageProvider> registry;

    public StorageProviderFactory(List<IStorageProvider> providers) {
        this.registry = providers.stream().collect(Collectors.toMap(
                IStorageProvider::getType,
                Function.identity(),
                (a, b) -> {
                    throw new IllegalStateException("Duplicate StorageProvider for type: " + a.getType());
                },
                () -> new EnumMap<>(StorageProviderType.class)
        ));
    }

    public IStorageProvider get(StorageProviderType type) {
        return Optional.ofNullable(registry.get(type)).orElseThrow(
                () -> new IllegalArgumentException(
                        "No StorageProvider registered for: " + type)
        );
    }
}
