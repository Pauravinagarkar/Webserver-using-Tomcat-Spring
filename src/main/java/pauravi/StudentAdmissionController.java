package main.java.pauravi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

    @RequestMapping("/admissionForm")
    public ModelAndView getAdmissionForm() {
        ModelAndView model = new ModelAndView("AdmissionForm");
        return model;
    }

    @RequestMapping("/submitAdmissionForm")
    public ModelAndView submitAdmissionForm() {
        ModelAndView model = new ModelAndView("AdmissionSuccess");
        return model;
    }
}
