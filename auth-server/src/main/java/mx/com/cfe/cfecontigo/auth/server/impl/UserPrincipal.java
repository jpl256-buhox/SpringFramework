package mx.com.cfe.cfecontigo.auth.server.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import mx.com.cfe.cfecontigo.auth.server.models.UserModel;


public class UserPrincipal implements UserDetails{

	private static final long serialVersionUID = 1L;	
	private final UserModel user;
	 

	public UserPrincipal(UserModel user) {
		this.user = user;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPasswrd();
	}

	@Override
	public String getUsername() {
		return String.valueOf(user.getIdUser());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public UserModel getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "UserPrincipal [user=" + user + "]";
	}
	
	
	
	
}
