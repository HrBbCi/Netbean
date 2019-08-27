/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import model.HangHoa;

/**
 *
 * @author HrBbCi
 */
public interface DAO {

    public boolean updateHH(HangHoa h);

    public HangHoa findByID(String id);

    public List<HangHoa> findByIDList(String id);
}
