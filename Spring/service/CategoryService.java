package freeLancers.online.service.iservice.blog;

import freeLancers.online.entities.blog.Category;
import freeLancers.online.service.iservice.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService extends AbstractService<Category> {
    Page<Category> findAllOrderBySiteDomain(Pageable pageable);

    List<Category> findAllByDomain(Long domainId);

    List<Category> findAllByDomain(String domain);

    Category findByUrlAndDomain(String url, String domain);
}
