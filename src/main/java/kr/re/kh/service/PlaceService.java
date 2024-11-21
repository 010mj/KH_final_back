package kr.re.kh.service;



import kr.re.kh.entity.PlaceVO;

import java.util.List;

public interface PlaceService {
    List<PlaceVO> getAllPlaces();
    PlaceVO getPlaceById(Long id);
    List<PlaceVO> getPlacesByTripId(Long tripId);
    PlaceVO createPlace(PlaceVO place);
    PlaceVO updatePlace(Long id, PlaceVO place);
    void deletePlace(Long id);
}
