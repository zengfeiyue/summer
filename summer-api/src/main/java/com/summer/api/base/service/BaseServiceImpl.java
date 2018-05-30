package com.summer.api.base.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.summer.api.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
/**
 * @author zengfeiyue
 */
@Service
public class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T,ID> {

    @Autowired
    protected BaseMapper<T,ID> baseMapper;

    @Override
    public int deleteByPrimaryKey(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<T> findByPage(int currPage, int pageSize) {
        PageHelper.startPage(currPage, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(baseMapper.findByPage());
        return pageInfo;
    }
}
