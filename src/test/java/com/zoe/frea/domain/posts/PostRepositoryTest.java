package com.zoe.frea.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository repo;

    @After
    public void cleanUp() {
        repo.deleteAll();
    }

    @Test
    public void postSaveLoad() {
        String title = "테스트 게시글";
        String content =  "테스트 본문";

        repo.save(Posts.builder().title(title).content(content).author("yunzoe").build());

        List<Posts> postList = repo.findAll();

        Posts p = postList.get(0);
        assertThat(p.getTitle()).isEqualTo(title);
        assertThat(p.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_register() {
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        repo.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        List<Posts> postsList = repo.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate" + posts.getCreateDate() + ",modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
