package com.hnust.service;

import com.hnust.entity.User;

/**
 * @author 长夜
 * @date 2023/4/10 23:37
 */
public interface UerService {
    User selectByEmail(String email);
}
