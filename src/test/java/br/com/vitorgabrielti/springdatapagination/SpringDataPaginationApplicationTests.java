package br.com.vitorgabrielti.springdatapagination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class SpringDataPaginationApplicationTests {

	static final Post POST_0 = 
		new Post(1L, "Primeiro valor", "exemplo1@email.com");
	static final Post POST_1 = 
		new Post(2L, "Segundo valor", "exemplo2@email.com");
	@Autowired
	PostService postService;

	@Test
	void testListPostsPaginated() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Post> pagePost = postService.listPosts(pageable);

		assertEquals(2, pagePost.getContent().size());
		assertEquals(POST_0, pagePost.getContent().get(0));
		assertEquals(POST_1, pagePost.getContent().get(1));
	}

}
