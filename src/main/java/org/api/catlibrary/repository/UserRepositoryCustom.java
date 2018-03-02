package org.api.catlibrary.repository;

import org.api.catlibrary.data.UserDocument;

public interface UserRepositoryCustom {
	UserDocument findByUsername(String username);
	UserDocument findByEmail(String email);
	UserDocument findByToken(String token);
}
