package org.api.catlibrary.repository;

import java.util.List;

import org.api.catlibrary.data.BookDocument;
import org.api.catlibrary.domain.BookFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class BookRepositoryImpl implements BookRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<BookDocument> findAllBooks(BookFilter query) {
		Pageable pgReq = new PageRequest(query.getPage(), query.getPageCount());
		
		Query q = new Query();
		Criteria c = new Criteria();
		
		if (query.getSearchText()!="")
			c.orOperator(
					Criteria.where("author").regex(query.getSearchText()), 
					Criteria.where("description").regex(query.getSearchText()), 
					Criteria.where("title").regex(query.getSearchText())
					);
		
		q.addCriteria(c);
		q.with(pgReq);
		//q.addCriteria(Criteria.where("author").regex(query.getSearchText()).orOperator(Criteria.where("description").regex(query.getSearchText())), Criteria.where("title").regex(query.getSearchText()));
		//q.addCriteria(Criteria.where("price").gte(25000));
		
		List<BookDocument> books=mongoTemplate.find(q, BookDocument.class);
		return books;
	}

}
