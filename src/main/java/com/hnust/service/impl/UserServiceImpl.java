package com.hnust.service.impl;

import com.hnust.dao.UserDao;
import com.hnust.entity.User;
import com.hnust.service.UerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 长夜
 * @date 2023/4/10 23:37
 */
@Service
public class UserServiceImpl implements UerService {
    @Autowired
    private UserDao uerDao;
    @Override
    public User selectByEmail(String email) {
        return uerDao.selectByEmail(email);
    }
}
