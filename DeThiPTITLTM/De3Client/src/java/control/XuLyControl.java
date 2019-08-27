package control;

import model.CHC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class XuLyControl {
    
    @RequestMapping(value = "chuanhoaRMI", method = RequestMethod.GET)
    public String chuanhoaRMI(Model model) {
        model.addAttribute("chuanHoaVB", new CHC());
        return "nhap";
    }

    @RequestMapping(value = "chuanhoaRMI", method = RequestMethod.POST)
    public String chuanhoaRMI(@ModelAttribute("chuanHoaVB") CHC hh, BindingResult result, Model model) {
        ClientControl cc = new ClientControl();
        if(hh.getChuoi() ==  null || hh.getChuoi().length() == 0){
            return "redirect:/chuanhoaRMI?ok=0";
        }
        String kq = cc.remoteCHC(hh.getChuoi());
        if(kq != null){
            model.addAttribute("Ok", kq);
            return "ketqua";
        }
        model.addAttribute("Ok", "fail");
        return "nhap";
    }
}
