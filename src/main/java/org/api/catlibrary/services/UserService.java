package org.api.catlibrary.services;

import org.api.catlibrary.data.UserDocument;
import org.api.catlibrary.domain.User;
import org.api.catlibrary.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public boolean saveUser(User user) {
		ModelMapper modelMapper = new ModelMapper();
		UserDocument userDoc = new UserDocument();
		modelMapper.map(user, userDoc);
		userRepo.save(userDoc);
		return true;
	}
}
