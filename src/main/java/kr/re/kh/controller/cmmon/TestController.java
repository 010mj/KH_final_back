package kr.re.kh.controller.cmmon;

import kr.re.kh.model.payload.request.BoardRequest;
import kr.re.kh.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/cmmn")
@Slf4j
@AllArgsConstructor
public class TestController {
    private final TestService testService;
    @PostMapping("/testSave")
    public ResponseEntity<?> testSave(@RequestBody HashMap<String,Object> map){
        log.info((String) map.get("title"));
        log.info((String) map.get("content"));
        testService.save(map);
        return ResponseEntity.ok("aaaa");
    }
    @GetMapping("/findAll")
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok(testService.findAll());
    }
    @GetMapping("/findByTitle")
    public ResponseEntity<?> findByTitle(
      @RequestParam(value="title") String title
    ){
        return ResponseEntity.ok(testService.findByTitle(title));
    }

}
