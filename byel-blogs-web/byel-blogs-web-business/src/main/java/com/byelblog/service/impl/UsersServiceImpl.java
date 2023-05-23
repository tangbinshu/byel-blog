package com.byelblog.service.impl;

import com.byelblog.dao.UsersDao;
import com.byelblog.entity.PageSet;
import com.byelblog.entity.Users;
import com.byelblog.service.UsersService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(Users)表服务实现类
 *
 * @author makejava
 * @since 2023-05-15 11:19:41
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer uid) {
        return this.usersDao.queryById(uid);
    }

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
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.usersDao.deleteById(uid) > 0;
    }

    @Override
    public List<Users> qryByPage(Users us, PageSet pageSet) {

        PageHelper.startPage(1, 5);
        List<Users> users = this.usersDao.queryAllByLimit(us);
        return users;
    }

    @Override
    public int qryLogin(Users user) {
        return this.usersDao.qryLogin(user);
    }
}
