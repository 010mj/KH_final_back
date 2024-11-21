package kr.re.kh.service.impl;

import kr.re.kh.entity.PlaceVO;
import kr.re.kh.repository.PlaceRepository;
import kr.re.kh.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public List<PlaceVO> getAllPlaces() {
        return placeRepository.findAll();
    }
    @Override
    public PlaceVO getPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new RuntimeException("Place not found with id: " + id));
    }

    @Override
    public List<PlaceVO> getPlacesByTripId(Long tripId) {
        return placeRepository.findByTripId(tripId);
    }

    @Override
    public PlaceVO createPlace(PlaceVO place) {
        return placeRepository.save(place);
    }

    @Override
    public PlaceVO updatePlace(Long id, PlaceVO place) {
        PlaceVO existingPlace = getPlaceById(id);
        existingPlace.setName(place.getName());
        existingPlace.setAddress(place.getAddress());
        existingPlace.setLatitude(place.getLatitude());
        existingPlace.setLongitude(place.getLongitude());
        return placeRepository.save(existingPlace);
    }

    @Override
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

}
