package kr.re.kh.controller.diary;

import kr.re.kh.entity.PlaceVO;
import kr.re.kh.service.PlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")

public class PlaceController {

@Autowired
    private PlaceService placeService;

// 모든 장소 조회
    @GetMapping
    public List<PlaceVO> getAllPlaces() {
        return placeService.getAllPlaces();
    }
    // ID로 장소 조회
    @GetMapping("/{id}")
    public PlaceVO getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    // 특정 Trip ID에 속한 장소 조회
    @GetMapping("/trip/{tripId}")
    public List<PlaceVO> getPlacesByTripId(@PathVariable Long tripId) {
        return placeService.getPlacesByTripId(tripId);
    }

    // 새로운 장소 생성
    @PostMapping
    public PlaceVO createPlace(@RequestBody PlaceVO place) {
        return placeService.createPlace(place);
    }

    // 장소 업데이트
    @PutMapping("/{id}")
    public PlaceVO updatePlace(@PathVariable Long id, @RequestBody PlaceVO place) {
        return placeService.updatePlace(id, place);
    }

    // 장소 삭제
    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
    }
}
