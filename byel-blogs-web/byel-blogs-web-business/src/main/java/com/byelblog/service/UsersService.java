package com.byelblog.service;

import com.byelblog.entity.PageSet;
import com.byelblog.entity.Users;

import java.util.List;

/**
 * 用户表(Users)表服务接口
 *
 * @author makejava
 * @since 2023-05-15 10:00:44
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Users queryById(Integer uid);

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

    List<Users> qryByPage(Users us, PageSet pageSet);


    /***
     * 登录判断
     * */
    int qryLogin(Users user);

}
