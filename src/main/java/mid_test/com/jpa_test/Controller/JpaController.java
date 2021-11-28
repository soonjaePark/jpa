package mid_test.com.jpa_test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mid_test.com.jpa_test.rslt;
import mid_test.com.jpa_test.Entities.JpaEntity;
import mid_test.com.jpa_test.Model.JpaModel;
import mid_test.com.jpa_test.Services.JpaService;

@Controller
public class JpaController {

    @Autowired
    JpaService jService;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "main";
    }

    // 검색
    @GetMapping("/list")
    public @ResponseBody rslt<JpaEntity> mainPageAll() {

        rslt<JpaEntity> result = jService.getAllData();

        return result;
    }

    // 상세보기
    @GetMapping("/list/{seq}")
    public @ResponseBody rslt<JpaModel> detailData(@PathVariable("seq") Long seq) {
        rslt<JpaModel> result = jService.getDetailData(seq);
        return result;
    }

    // 추가
    @PostMapping("/list/save")
    public @ResponseBody rslt<JpaModel> save(JpaModel model) {
        rslt<JpaModel> result = jService.saveData(model);
        return result;
    }

    // 삭제
    @PostMapping("/list/delete/{seq}")
    public @ResponseBody rslt<JpaModel> delete(@PathVariable("seq") Long seq) {
        rslt<JpaModel> result = jService.deleteData(seq);
        return result;
    }

    // 수정
    @PostMapping("/list/update")
    public @ResponseBody rslt<JpaModel> update(JpaModel model) {
        rslt<JpaModel> result = jService.updateData(model);
        return result;
    }

}
