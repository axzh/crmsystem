package com.xu.service.imp;

import com.xu.mapper.BaseDictMapper;
import com.xu.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImp implements com.xu.service.BaseDictService {
    @Autowired
    private BaseDictMapper mapper;

    @Override
    public List<BaseDict> findItemNameByTypeCode(String code) {
        return mapper.findItemNameByTypeCode(code);
    }
}
