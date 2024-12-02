package kr.re.kh.controller.diary;

import kr.re.kh.annotation.CurrentUser;
import kr.re.kh.entity.Trip;
import kr.re.kh.model.CustomUserDetails;
import kr.re.kh.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
@Slf4j
@CrossOrigin("http://localhost:3000")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {

        this.tripService = tripService;
    }

    // 1. 여행 일정 생성
    @PostMapping
    public ResponseEntity<Trip> createTrip(
            @RequestBody HashMap<String, Object> trip,
            @CurrentUser CustomUserDetails userDetails // 로그인한 사용자 정보
    ) {
        log.info(userDetails.toString());
        String userId = String.valueOf(userDetails.getId()); // 사용자 ID 가져오기

        log.info(trip.toString());

        Trip request = new Trip();
        request.setTitle((String) trip.get("title"));
        request.setDescription((String) trip.get("description"));

        String startDateStr = (String) trip.get("startDate");
        String endDateStr = (String) trip.get("endDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date startDateFormat = sdf.parse(startDateStr);
            Date endDateFormat = sdf.parse(endDateStr);
            request.setStartDate(startDateFormat);
            request.setEndDate(endDateFormat);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        request.setUserId(userId);
        log.info(request.toString());
        Trip createdTrip = tripService.createTrip(request);
        // Trip createdTrip = new Trip();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
    }

    // 2. 전체 여행 일정 조회
    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips(@CurrentUser CustomUserDetails customUserDetails) {
        Long userId = customUserDetails.getId();
        List<Trip> trips = tripService.getAllTrips(userId);
        return ResponseEntity.ok(trips);
    }

    // 3. 특정 여행 일정 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        Trip trip = tripService.getTripById(id);
        return ResponseEntity.ok(trip);
    }

    // 4. 여행 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(
            @PathVariable Long id,
            @RequestBody Trip trip,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        Long userId = userDetails.getId(); // 현재 로그인한 사용자 ID
        trip.setUserId(String.valueOf(userId)); // 수정 시에도 userId를 유지

        Trip updatedTrip = tripService.updateTrip(id, trip);
        return ResponseEntity.ok(updatedTrip);
    }

    // 5. 여행 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }
}