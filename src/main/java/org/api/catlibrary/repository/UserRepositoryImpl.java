package org.api.catlibrary.repository;

import org.api.catlibrary.data.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public UserDocument findByUsername(String username) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("username").is(username));
		UserDocument userDoc = mongoTemplate.findOne(query, UserDocument.class);
		return userDoc;
	}

	@Override
	public UserDocument findByEmail(String email) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("email").is(email));
		UserDocument userDoc = mongoTemplate.findOne(query, UserDocument.class);
		return userDoc;
	}

	@Override
	public UserDocument findByToken(String token) {
		Query query = new Query();
		
		query.addCriteria(Criteria.where("confirmationToken").is(token));
		UserDocument userDoc = mongoTemplate.findOne(query, UserDocument.class);
		return userDoc;
	}

}
