package control;

import model.HangHoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class HangHoaController {

  //  private ApplicationContext context = null;
    private UserJDBCTemplate userJDBCTemplate = null;
    @Autowired(required = true)
    @Qualifier("hangHoaValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    public HangHoaController() {
        userJDBCTemplate = new UserJDBCTemplate();
    }

    @RequestMapping(value = "listhh", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("listHH", userJDBCTemplate.listHangHoa());
        return "listHangHoa";
    }

    @RequestMapping(value = "nhaphangmoi", method = RequestMethod.GET)
    public String nhaphangmoi(Model model) {
        model.addAttribute("hanghoa", new HangHoa());
        return "nhaphangmoi";
    }

    @RequestMapping(value = "nhaphangmoi", method = RequestMethod.POST)
    public String nhaphangmoi(@ModelAttribute("hanghoa") @Validated HangHoa hh, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes) {
        // hangHoaValidator.validate(hh, result);
        if (result.hasErrors()) {
            return "nhaphangmoi";
        }
        String id = hh.getIdHangHoa();
        String tenHH = hh.getTenHH();
        float gia = hh.getGia();
        HangHoa h1;
        h1 = new HangHoa(id, tenHH, gia);
        userJDBCTemplate.create(h1);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "HH added successfully!");
        model.put("listHH", userJDBCTemplate.listHangHoa());
        return "redirect:/listhh";

    }

    @RequestMapping(value = "editHH/{id}", method = RequestMethod.GET)
    public String editHangHoa(@PathVariable(value = "id") String id, Model model) {
        HangHoa hh = userJDBCTemplate.getHangHoaByID(id);
        model.addAttribute("hanghoa", hh);
        return "editHangHoa";
    }

    @RequestMapping(value = "editHH", method = RequestMethod.POST)
    public String editHangHoa(@ModelAttribute("hanghoa") @Validated HangHoa hh, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "editHangHoa";
        }
        userJDBCTemplate.updateHangHoa(hh);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "HH update successfully!");
        model.addAttribute("hanghoa", new HangHoa());
        model.addAttribute("listHH", userJDBCTemplate.listHangHoa());
        return "redirect:/listhh";

    }

    @RequestMapping(value = "/deleteHH/{id}", method = RequestMethod.GET)
    public String deleteHangHoa(@PathVariable(value = "id") String id, Model model, final RedirectAttributes redirectAttributes) {
        userJDBCTemplate.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "HH is deleted!");
        model.addAttribute("listHH", userJDBCTemplate.listHangHoa());
        return "redirect:/listhh";
    }
}
