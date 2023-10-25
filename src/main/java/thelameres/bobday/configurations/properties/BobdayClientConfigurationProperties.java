package thelameres.bobday.configurations.properties;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import thelameres.bobday.client.interceptors.Base64AuthorizationRequestInterceptor;

@ConfigurationProperties("bobday")
public record BobdayClientConfigurationProperties(String url,
                                                  String username,
                                                  char[] password,
                                                  boolean saveResponse,
                                                  String directoryToSave) {
    public RequestInterceptor getAuthRequest() {
        return new Base64AuthorizationRequestInterceptor(username, password);
    }

}
