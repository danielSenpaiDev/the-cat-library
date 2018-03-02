package org.api.catlibrary.repository;

import org.api.catlibrary.data.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String>, UserRepositoryCustom {

}
