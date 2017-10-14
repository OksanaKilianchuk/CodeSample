package freeLancers.online.repository.irepository.blog;

import freeLancers.online.entities.blog.Category;
import freeLancers.online.repository.irepository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yurii on 21.03.2017.
 */
@Repository
public interface CategoryRepository extends AbstractRepository<Category, Long> {
    @Query("select c from Category c order by c.siteDomain.name")
    Page<Category> findAllOrderBySiteDomain(Pageable pageable);

    @Query("select c from Category c where c.siteDomain.id = ?1")
    List<Category> findAllByDomain(Long domainId);

    @Query("select c from Category c where c.siteDomain.name = ?1")
    List<Category> findAllByDomain(String domain);

    @Query("select c from Category c where c.url = ?1 and c.siteDomain.name= ?2")
    Category findByUrlAndDomain(String url, String domain);
}
