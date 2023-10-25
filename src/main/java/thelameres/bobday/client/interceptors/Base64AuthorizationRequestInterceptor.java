package thelameres.bobday.client.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.util.Assert.notNull;

public class Base64AuthorizationRequestInterceptor implements RequestInterceptor {

    private final String headerValue;

    public Base64AuthorizationRequestInterceptor(String username, char[] password) {
        this(username, password, StandardCharsets.ISO_8859_1);
    }

    public Base64AuthorizationRequestInterceptor(String username, char[] password, Charset charset) {
        notNull(username, "Username must not null");
        notNull(password, "Password must not null");
        CharBuffer usernameAndPassword = CharBuffer.wrap(new StringBuffer()
                .append(username)
                .append(":")
                .append(password)
        );
        this.headerValue = "Basic " +
                Base64.getEncoder().encodeToString(charset.encode(usernameAndPassword).array());
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", headerValue);
    }
}
