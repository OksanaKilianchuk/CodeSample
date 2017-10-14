package freeLancers.online.repository.irepository.blog;

import freeLancers.online.entities.blog.Post;
import freeLancers.online.repository.irepository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends AbstractRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    @Query("select p from Post p where p.category.siteDomain.name = ?1 order by p.date desc")
    Page<Post> findAllByDomain(String domain, Pageable pageable);

    @Query("select p from Post p where p.category.url = ?1 and p.category.siteDomain.name = ?2 order by p.date desc")
    Page<Post> findAllByDomainAndCategory(String category, String domain, Pageable pageable);

    @Query("select p from Post p where p.url = ?1 and p.category.url = ?2 and p.category.siteDomain.name = ?3")
    Post findByUrlAndCategoryAndDomain(String url, String category, String domain);
}
