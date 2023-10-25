package thelameres.bobday.configurations;

import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import thelameres.bobday.client.feign.BobdayClient;
import thelameres.bobday.configurations.properties.BobdayClientConfigurationProperties;

@Configuration
@Import(FeignClientsConfiguration.class)
public class BobdayClientConfiguration {

    @Bean
    public Client client() {
        return new Client.Default(null, null);
    }

    @Bean
    public Target<BobdayClient> bobdayClientTarget(BobdayClientConfigurationProperties properties) {
        return new Target.HardCodedTarget<>(BobdayClient.class, "bobday", properties.url());
    }

    @Bean
    public BobdayClient bobdayClient(Client client,
                                     Encoder encoder,
                                     Decoder decoder,
                                     Contract contract,
                                     Target<BobdayClient> bobdayClientTarget,
                                     BobdayClientConfigurationProperties properties) {
        return Feign.builder()
                .client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(properties.getAuthRequest())
                .target(bobdayClientTarget);
    }
}
