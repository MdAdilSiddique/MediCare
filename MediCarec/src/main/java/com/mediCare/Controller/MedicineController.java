package com.mediCare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mediCare.entity.Medicine;
import com.mediCare.Services.MedicineServices;

@Controller
public class MedicineController {
	
	@Autowired
	MedicineServices mediService;
	
	@RequestMapping("/home")
	public String showHome()
	{
		return "index";
	}
	@RequestMapping("/services")
	public String showServices()
	{
		return "services";
	}
	@RequestMapping("/about")
	public String showAboutUs()
	{
		return "about";
	}
	@RequestMapping("/contact")
	public String showContact()
	{
		return "contact";
	}
	@RequestMapping("/addpage")
	public String addPage()
	{
		return "addpage";
	}
	@RequestMapping("/add")
	public String add(ModelMap map,@RequestParam String id,@RequestParam String name,@RequestParam String count,@RequestParam String des)
	{
		Medicine medi=new Medicine();
		medi.setmID(Integer.parseInt(id));
		medi.setmName(name);
		medi.setmCount(Integer.parseInt(count));
		medi.setmDescription(des);
		
		String status=mediService.add(medi);
		return status;		
		
	}

}
