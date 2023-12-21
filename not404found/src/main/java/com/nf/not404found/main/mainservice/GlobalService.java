package com.nf.not404found.main.mainservice;

import com.nf.not404found.main.model.dao.GlobalMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalService {
    GlobalMapper mapper;

    public List<String> findAllCategories() {
        return mapper.findAllCategory();
    }
}
