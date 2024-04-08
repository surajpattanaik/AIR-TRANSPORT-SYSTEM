package com.air.service;

import com.air.dto.ScheduleDTO;
import com.air.entity.Schedule;
import com.air.exception.bean.ResourceNotFoundException;
import com.air.proxy.BookingFeignClient;
import com.air.proxy.IdGeneratorFeignClient;
import com.air.repository.ScheduleRepository;
import com.air.utils.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private IdGeneratorFeignClient idGenerator;

    @Autowired
    private ScheduleMapper scheduleMapper;
    
	@Autowired
	BookingFeignClient bclient;

    public List<ScheduleDTO> getAllSchedules() {
    	List<ScheduleDTO> sdtos = scheduleRepository.findAll()
                .stream()
                .map(scheduleMapper::toDTO)
                .collect(Collectors.toList());
		sdtos.stream().forEach(sdto -> sdto.setBdto(bclient.getBookingsByScheduleId(sdto.getId()).getBody()));
		return sdtos;

    }

    public ScheduleDTO getScheduleById(String id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
	      ScheduleDTO sdto= scheduleMapper.toDTO(schedule);
	      sdto.setBdto(bclient.getBookingsByScheduleId(id).getBody());
	      
	      return sdto;
    }

    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleMapper.toEntity(scheduleDTO);
        schedule.setId(idGenerator.getGeneratedId());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDTO(savedSchedule);
    }

    public ScheduleDTO updateSchedule(String id, ScheduleDTO updatedScheduleDTO) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
        schedule.setPlaneId(updatedScheduleDTO.getPlaneId());
        schedule.setDepartureTime(updatedScheduleDTO.getDepartureTime());
        schedule.setArrivalTime(updatedScheduleDTO.getArrivalTime());
        schedule.setSourceAirportId(updatedScheduleDTO.getSourceAirportId());
        schedule.setDestinationAirportId(updatedScheduleDTO.getDestinationAirportId());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return scheduleMapper.toDTO(savedSchedule);
    }

    public void deleteSchedule(String id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
		if(!bclient.getBookingsByScheduleId(id).getBody().isEmpty()) {
			 bclient.deleteBookingsByScheduleId(id);
		 }
        scheduleRepository.delete(schedule);
    }

    public List<ScheduleDTO> getSchedulesByAirportId(String airportId) {
        return scheduleRepository.findBySourceAirportIdOrDestinationAirportId(airportId, airportId)
                .stream()
                .map(scheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteSchedulesByAirportId(String airportId) {
        List<Schedule> schedules = scheduleRepository.findBySourceAirportIdOrDestinationAirportId(airportId, airportId);
        scheduleRepository.deleteAll(schedules);
    }

    public List<ScheduleDTO> getSchedulesByPlaneId(String planeId) {
        return scheduleRepository.findByPlaneId(planeId)
                .stream()
                .map(scheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteSchedulesByPlaneId(String planeId) {
        List<Schedule> schedules = scheduleRepository.findByPlaneId(planeId);
        scheduleRepository.deleteAll(schedules);
    }
    
}
