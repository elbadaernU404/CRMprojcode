package main.dao;

import main.model.User;

import java.util.List;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:40
 */
public interface GetUserDao {

    public List<User> GetAllUser();//返回值类型List<User>
}
