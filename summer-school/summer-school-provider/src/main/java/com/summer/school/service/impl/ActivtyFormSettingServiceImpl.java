package com.summer.school.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.summer.common.base.service.BaseServiceImpl;
import com.summer.school.api.entity.ActivtyFormSetting;
import com.summer.school.api.service.ActivtyFormSettingService;
@Service(version = "0.1",interfaceClass = ActivtyFormSettingService.class,
        timeout = 5000,mock = "return null")
@org.springframework.stereotype.Service
public class ActivtyFormSettingServiceImpl extends BaseServiceImpl<ActivtyFormSetting,Integer> implements ActivtyFormSettingService {
}
