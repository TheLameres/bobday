package thelameres.bobday.configurations;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import thelameres.bobday.configurations.properties.BobdayClientConfigurationProperties;
import thelameres.bobday.client.feign.BobdayClient;

@Configuration
@Import(FeignClientsConfiguration.class)
public class BobdayClientConfiguration {

    @Bean
    public Client client() {
        return new Client.Default(null, null);
    }

    @Bean
    public BobdayClient bobdayClient(Client client,
                                     Encoder encoder,
                                     Decoder decoder,
                                     Contract contract,
                                     BobdayClientConfigurationProperties properties) {
        return Feign.builder()
                .client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(properties.getAuthRequest())
                .target(BobdayClient.class, properties.url());
    }
}
