package com.xu.service;

import com.xu.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {

    List<BaseDict> findItemNameByTypeCode(String code);
}
