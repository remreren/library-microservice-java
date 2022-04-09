package online.library.utility.security;

@FunctionalInterface
public interface Function2<TokenContent, String, Response> {
    Response apply(TokenContent tokenContent, String token);
}
