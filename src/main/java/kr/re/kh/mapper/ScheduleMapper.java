package kr.re.kh.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {
    void deleteByTripId(String tripId);
}
