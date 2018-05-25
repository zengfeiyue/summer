package com.test.summer.api.base.service;
import java.io.Serializable;

/**
 * @author zengfeiyue
 */
public interface IBaseService<T,ID extends Serializable> {
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
}