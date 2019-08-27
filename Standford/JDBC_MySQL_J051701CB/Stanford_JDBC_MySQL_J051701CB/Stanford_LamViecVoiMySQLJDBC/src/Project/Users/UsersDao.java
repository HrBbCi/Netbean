/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Users;

import java.util.List;

/**
 *
 * @author HrBbCi
 */
public interface UsersDao<T,E> {
    List<T> getAll();

    T getByID(E id);
    
     boolean themMoiUsers(T users);

     boolean xoaUsers(E users);

     boolean suaUsers(T users);
     
     List<T> findUsers(E users);
}
