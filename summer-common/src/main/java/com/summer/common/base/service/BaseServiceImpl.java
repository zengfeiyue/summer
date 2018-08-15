package com.summer.common.base.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.summer.common.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author zengfeiyue
 */
@Service
public class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID> {

    @Autowired
    protected BaseMapper<T,ID> baseMapper;

    @Override
    public Integer deleteByPrimaryKey(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public Integer insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<T> findByPage(int currPage, int pageSize) {
        PageHelper.startPage(currPage, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(baseMapper.findByPage());
        return pageInfo;
    }

    @Override
    public Integer batchInsert(List<T> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Integer batchUpdate(List<T> list) {
        return baseMapper.batchUpdate(list);
    }

    @Override
    public Integer upsert(T record) {
        return baseMapper.upsert(record);
    }

    @Override
    public Integer upsertSelective(T record) {
        return baseMapper.upsertSelective(record);
    }

    @Override
    public List<T> query(T record) {
        return baseMapper.query(record);
    }

    @Override
    public Long queryTotal() {
        return baseMapper.queryTotal();
    }

    @Override
    public Integer deleteBatch(List<Integer> list) {
        return baseMapper.deleteBatch(list);
    }
}
