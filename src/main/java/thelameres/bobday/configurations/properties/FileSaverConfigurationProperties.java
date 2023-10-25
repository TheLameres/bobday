package thelameres.bobday.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("response")
public record FileSaverConfigurationProperties(boolean save, String directory) {
}
