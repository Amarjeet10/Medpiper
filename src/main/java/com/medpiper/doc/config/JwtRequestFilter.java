package com.medpiper.doc.config;

import com.medpiper.doc.domain.Registration.RegistrationInfo;
import com.medpiper.doc.service.Impl.MyUserDetails;
import com.medpiper.doc.service.RegistrationService;
import com.medpiper.doc.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

import static org.springframework.security.config.Elements.JWT;

@Service
public class JwtRequestFilter extends BasicAuthenticationFilter
{
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


   public JwtRequestFilter(AuthenticationManager authenticationManager, RegistrationService registrationService) {
        super(authenticationManager);
        this.registrationService = registrationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        //If header does not contain bearer or is NULL delegate to spring impl and exit
        if(authorizationHeader == null && !authorizationHeader.startsWith("Bearer "))
        {
            chain.doFilter(request,response);
            return;
        }
        //If header is present, try grab user principal from database and perform authorization
        Authentication authentication=getUserNamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Continue Filter Exceution
        chain.doFilter(request,response);

    }
    private Authentication getUserNamePasswordAuthentication(HttpServletRequest request)
    {
        String token = request.getHeader("Authorization");
        if(token!=null)
        {
            //parse the token and validate it
            String userName= jwtTokenUtil.getUsernameFromToken(token);
            System.out.println("Username in Request Filter................"+userName);

            //Search in the DB if we find the user by token subject (username)
            //If so, then grab user details and create spring auth token using username, pass, authorities/roles

            if(userName!=null)
            {
                RegistrationInfo user=registrationService.findUserByEmail(userName);
                MyUserDetails myUserDetails=new MyUserDetails(user);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, myUserDetails.getAuthorities());
                return auth;
            }
            return null;
        }
        return null;
    }


}



