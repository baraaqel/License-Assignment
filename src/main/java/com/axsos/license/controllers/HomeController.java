package com.axsos.license.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.license.models.License;
import com.axsos.license.models.Person;
import com.axsos.license.services.HomeService;


@Controller
public class HomeController {
	 private final HomeService homeService;
	 public HomeController(HomeService homeService) {
		 this.homeService=homeService;
}
	 
	 // view create person form
	 @RequestMapping("persons/new")
	 public String viewNew(@ModelAttribute("person") Person person) {
	     return "newPerson.jsp";
	 }
	 // create person
	 @RequestMapping(value="/persons/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
	     if (result.hasErrors()) {
	         return "newPerson.jsp";
	     } else {
	         this.homeService.createPerson(person);
	         return "redirect:/licenses/new";
	     }
	 }
	 // view license person form

	 @RequestMapping("licenses/new")
	 public String viewNew(@ModelAttribute("license") License license,Model model) {
		 model.addAttribute("persons",this.homeService.nonLicensedPersons());
	     return "newLicense.jsp";
	 }
	 // create license

	 @RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
		 if (result.hasErrors()) {
	         return "newLicense.jsp";
	     } else {
	    	 if(this.homeService.isPersonHasLicense(license.getPerson()))
	    		 return "redirect:/licenses/new";
	         this.homeService.createLicense(license);
	         return "redirect:/persons/"+license.getPerson().getId().toString();
	     }
	 }
	 //view person info
	 @RequestMapping("/persons/{id}")
	 public String show(@PathVariable Long id ,Model model) {
		 Person person=this.homeService.getPersonById(id);
		 if (person==null)
			 return "redirect:/persons/new";
		 System.out.println(person.getLicense());
	     model.addAttribute("person", person);
	     return "profilePage.jsp";
	 }





}
