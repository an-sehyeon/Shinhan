package com.shinhan.sbroject;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shinhan.sbroject.entity.GuesttBookEntity;
import com.shinhan.sbroject.repository.GuestBookRepository;

@SpringBootTest
public class GuestBookTest {
	@Autowired
	GuestBookRepository repo;
	
//	@Test
//	void f2() {
//		repo.findById(1L).ifPresent(book->{
//			book.setContent("배고파~~~~~~");
//			repo.save(book);
//		});
//	}
	
	@Test
	void f1() {
		IntStream.rangeClosed(1, 10).forEach(i->{
		GuesttBookEntity book = GuesttBookEntity.builder()
				.title("book" + i)
				.writer("jj")
				.content("점심~~~~~~~~")
				.build();
		repo.save(book);
		});
	}
}
