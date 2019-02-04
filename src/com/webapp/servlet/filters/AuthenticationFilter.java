package com.webapp.servlet.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
		// tutti gli url a cui devo fare una certa validazione gli altri url non vengono sottoposti a validazione
	 private static final String[] loginRequiredURLs = {
	            "/users", "/customers", "/menu"
	    };
	 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		// .... faccio il casting di request a httpservletrequest. perchè sono ServletRequest e non httpservletrequest...
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		try {
			HttpSession session = httpServletRequest.getSession(false);
			// questo filtro  non fa altro che prendersi il path e chiede ci sono url tra quelli della costante dell'array a riga 15
			if (isLoginRequired(httpServletRequest) && (session == null || session.getAttribute("loggedUser") == null)) {
				httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login/login.jsp").forward(httpServletRequest,
						httpServletResponse);
			} else {
				chain.doFilter(request, response);
			}

		} catch (Exception e) {
			System.err.println("Error");
		}
	}

	@Override
	public void destroy() {
		System.out.println("Destroy filter: {}");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init filter: {}");
	}
	
	private boolean isLoginRequired(HttpServletRequest httpRequest) {
        String requestURL = httpRequest.getRequestURL().toString();
 
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
        return false;
    }
}
