package control;

import Model.ChuanHoaChuoi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class XuLyViewCilentController {
    
    @RequestMapping(value = "chuanhoaUDP", method = RequestMethod.GET)
    public String chuanhoaUDP(Model model) {
        model.addAttribute("chuanHoaVB", new ChuanHoaChuoi());
        return "index";
    }

    @RequestMapping(value = "chuanhoaUDP", method = RequestMethod.POST)
    public String chuanhoaUDP(@ModelAttribute("chuanHoaVB") ChuanHoaChuoi hh, BindingResult result, Model model) {
        String chuoi = hh.getChuoi();
        ChuanHoaChuoi h1 = new ChuanHoaChuoi(chuoi);
        ClientControl clientCtr = new ClientControl();
        clientCtr.openConnection();
        clientCtr.sendData(hh);
        String result1 = clientCtr.receiveData();
        if(result1 != null){
            model.addAttribute("Ok", result1);
            clientCtr.closeConnection(); 
            return "ketqua";
        }
        model.addAttribute("Ok", "fail");
        return "index";
    }
}
