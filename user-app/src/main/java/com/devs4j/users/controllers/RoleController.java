package com.devs4j.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devs4j.users.entity.Role;
import com.devs4j.users.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> getRoles(){
		
		return new ResponseEntity<>(roleService.getRoles(),HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Role> createRoles(@RequestBody Role role){
		return new ResponseEntity<>(roleService.createRole(role),HttpStatus.CREATED);
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<Role> updateRoles(@PathVariable("roleId") Integer roleId, @RequestBody Role role){
		return new ResponseEntity<>(roleService.updateRole(roleId,role),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{roleId}")
	public ResponseEntity<Role> deleteRole(@PathVariable("roleId") Integer roleId){
		roleService.deleteRole(roleId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
