package org.api.catlibrary.interfaces;

import java.util.List;

import org.api.catlibrary.domain.Book;
import org.api.catlibrary.domain.BookFilter;
import org.api.catlibrary.domain.UserVote;
import org.api.catlibrary.services.LibraryService;
import org.api.catlibrary.util.logging.LogInfo;
import org.api.catlibrary.util.logging.LogTracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	public LibraryController(LibraryService libraryService) {
		this.libraryService=libraryService;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public List<Book> getBooks(@RequestBody BookFilter filter) throws Exception {
		LogInfo info=new LogInfo();
		info.setTransactionRef("1234");
		info.setNodeRef("daniel-laptop");
		info.setConsumerRef("consumer");
		info.setMessage("pase por aqui");
		LogTracking.start(info);
		List<Book> l = libraryService.getAll(filter);
		LogTracking.stop(info);
		return l;
	}
	
	@RequestMapping(value="/storeBook", method=RequestMethod.POST)
	public boolean saveBook(@RequestBody Book book) throws Exception {
		return libraryService.storeBook(book);
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable("id") String id) {
		return libraryService.getBook(id);
	}
	
	@RequestMapping(value="/voteBook", method=RequestMethod.POST)
	public boolean voteBook(@RequestBody UserVote vote) {
		boolean result = libraryService.qualify(vote.getBookId(), vote.isLikeIt(), vote.getUsername());
		return result;
	}
}