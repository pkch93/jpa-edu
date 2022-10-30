package edu.pkch.jpaedu.practice;

import edu.pkch.jpaedu.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest extends JpaEduTest {

    /**
     * @see edu.pkch.jpaedu.entity.Post
     */
    @Test
    void persist() {
        Post post = new Post("title", "content");

        EntityManager entityManager = testPersistence.entityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(post);
        transaction.commit();

        List<Post> persisted = entityManager.createQuery("select p from Post p").getResultList();
        assertThat(persisted).hasSize(1)
                .extracting(Post::getId)
                .contains(post.getId());
    }
}
