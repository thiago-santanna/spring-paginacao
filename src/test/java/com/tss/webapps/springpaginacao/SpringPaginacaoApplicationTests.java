package com.tss.webapps.springpaginacao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringPaginacaoApplicationTests {

    static final Post POST_1 = new Post(1L, "Hello, World!", "Alice");
    static final Post POST_2 = new Post(2L, "Spring Boot is awesome!", "Bob");

    @Autowired
    PostService postService;

    @Test
    void contextLoads() {
        Pageable pageable = PageRequest.of(0, 2);

        Page<Post> posts = postService.listPost(pageable);

        assertEquals(2, posts.getContent().size());
        assertEquals(POST_1, posts.getContent().get(0));
        assertEquals(POST_2, posts.getContent().get(1));
    }

}
