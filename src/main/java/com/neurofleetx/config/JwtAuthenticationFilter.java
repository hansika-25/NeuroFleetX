/* 
package com.neurofleetx.config;

import com.neurofleetx.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException{

        //String header = request.getHeader("Authorization");

       // if (header != null && header.startsWith("Bearer ")) {
          //  String token = header.substring(7);
          //  String userId = jwtUtil.extractUserId(token);

          //  if (userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //    UsernamePasswordAuthenticationToken auth =
                  //      new UsernamePasswordAuthenticationToken(
                 //               userId,
                  //              null,
                  //              Collections.emptyList()
                  //      );
            //    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
           //     SecurityContextHolder.getContext().setAuthentication(auth);
           // }
      //  }
      filterChain.doFilter(request, response);
       

        filterChain.doFilter(request, response);
    }
}
*/
    
