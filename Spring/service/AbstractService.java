package content.com.ua.service.iservice;

import content.com.ua.entities.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AbstractService<T extends AbstractEntity> {

    void add(T entity);

    void add(Collection<T> entities);

    void update(T entity);

    T get(Long id);

    long getAllCount();

    List<T> getAll();

    void remove(T entity);

    void remove(Long id);

    void remove(Collection<T> entities);

    void removeAll();

    Page<T> findAll(Pageable pageable);

}
