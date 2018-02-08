package org.api.catlibrary.services;

import java.lang.reflect.Type;
import java.util.List;

import org.api.catlibrary.data.BookDocument;
import org.api.catlibrary.domain.Book;
import org.api.catlibrary.domain.BookFilter;
import org.api.catlibrary.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAll(BookFilter bookFilter){
		Type targetBooks = new TypeToken<List<Book>>() {}.getType();
		ModelMapper modelMapper = new ModelMapper();
		List<BookDocument> bl = (List<BookDocument>) bookRepo.findAllBooks(bookFilter);
		List<Book> books = modelMapper.map(bl, targetBooks);
		return books;
	}
	
	public boolean storeBook(Book book) throws Exception {
		BookDocument bookDoc=new BookDocument();
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.map(book, bookDoc);
		bookRepo.save(bookDoc);
		return true;
	}
	
	public Book getBook(String id) {
		bookRepo.findOne((long) 2);
		return null;
	}
}
