/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.ChuanHoaChuoi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HrBbCi
 */
@Controller
public class XuLyClientControl {

    @RequestMapping(value = "chuanhoa", method = RequestMethod.GET)
    public String nhaphangmoi(Model model) {
        model.addAttribute("chuanHoaVB", new ChuanHoaChuoi());
        return "index";
    }

    @RequestMapping(value = "chuanhoa", method = RequestMethod.POST)
    public String nhaphangmoi(@ModelAttribute("chuanHoaVB") ChuanHoaChuoi hh, BindingResult result, Model model) {
        // hangHoaValidator.validate(hh, result);
//        if (result.hasErrors()) {
//            return "index";
//        }
        String chuoi = hh.getChuoi();
        ChuanHoaChuoi h1 = new ChuanHoaChuoi(chuoi);
        ClientControl xuLyClient = new ClientControl();
        xuLyClient.openConnection();
        xuLyClient.sendData(h1);
        String rString = xuLyClient.receiveData();
        model.addAttribute("Ok", rString);
        xuLyClient.closeConnection();
         
        return "index";
    }
}
