package hu.letscode.mailtrap;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ClientFactory {

    public MailTrap create(String accessToken)
    {
        MailTrap client = Feign.builder()
            .decoder(new JacksonDecoder())
            .encoder(new JacksonEncoder())
            .requestInterceptor(new OAuth2RequestInterceptor(accessToken))
            .target(MailTrap.class, "https://mailtrap.io");
        return client;
    }
}

