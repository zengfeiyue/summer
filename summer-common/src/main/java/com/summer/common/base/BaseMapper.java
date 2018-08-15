package com.summer.common.base;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author zengfeiyue
 */
public interface BaseMapper<T,ID extends Serializable> {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(ID id);

    /**
     * 新增
     * @param record
     * @return
     */
    Integer insert(T record);

    /**
     * 新增
     * @param record
     * @return
     */
    Integer insertSelective(T record);

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
    Integer updateByPrimaryKeySelective(T record);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    Integer updateByPrimaryKey(T record);

    /**
     * 分页查询数据
     * @return
     */
    Page<T> findByPage();

    /**
     * 批量插入
     * @param list
     * @return
     */
    Integer batchInsert(List<T> list);

    /**
     * 批量更新
     * @param list
     * @return
     */
    Integer batchUpdate(List<T> list);

    /**
     * 存在即更新
     * @param record
     * @return
     */
    Integer upsert(T record);

    /**
     * 存在即更新，可选择具体属性
     * @param record
     * @return
     */
    Integer upsertSelective(T record);

    /**
     * 查询
     * @param record
     * @return
     */
    List<T> query(T record);

    /**
     * 记录数
     * @return
     */
    Long queryTotal();

    /**
     * 批量删除
     * @param list
     * @return
     */
    Integer deleteBatch(List<Integer> list);

}
