package mid_test.com.jpa_test.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import mid_test.com.jpa_test.rslt;
import mid_test.com.jpa_test.Entities.JpaEntity;
import mid_test.com.jpa_test.Model.JpaModel;
import mid_test.com.jpa_test.Repos.JpaRepo;

@Service
@Log4j2
public class JpaService {

    @Autowired
    JpaRepo jRepo;

    // 조회
    public rslt<JpaEntity> getAllData() {

        List<JpaEntity> jList = jRepo.findAll();

        return new rslt<JpaEntity>(true, "정상적으로 조회되었습니다.", jList);
    }

    // 추가
    public rslt<JpaModel> saveData(JpaModel model) {
        if (model.getUser_name().equals("") || model.getDepartment().equals("") || model.getLevel().equals("")
                || model.getAge() == null) {
            return new rslt<JpaModel>(false, "값을 입력해주세요");
        }
        jRepo.save(JpaEntity.builder().user_name(model.getUser_name())
                .department(model.getDepartment()).level(model.getLevel()).age(model.getAge()).build());

        return new rslt<JpaModel>(true, "저장되었습니다.");

    }

    // 상세보기
    public rslt<JpaModel> getDetailData(@PathVariable("seq") Long seq) {
        Optional<JpaEntity> result = jRepo.findById(seq);
        JpaModel jResult = convertJpaModel(result.get(), seq);
        return new rslt<JpaModel>(true, "정상적으로 조회되었습니다.", jResult);
    }

    // Entity to Dto
    private JpaModel convertJpaModel(JpaEntity jE, Long seq) {
        jRepo.findById(seq);
        return new JpaModel(jE.getSeq(), jE.getUser_name(), jE.getDepartment(), jE.getLevel(), jE.getAge());

    }

    // 삭제
    public rslt<JpaModel> deleteData(@PathVariable("seq") Long seq) {
        jRepo.deleteById(seq);
        return new rslt<JpaModel>(true, "삭제되었습니다.");
    }

    // 수정
    public rslt<JpaModel> updateData(JpaModel model) {
        Long seq = model.getSeq();
        Optional<JpaEntity> result = jRepo.findById(seq);
        log.info(model.toString());

        if (!result.isPresent()) {
            return new rslt<JpaModel>(false, "데이터가 없습니다.");
        } else {

            JpaEntity jResult = result.get();

            jResult.setUser_name(model.getUser_name());
            jResult.setDepartment(model.getDepartment());
            jResult.setLevel(model.getLevel());
            jResult.setAge(model.getAge());

            jRepo.save(jResult);

        }

        return new rslt<JpaModel>(true, "저장되었습니다.");
    }

}
