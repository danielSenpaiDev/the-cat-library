package org.api.catlibrary.repository;

import java.util.List;

import org.api.catlibrary.data.BookDocument;
import org.api.catlibrary.domain.BookFilter;

public interface BookRepositoryCustom {
	List<BookDocument> findAllBooks(BookFilter query);

}
