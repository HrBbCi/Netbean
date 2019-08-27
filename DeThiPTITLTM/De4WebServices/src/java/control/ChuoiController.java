/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.ChuoiChuanHoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.ChuoiServices;

/**
 *
 * @author HrBbCi
 */
@Controller
public class ChuoiController {

    @Autowired(required = true)
    @Qualifier("chuoiServices")
    private ChuoiServices chuoiService;

    public ChuoiController() {
    }

    @RequestMapping(value = "chuanhoaWebS", method = RequestMethod.GET)
    public String chuanhoaUDP(Model model) {
        model.addAttribute("chuanHoaVB", new ChuoiChuanHoa());
        return "index";
    }

    @RequestMapping(value = "chuanhoaWebS", method = RequestMethod.POST)
    public String chuanhoaUDP(@ModelAttribute("chuanHoaVB") ChuoiChuanHoa hh, BindingResult result, Model model) {
        String chuoi = hh.getChuoi();
        StringBuilder abc = chuoiService.getRes(chuoi.toLowerCase().toString());
        String kq = abc.toString();
        model.addAttribute("Ok", kq);
        return "ketqua";
    }
}
