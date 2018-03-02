package org.api.catlibrary.domain;

public class UserVote {
	String bookId;
	String username;
	boolean likeIt;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isLikeIt() {
		return likeIt;
	}
	public void setLikeIt(boolean likeIt) {
		this.likeIt = likeIt;
	}
}
