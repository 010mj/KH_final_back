package kr.re.kh.mapper;

import kr.re.kh.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TripMapper {
    List<Schedule> getSchedulesByTripId(String tripId);
}
