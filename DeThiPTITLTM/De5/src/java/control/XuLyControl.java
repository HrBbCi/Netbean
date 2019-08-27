/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.GiaiPTB2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XuLyControl {

    @RequestMapping(value = "giaiPT", method = RequestMethod.GET)
    public String giaiPT(Model model) {
        model.addAttribute("giaiPTB2", new GiaiPTB2());
        return "giaiPT";
    }

    @RequestMapping(value = "giaiPT", method = RequestMethod.POST)
    public String giaiPT(@ModelAttribute("giaiPTB2") GiaiPTB2 g, BindingResult result, Model model) {
        float x1 = 0f;
        float x2 = 0f;
        ClientControl cc = new ClientControl();
        cc.openConnection();
        cc.sendData(g);
        GiaiPTB2 kq = cc.receiveData();
        if (kq.getKq().equals("VN") || kq.getKq().equals("VSN") ) {
            model.addAttribute("kq", kq.getKq());
        } else {
            if (kq.getKq().equals("2N") || kq.getKq().equals("NK") ) {
                x1 = kq.getX1();
                x2 = kq.getX2();
                model.addAttribute("kq", kq.getKq() + "\n" + x1 + "\n" + x2);
            }
            else{
              x1 = kq.getX1();
              model.addAttribute("kq", kq.getKq() + "\n" + x1);
            }
        }
        cc.closeConnection();
        return "giaiPT";
    }
}
