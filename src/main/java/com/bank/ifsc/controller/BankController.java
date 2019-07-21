package com.bank.ifsc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ifsc.model.BankModel;
import com.bank.ifsc.repository.BankRepository;
import com.bank.utilities.Utility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@RestController
@RequestMapping("/api")
@Api(value="All India IFSC Code", description="Operations pertaining to Bank Data in REST API")
public class BankController {

	@Autowired
	private BankRepository bankrepository;
	
	@ApiOperation(value = "View a details of specific IFSC Code", response = List.class)
	@GetMapping("/bankdetail/{ifsc}")
	public ResponseEntity<?> getBank( @PathVariable (value = "ifsc") String ifsc ){
		
		List<BankModel> bankdata=bankrepository.findByIfsc(ifsc);
		
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success",bankdata.size(), bankdata));
	}
	
	
	@GetMapping("/bankbyname/{bankname}")
	public ResponseEntity<?> getByBank(@PathVariable (value = "bankname") String bankName){
		List<BankModel> bankdata=bankrepository.findByBank(bankName);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankdata.size(), bankdata));
	}
	
	@GetMapping("/allbank")
	public ResponseEntity<?> getAllBank(){
		List<String> bankName=bankrepository.findAllBank();
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankName.size(), bankName));
	}  
	
	@GetMapping("/state/{bankname}")
	public ResponseEntity<?> getStateByBank(@PathVariable (value = "bankname") String bankname){
		List<String> state=bankrepository.findState(bankname);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", state.size(), state));
	}
	
	@GetMapping("/district/{bankname}/{state}")
	public ResponseEntity<?> getDistrict(@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
	List<String> district=bankrepository.findDistrict(bankname,state);
	return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", district.size(), district));
	}
	
	@GetMapping("/branch/{bankname}/{state}/{district}")
	public ResponseEntity<?> getBranch(@PathVariable (value = "district") String district ,@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
	List<String> branch=bankrepository.findBranch(district,bankname,state);
	return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", branch.size(), branch));
	}
	@GetMapping("/ifsc/{bankname}/{state}/{district}/{branch}")
	public ResponseEntity<?> getIfsc(@PathVariable (value = "branch") String branch,@PathVariable (value = "district") String district ,@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
		List<BankModel> ifscdetails=bankrepository.findIfsc(bankname,state,district,branch);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", ifscdetails.size(), ifscdetails));
	}
	@GetMapping("/bankdetail/{bankname}/{branch}")
	public ResponseEntity<?> getBankByBranch(@PathVariable (value = "bankname") String bankname,@PathVariable (value = "branch") String branch){
		List<BankModel> bankdetail=bankrepository.findBankByBranch(bankname,branch);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankdetail.size(), bankdetail));
	}
	
	
	@ApiOperation(value = "View a details of all branches of specific bank in a city", response = List.class)
	@GetMapping("/branches/{bankname}/{city}")
	public ResponseEntity<?> getbranches(@PathVariable (value = "bankname") String bankname,@PathVariable (value = "city") String city,@RequestParam (value = "limit",required = false,defaultValue = "1000") Integer limit,@RequestParam (value = "offset",required = false,defaultValue = "0") Integer offset)
	{
		List<BankModel> bankdetail=bankrepository.findByCity(bankname,city,limit,offset);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankdetail.size(), bankdetail));
		
	}
}
