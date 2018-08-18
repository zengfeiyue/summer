package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.Advertisement;
import com.summer.school.api.service.AdvertisementService;
@Service(version = "0.1",interfaceClass = AdvertisementService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class AdvertisementServiceImpl extends BaseServiceImpl<Advertisement, Integer> implements AdvertisementService {
}
