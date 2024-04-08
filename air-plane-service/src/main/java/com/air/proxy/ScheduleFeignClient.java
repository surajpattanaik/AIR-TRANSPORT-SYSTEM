package com.air.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.air.dto.ScheduleDTO;

@FeignClient(name = "schedule-service")
public interface ScheduleFeignClient {

    // Get all schedules by plane ID
    @GetMapping("/api/schedules/plane/{id}")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedulesByPlaneId(@PathVariable String id);

    // Delete all schedules by plane ID
    @DeleteMapping("/api/schedules/plane/{id}")
    public ResponseEntity<Void> deleteAllSchedulesByPlaneId(@PathVariable String id);


}
