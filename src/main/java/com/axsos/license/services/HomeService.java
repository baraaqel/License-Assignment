package com.axsos.license.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.axsos.license.models.License;
import com.axsos.license.models.Person;
import com.axsos.license.repositories.LicenseRepository;
import com.axsos.license.repositories.PersonRepository;
import com.fasterxml.jackson.annotation.JacksonInject.Value;


@Service
public class HomeService {
	 private final PersonRepository personRepository;
	 private final LicenseRepository licenseRepository;
	 public HomeService(PersonRepository personRepository,LicenseRepository licenseRepository) {
		 this.personRepository=personRepository;
		 this.licenseRepository=licenseRepository;
	}
		public Person createPerson(Person person) {
			return this.personRepository.save(person);
		}
		public License createLicense(License license) {
			license.setNumber(Integer.valueOf((int) this.licenseRepository.count())+1);
			System.out.println((int) this.licenseRepository.count());
			return this.licenseRepository.save(license);
		}
		public Person getPersonById(Long id) {
			Optional<Person> person= this.personRepository.findById(id);
			if(person.isPresent())
				return person.get();
			return null;
		}	
		public List<Person> allPersons(){
			return this.personRepository.findAll();
		}
		public List<Person> nonLicensedPersons(){
			return this.personRepository.findAll().stream().filter(person -> person.getLicense() ==null).collect(Collectors.toList());
		}
		public boolean isPersonHasLicense(Person person) {
			System.out.println(this.nonLicensedPersons().indexOf(person));
			if (this.nonLicensedPersons().indexOf(person)>=0)
				return false;
			return true;
		}
	
}
