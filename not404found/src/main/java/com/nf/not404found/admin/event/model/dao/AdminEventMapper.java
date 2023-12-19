package com.nf.not404found.admin.event.model.dao;


import com.nf.not404found.admin.event.model.dto.AdminEventDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminEventMapper {

    List<AdminEventDTO> selectAllEvent();
}
