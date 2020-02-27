package com.fbm.finbrokermgmt.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fbm.finbrokermgmt.constants.RoleAuthMap;
import com.fbm.finbrokermgmt.dao.CredentialsRepo;
import com.fbm.finbrokermgmt.entity.CredentialsDetails;

public class H2AuthProvider implements AuthenticationProvider {
	@Autowired
	CredentialsRepo repo;
	
	List<CredentialsDetails> credentials = repo.findAll();
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		final List<? extends GrantedAuthority> userAuthList = getAuthListIfAuthenticated(username, password);
		return new UsernamePasswordAuthenticationToken(username, null, userAuthList);
		
	}

	private List<? extends GrantedAuthority> getAuthListIfAuthenticated(String username, String password) {
		for(CredentialsDetails credential : credentials) {
			if(credential.getUserName().equals(username) && credential.getPassword().equals(password)) {
				return AuthorityUtils
						.commaSeparatedStringToAuthorityList
							(RoleAuthMap.getAuthForRole(credential.getRole()));
			}
		}
		throw new BadCredentialsException("Bad credentials.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
