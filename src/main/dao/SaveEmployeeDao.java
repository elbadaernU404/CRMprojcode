package main.dao;

import main.model.Employee;
import main.model.Employee;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-23 15:23
 */
public interface SaveEmployeeDao {
    //保存新用户
    public void saveEmployee(Employee employee);
    //更新用户
    public void updateEmployee(Employee employee);
}