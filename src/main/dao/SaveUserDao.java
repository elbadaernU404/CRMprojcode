package main.dao;

import main.model.User;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:40
 */
public interface SaveUserDao {
//保存新用户
    public void saveUser(User user);
    //更新用户
    public void updateUser(User user);
}
