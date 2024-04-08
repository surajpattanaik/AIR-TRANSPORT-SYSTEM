package com.air.utils;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.air.dto.PlaneDTO;
import com.air.entity.Plane;


@Component
public class PlaneMapper {

    public  PlaneDTO toDTO(Plane plane) {
        PlaneDTO planeDTO = new PlaneDTO();
        BeanUtils.copyProperties(plane, planeDTO);
        return planeDTO;
    }

    public  Plane toEntity(PlaneDTO planeDTO) {
        Plane plane = new Plane();
        BeanUtils.copyProperties(planeDTO, plane);
        return plane;
    }
}
