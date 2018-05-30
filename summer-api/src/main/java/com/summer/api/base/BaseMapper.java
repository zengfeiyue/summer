package com.summer.api.base;

import com.github.pagehelper.Page;

import java.io.Serializable;

/**
 * @author zengfeiyue
 */
public interface BaseMapper<T,ID extends Serializable> {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(ID id);

    /**
     * 新增
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 新增
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    T selectByPrimaryKey(ID id);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 分页查询数据
     * @return
     */
    Page<T> findByPage();

}
