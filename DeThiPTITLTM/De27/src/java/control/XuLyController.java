/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import model.Number;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HrBbCi
 */
@Controller
public class XuLyController {

    @RequestMapping(value = "phantich", method = RequestMethod.GET)
    public String phantich(Model model) {
        model.addAttribute("PTSNT", new Number());
        return "nhapdulieu";
    }

    @RequestMapping(value = "phantich", method = RequestMethod.POST)
    public String phantich(@ModelAttribute("PTSNT") Number n, Model model) {
        String kq = "";
        if (n.getNumber() == 0 ) {
            kq = "0";
            model.addAttribute("kq", kq);
            model.addAttribute("so", n.getNumber());
            return "ketqua";
        }
        if ( n.getNumber() == 1) {
            kq = "1";
            model.addAttribute("kq", kq);
            model.addAttribute("so", n.getNumber());
            return "ketqua";
        }
        ClientControl cc = new ClientControl();
        kq = cc.remoteKetQua(n);
        model.addAttribute("kq", kq);
        model.addAttribute("so", n.getNumber());
        return "ketqua";
    }

}
