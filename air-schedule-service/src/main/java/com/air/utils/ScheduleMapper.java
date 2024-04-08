package com.air.utils;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.air.dto.ScheduleDTO;
import com.air.entity.Schedule;

@Component
public class ScheduleMapper {

    public  ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        return scheduleDTO;
    }

    public  Schedule toEntity(ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }
}
