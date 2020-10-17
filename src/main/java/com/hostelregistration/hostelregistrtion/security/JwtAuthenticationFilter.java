package com.hostelregistration.hostelregistrtion.security;

import com.hostelregistration.hostelregistrtion.model.Student;
import com.hostelregistration.hostelregistrtion.model.Warden;
import com.hostelregistration.hostelregistrtion.services.CustomStudentDetailService;
import com.hostelregistration.hostelregistrtion.services.CustomWardenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static com.hostelregistration.hostelregistrtion.security.SecurityConstants.HEADER_STRING;
import static com.hostelregistration.hostelregistrtion.security.SecurityConstants.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomStudentDetailService customStudentDetailService;

    @Autowired
    private CustomWardenDetailService customWardenDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJWTFromRequest(request);
            if (StringUtils.hasText(jwt)&& tokenProvider.validateToken(jwt)) {
                String studentid = String.valueOf(tokenProvider.getStudentidFromJwt(jwt));
                Student studentDetails = customStudentDetailService.loadUserByStudentid(studentid);

               // String wardenid = String.valueOf(tokenProvider.getWardenidFromJwt(jwt));
                //Warden wardenDetails = customWardenDetailService.loadUserByWardenid(wardenid);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        studentDetails, null, Collections.emptyList()
                );

                //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                       // wardenDetails, null, Collections.emptyList()
               // );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }catch (Exception ex){
           logger.error("Could not set a user authentication in security context ",ex);
        }

        filterChain.doFilter(request,response);
    }
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER_STRING);
        if (StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7,bearerToken.length());
        }
        return bearerToken;
    }
}
