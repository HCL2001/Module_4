package com.example.shipping_by_ship.security;

//import com.nimbusds.jose.JWSAlgorithm;
//import com.nimbusds.jose.JWSHeader;
//import com.nimbusds.jose.JWSSigner;
//import com.nimbusds.jose.JWSVerifier;
//import com.nimbusds.jose.crypto.MACSigner;
//import com.nimbusds.jose.crypto.MACVerifier;
//import com.nimbusds.jwt.JWTClaimsSet;
//import com.nimbusds.jwt.SignedJWT;

import java.util.Date;

public class Security {

//    public static final String USERNAME = "username";
//
//    public static final int EXPIRE_TIME = 86400000;
//
//    public static final String SECRET_KEY = "Long";
//
//
//    private static Date generateExpirationDate() {
//        return new Date(System.currentTimeMillis() + EXPIRE_TIME);
//    }
//
//    private static Date getExpirationDateFromToken(String token) {
//        Date expiration = null;
//        JWTClaimsSet claims = getClaimsFromToken(token);
//        expiration = claims.getExpirationTime();
//        return expiration;
//    }
//
//    private static JWTClaimsSet getClaimsFromToken(String token) {
//        JWTClaimsSet claims = null;
//        try {
//            SignedJWT signedJWT = SignedJWT.parse(token);
//            JWSVerifier verifier = new MACVerifier(generateShareSecret());
//            if (signedJWT.verify(verifier)) {
//                claims = signedJWT.getJWTClaimsSet();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return claims;
//    }
//
//    private static byte[] generateShareSecret() {
//        // Generate 256-bit (32-byte) shared secret
//        byte[] sharedSecret = new byte[32];
//        sharedSecret = SECRET_KEY.getBytes();
//        return sharedSecret;
//    }
//
//
//    // OK
//    private static Boolean isTokenExpired(String token) {
//        Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(new Date());
//    }
//
//
//    public static String generateTokenLogin(String username) {
//        String token = null;
//        try {
//            // Create HMAC signer
//            JWSSigner signer = new MACSigner(generateShareSecret());
//            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
//            builder.claim(USERNAME, username);
//            builder.expirationTime(generateExpirationDate());
//            JWTClaimsSet claimsSet = builder.build();
//            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
//            // Apply the HMAC protection
//            signedJWT.sign(signer);
//            // Serialize to compact form, produces something like
//            // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
//            token = signedJWT.serialize();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(token);
//        return token;
//    }
}
