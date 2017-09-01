package br.edu.ifrs.canoas.lds.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.webapp.domain.Role;
import br.edu.ifrs.canoas.lds.webapp.domain.User;
import br.edu.ifrs.canoas.lds.webapp.repository.RoleRepository;
import br.edu.ifrs.canoas.lds.webapp.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;		
	}
	
	public User save(User user) {
		User fetchedUser = this.getOne(user);
		fetchedUser.setName(user.getName());
		fetchedUser.setEmail(user.getEmail());
		fetchedUser.setSkill(user.getSkill());
		fetchedUser.setExperience(user.getExperience());
		return userRepository.save(fetchedUser);
	}

	public User getOne(User user) {
		return userRepository.findById(user.getId()).get();
	}
	
	public Iterable<User> list(){
		return userRepository.findAll();
	}
	
	public void delete(Long id){
		userRepository.deleteById(id);
	}
	
	public User getId(Long id){
		return userRepository.getOne(id);
	}

	public List<Role> getRoles() {
		
		return roleRepository.findAll();
	}

}
