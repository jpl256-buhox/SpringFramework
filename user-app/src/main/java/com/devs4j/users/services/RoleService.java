package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entity.Role;
import com.devs4j.users.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}

	public Role createRole(Role role) {
//		if(this.getRoles().stream().filter(r->r.getName().equals(role.getName())).anyMatch(predicate)) {
//		 return new Exception();
//		}
		return roleRepository.save(role);
	}

	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = roleRepository.findById(roleId);
		if(result.isPresent()) {
			return roleRepository.save(role);
			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id $id doesn´t exists", roleId));
		}
			
	}
	
	public void deleteRole(Integer roleId) {
		Optional<Role> result= roleRepository.findById(roleId);
		if(result.isPresent()) {
			roleRepository.delete(result.get());			
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Role id $id doesn´t exists", roleId));
		}
	}

}
