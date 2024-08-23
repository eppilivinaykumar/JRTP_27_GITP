package in.ashokit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounsellorController {
	
	@GetMapping("/")
	public String index(Model model) {
		//model is use send the data from controller to UI part
		
		
		// returing view name
		return "index";
	}
	
	
	
	

}
