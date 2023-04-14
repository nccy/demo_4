package com.hnust.dao;

import com.hnust.entity.User;

/**
 * @author 长夜
 * @date 2023/4/10 23:32
 */
public interface UserDao {
    User selectByEmail(String email);
}
