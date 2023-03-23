package edu.bu.oneshelf.auth.config;

public class AuthenticationConstants {
    public static final String SECRET = "iu649824ry89gq9wf4ubxirycnjdsf9wer903reuoiqwcjqw8yr8e6yrieuqopwueroqoic";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


    public static final String SIGN_IN_URL = "/api/v1/auth/login/";


}
