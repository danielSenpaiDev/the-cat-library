package org.api.catlibrary.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"}, allowGetters=true)
public class BookMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371733332295627383L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idBook;
	
	private String title;
	
	private String description;
	
	private String author;
	
	private int price;

	public long getIdBook() {
		return idBook;
	}

	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public BookMapper() {}
}

//@Mapper
//public interface BookMapper {
////	@Select ("select * from book where id_book=#{id}")
////	public Book findById(long id);
////	
////	@Select ("select * from book")
////	public List<Book> findAll();
//	
//	public int save(@Param("book") Book book, @Param("author") String author, @Param("description") String description, @Param("price") int price, @Param("title") String title);
//}
