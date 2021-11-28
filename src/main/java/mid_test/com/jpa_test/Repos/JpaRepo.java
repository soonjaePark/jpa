package mid_test.com.jpa_test.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mid_test.com.jpa_test.Entities.JpaEntity;

@Repository
public interface JpaRepo extends JpaRepository<JpaEntity, Long> {

}
