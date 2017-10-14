package freeLancers.online.repository.irepository;

import freeLancers.online.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AbstractRepository <T extends AbstractEntity, ID extends Number> extends JpaRepository<T, ID>  {
}
