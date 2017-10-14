package freeLancers.online.service.impl.blog;

import freeLancers.online.entities.blog.Category;
import freeLancers.online.repository.irepository.blog.CategoryRepository;
import freeLancers.online.service.impl.AbstractServiceImpl;
import freeLancers.online.service.iservice.blog.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    /**
     * Categories page ordered by site domain
     *
     * @param pageable - page @see {@link Pageable}
     * @return categories page
     */
    @Override
    public Page<Category> findAllOrderBySiteDomain(Pageable pageable) {
        return categoryRepository.findAllOrderBySiteDomain(pageable);
    }

    /**
     * Find categories by domain id
     *
     * @param domainId - search domain id
     * @return categories list
     */
    @Override
    public List<Category> findAllByDomain(Long domainId) {
        return categoryRepository.findAllByDomain(domainId);
    }

    /**
     * Find categories by domain name
     *
     * @param domain - search domain name
     * @return domain's categories list
     */
    @Override
    public List<Category> findAllByDomain(String domain) {
        return categoryRepository.findAllByDomain(domain);
    }

    /**
     * Find category by url and domain name
     *
     * @param url    - search category url
     * @param domain - search domain name
     * @return found category
     */
    @Override
    public Category findByUrlAndDomain(String url, String domain) {
        return categoryRepository.findByUrlAndDomain(url, domain);
    }
}
