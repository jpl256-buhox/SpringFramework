package mx.com.cfe.cfecontigo.auth.server.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.cfe.cfecontigo.auth.server.impl.UserPrincipal;
import mx.com.cfe.cfecontigo.auth.server.models.UserModel;
import mx.com.cfe.cfecontigo.auth.server.repositories.UserRepository;
import mx.com.cfe.cfecontigo.auth.server.support.Crypt;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	private static final String ID_APP ="00410606001";
	
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
        
		Optional<UserModel> result = userRepository.findByIdUser(Long.valueOf(username));
		LOGGER.info("entro a loadUserByUsername");
	
		
		if(result.isPresent()) {
			
			Crypt miCrypt = new Crypt(ID_APP);
			LOGGER.info("password encriptado".concat(result.get().getPasswrd()));
			
			result.get().setPasswrd(miCrypt.decrypt(result.get().getPasswrd()));
			
			LOGGER.info("BD password:".concat(result.get().getPasswrd()));
			
			
			UserPrincipal usuario = new UserPrincipal(result.get());
			LOGGER.info(usuario.getAuthorities().toString());
			return  usuario;
		}
		
		throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		

	}

}
