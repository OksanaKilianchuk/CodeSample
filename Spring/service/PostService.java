package freeLancers.online.service.iservice.blog;

import freeLancers.online.entities.blog.Post;
import freeLancers.online.service.iservice.AbstractService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService extends AbstractService<Post> {

    String uploadPicture(String picture, String postUrl);

    Page<Post> findAllByDomain(String domain, Pageable pageable);

    Page<Post> findAllByDomainAndCategory(String category, String domain, Pageable pageable);

    Post findByUrlAndCategoryAndDomain(String url, String category, String domain);
}
