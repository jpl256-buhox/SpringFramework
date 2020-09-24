package mx.com.cfe.cfecontigo.auth.server.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.com.cfe.cfecontigo.auth.server.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Long>{
	
	public Optional<UserModel> findByIdUser(Long username);

}
