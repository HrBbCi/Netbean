/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.RMIServerControl;

/**
 *
 * @author HrBbCi
 */
public class RMIServerView {

    public RMIServerView() {
        new RMIServerControl();
        System.out.println("RMI Server RUN");
    }
    
}
