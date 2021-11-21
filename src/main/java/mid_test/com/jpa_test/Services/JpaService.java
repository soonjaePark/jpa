package mid_test.com.jpa_test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mid_test.com.jpa_test.Entities.JpaEntity;
import mid_test.com.jpa_test.Repos.JpaRepo;

@Service
public class JpaService {
    
    @Autowired
    JpaRepo jRepo;

    public List<JpaEntity> getAllData (){
        
        List<JpaEntity> jList = jRepo.findAll();
        List<JpaEntity> njList = new ArrayList<>();
        njList.addAll(jList);
        return njList;
    }
    
}
