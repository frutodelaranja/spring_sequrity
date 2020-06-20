package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority :
                authorities) {
            if (authority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
            }else if (authority.getAuthority().equals("ROLE_ADMIN")){
                isAdmin = true;
            }
        }
        if (isAdmin){
            httpServletResponse.sendRedirect("/hello");
        }else if(isUser){
            httpServletResponse.sendRedirect("/user");
        }else {
            httpServletResponse.sendRedirect("/login");
        }
    }
}