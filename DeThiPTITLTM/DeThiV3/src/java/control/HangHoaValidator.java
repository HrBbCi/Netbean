/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.HangHoa;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author HrBbCi
 */
public class HangHoaValidator implements Validator {

    MessageSource ms;

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(HangHoa.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HangHoa hh = (HangHoa) o;
        // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idHangHoa","required.idHangHoa" ,"empty");
        //   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenHH", "required.idHangHoa", "empty");
        //   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gia","required.idHangHoa" , "empty");
        if (hh.getIdHangHoa().equals("") || hh.getIdHangHoa().length() == 0) {
            errors.rejectValue("idHangHoa", "required.idHangHoa", "Id ko duoc null");
        }
        if (hh.getTenHH().equals("") || hh.getTenHH().length() == 0) {
            errors.rejectValue("tenHH", "required.tenHH", "Tên ko được null");
        }
//        Pattern p = Pattern.compile("\\d+");
//        Matcher m = p.matcher(hh.getGia());
//         float giaa = 0f;
//        try {
//            giaa = Float.parseFloat(hh.getGia());
//        } catch (NumberFormatException e) {
//        }
 //       boolean b = m.find();
        if (hh.getIdHangHoa().equals("") || hh.getIdHangHoa().length() == 0 || hh.getGia() < 0f) {
            errors.rejectValue("gia", "required.gia", "Giá chưa đúng");
        }

    }

}
