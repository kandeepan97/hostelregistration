package com.hostelregistration.hostelregistrtion.security;

import com.hostelregistration.hostelregistrtion.model.Student;
import com.hostelregistration.hostelregistrtion.model.Warden;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.hostelregistration.hostelregistrtion.security.SecurityConstants.EXPIRATION_TIME;
import static com.hostelregistration.hostelregistrtion.security.SecurityConstants.SECRET;

@Component
public class JwtTokenProvider {

    //Generate the token

    public String generateTokenStudent(Authentication authentication) {
        Student student = (Student) authentication.getPrincipal();

        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String studentid = student.getStudentid();

        Map<String, Object> claims = new HashMap<>();
        claims.put("studentid", student.getStudentid());
        claims.put("email", student.getEmail());
        claims.put("firstName", student.getFirstName());
        claims.put("lastName", student.getLastName());


        return Jwts.builder()
                .setSubject(studentid)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    public String generateTokenWarden(Authentication authentication) {
        Warden warden = (Warden) authentication.getPrincipal();

        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String wardenid = warden.getwardenid();

        Map<String, Object> claims = new HashMap<>();
        claims.put("wardenid", warden.getwardenid());
        claims.put("email", warden.getEmail());
        claims.put("firstName", warden.getFirstName());
        claims.put("lastName", warden.getLastName());


        return Jwts.builder()
                .setSubject(wardenid)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    //Validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            System.out.println("Invalid Jwt Signature");
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid Jwt Token");
        } catch (ExpiredJwtException ex) {
            System.out.println("Expired Jwt Token");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Unsupported Jwt Token");
        } catch (IllegalArgumentException ex) {
            System.out.println("Jwt Claims String is empty");
        }
        return false;
    }

    //Get user id from token

    public String getStudentidFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String studentid = (String) claims.get("studentid");

        return studentid;
    }


    public String getWardenidFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String wardenid = (String) claims.get("wardenid");

        return wardenid;
    }
}
