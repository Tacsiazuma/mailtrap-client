package hu.letscode.mailtrap;

import java.util.Objects;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class OAuth2RequestInterceptor implements RequestInterceptor {
    private final String accessToken;

    /**
     * Creates an interceptor that authenticates all requests with the specified accessToken
     *
     * @param accessToken the OAuth accessToken to use for authentication
     */
    public OAuth2RequestInterceptor(String accessToken) {
        Objects.requireNonNull(accessToken, "accessToken");
        this.accessToken = "Bearer " + accessToken;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", accessToken);
    }
}
