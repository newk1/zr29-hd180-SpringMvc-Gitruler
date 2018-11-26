/**
 * (C) Artur Boronat, 2015
 */
package labMvc.control;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import labMvc.domain.Student;

@Controller
public class IndexController {
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(new StudentValidator());
    }
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(@ModelAttribute("student") Student student) {
    		return "form/form";
    }
    
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("student") Student student,  BindingResult result, Model model) {
    		if (!result.hasErrors() ) {
    			model.addAttribute("name", student.getName());
    			model.addAttribute("age", student.getAge());
    			model.addAttribute("id", student.getId());
    			return "form/result";
    		} else  
    			return "form/form";
    }     
    @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage() {      
      return "/form/final";
    }

}
