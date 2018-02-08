package org.api.catlibrary.repository;

import org.api.catlibrary.data.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<BookDocument, Long>, BookRepositoryCustom{
	
}

//import org.api.catlibrary.data.BookMapper;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

//@Repository
//public interface IBookRepository extends JpaRepository<BookMapper, Long>{
//	
//}
