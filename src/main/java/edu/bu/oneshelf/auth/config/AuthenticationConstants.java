package edu.bu.oneshelf.auth.config;

public class AuthenticationConstants {
    public static final String SECRET = "iu649824ry89gq9wf4ubxirycnjdsf9wer903reuoiqwcjqw8yr8e6yrieuqopwueroqoic";
    public static final long ACCESS_EXPIRATION_TIME = 1800000; // 30 minutes
    public static final long REFRESH_EXPIRATION_TIME = 604800000; // 1 week

    public static final String REFRESH_ISSUER = "ONESHELF_REFRESH";
    public static final String ACCESS_ISSUER = "ONESHELF_ACCESS";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


    public static final String SIGN_IN_URL = "/api/v1/auth/login/";
    public static final String REFRESH_URL = "/api/v1/auth/refresh/";


}
