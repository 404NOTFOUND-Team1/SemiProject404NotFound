package com.nf.not404found.admin.event.model.service;


import com.nf.not404found.admin.event.model.dao.AdminEventMapper;
import com.nf.not404found.admin.event.model.dto.AdminEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class AdminEventServiceImpl implements AdminEventService{

    private final AdminEventMapper mapper;

    public AdminEventServiceImpl(AdminEventMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<AdminEventDTO> selectAllEvent() {
        log.info("===========================> 이벤트 조회 서비스 ");

        List<AdminEventDTO> eventList = mapper.selectAllEvent();

        log.info("============================> 매퍼 나온 이벤트 : " + eventList);

        return eventList;
    }
}
