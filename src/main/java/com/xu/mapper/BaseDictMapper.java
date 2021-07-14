package com.xu.mapper;

import com.xu.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {

    List<BaseDict> findItemNameByTypeCode(String code);
}
