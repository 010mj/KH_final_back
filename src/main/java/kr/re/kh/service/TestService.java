package kr.re.kh.service;

import kr.re.kh.model.TestVO;
import kr.re.kh.repository.TestVORepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class TestService {
    private final TestVORepository testVORepository;

    public void save(HashMap<String, Object> map) {
        TestVO vo = new TestVO();
        vo.setTitle((String)map.get("title"));
        vo.setContent((String)map.get("content"));
        testVORepository.save(vo);
    }
    public List<TestVO> findAll(){
        return testVORepository.findAll();
    }
    public List<TestVO> findByTitle(String title){
        return testVORepository.findByTitleContaining(title);
    }

}
