/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.SinhVien;

import java.util.List;

/**
 *
 * @author HrBbCi
 */
public interface SinhVienDao<T, E> {
    List<T> getAll();

    T getByID(E id);
    
     boolean themMoi(T sv);

     boolean xoaSV(E maSV);

     boolean suaSV(T sv);
     
     List<T> findStudents(E maSV);
}
