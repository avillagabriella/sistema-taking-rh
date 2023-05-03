package br.com.taking.ProjetoGestaoRH.model;

import java.util.List;
import java.util.Set;

import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name ="candidato")
public class Candidato {
	
	
	@Id 
	@Column (name="candidato_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidato_id;
	
	@Column (name= "firstName")
	private String firstName;
	
	@Column (name= "lastName")
	private String lastName;
	
	@Column (name= "email")
	private String email;
	
	@Column (name= "birthdate")
	private Date birthdate;
	
	@Column (name= "identificationDocument")	
	private String identificationDocument;
		
	@Column (name= "linkedinProfileUrl")
	private String linkedinProfileUrl;
	
	@Column (name= "mobileNumber")
	private String mobileNumber;
	
	@Column (name= "phoneNumber")
	private String phoneNumber;
	
	@Column (name= "addressZipCode")
	private String addressZipCode;
	
	@Column (name= "addressNumber")
	private String addressNumber;
	
	@Column (name= "addressStreet")
	private String addressStreet;
	
	@ManyToOne
	@JoinColumn(name= "gender_id")
	private Gender gender;

	@ManyToOne
	@JoinColumn(name= "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name= "countryOfOrigin_id")
	private Country_Origin Country_Origin;
	
	@OneToMany (mappedBy = "candidato_id", fetch = FetchType. EAGER, cascade = {CascadeType.ALL})
	private Set<Academic_qualification> academicQualification_id;
	
	@OneToMany (mappedBy = "candidato_id", fetch = FetchType. EAGER, cascade = {CascadeType.ALL})
	private Set<WorkExperience> workExperience_id;
	
	@OneToMany (mappedBy = "languagesskill", fetch = FetchType. EAGER, cascade = {CascadeType.ALL})
	private Set<Languages_skill> languagesskill_id;
	
	@ManyToMany
	@JoinTable(
			name = "candidato_areas",
			joinColumns = @JoinColumn(name = "candidato_id"),
			inverseJoinColumns = @JoinColumn(name = "areaInterest_id")
			)
	
	private List<Area_interest> areaInterest;
	
	
	public List<Area_interest> getArea_interest(){
		return areaInterest;
	}
	
	@ManyToMany
	@JoinTable(
			name = "candidatoDisability",
			joinColumns = @JoinColumn(name = "candidato_id"),
			inverseJoinColumns = @JoinColumn(name = "disability_id")
			)
	
	private List<Disability_type> disability;


	public int getCandidato_id() {
		return candidato_id;
	}

	public void setCandidato_id(int candidato_id) {
		this.candidato_id = candidato_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getIdentificationDocument() {
		return identificationDocument;
	}

	public void setIdentificationDocument(String identificationDocument) {
		this.identificationDocument = identificationDocument;
	}

	public String getLinkedinProfileUrl() {
		return linkedinProfileUrl;
	}

	public void setLinkedinProfileUrl(String linkedinProfileUrl) {
		this.linkedinProfileUrl = linkedinProfileUrl;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country_Origin getCountry_Origin() {
		return Country_Origin;
	}

	public void setCountry_Origin(Country_Origin country_Origin) {
		Country_Origin = country_Origin;
	}

	public Set<Academic_qualification> getAcademicQualification_id() {
		return academicQualification_id;
	}

	public void setAcademicQualification_id(Set<Academic_qualification> academicQualification_id) {
		this.academicQualification_id = academicQualification_id;
	}

	public Set<WorkExperience> getWorkExperience_id() {
		return workExperience_id;
	}

	public void setWorkExperience_id(Set<WorkExperience> workExperience_id) {
		this.workExperience_id = workExperience_id;
	}

	public Set<Languages_skill> getLanguagesskill_id() {
		return languagesskill_id;
	}

	public void setLanguagesskill_id(Set<Languages_skill> languagesskill_id) {
		this.languagesskill_id = languagesskill_id;
	}

	public List<Area_interest> getAreaInterest() {
		return areaInterest;
	}

	public void setAreaInterest(List<Area_interest> areaInterest) {
		this.areaInterest = areaInterest;
	}

	public List<Disability_type> getDisability() {
		return disability;
	}

	public void setDisability(List<Disability_type> disability) {
		this.disability = disability;
	}




	
	

}