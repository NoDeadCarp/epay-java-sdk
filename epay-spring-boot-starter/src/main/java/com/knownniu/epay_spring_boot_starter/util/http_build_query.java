package com.knownniu.epay_spring_boot_starter.util;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class http_build_query {
    public static String encode(Map<String, String> params) {
        String query = params.entrySet().stream()
            .map(e -> e.getKey() + "=" + urlEncode(e.getValue()))
            .collect(Collectors.joining("&"));
        return query;
    }

    private static String urlEncode(String value) {
    try {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}
