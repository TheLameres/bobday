package thelameres.bobday.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import thelameres.bobday.configurations.properties.FileSaverConfigurationProperties;
import thelameres.bobday.services.FileSaverService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Service
@Slf4j
public class FileSaverServiceImpl implements FileSaverService {
    public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SS");
    private final ObjectMapper objectMapper;
    private final FileSaverConfigurationProperties properties;

    public FileSaverServiceImpl(ObjectMapper objectMapper,
                                FileSaverConfigurationProperties properties) {
        this.objectMapper = objectMapper;
        this.properties = properties;
    }

    @Override
    public void saveAsJsonFile(Object object) {
        LocalDateTime now = LocalDateTime.now();
        String time = now.atZone(ZoneId.systemDefault()).format(PATTERN);
        String fileName = "json_response_" + time + ".json";
        try {
            String jsonResponse = objectMapper.writeValueAsString(object);
            Path path = Paths.get(properties.directory(), fileName);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, Collections.singletonList(jsonResponse));
        } catch (Exception e) {
            log.error("Can't write json file: " + fileName, e);
        }

    }
}
