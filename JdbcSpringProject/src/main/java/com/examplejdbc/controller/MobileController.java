package com.examplejdbc.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examplejdbc.model.Mobile;
import com.examplejdbc.service.MobileService;

@RestController
public class MobileController {

MobileService mobileService=new MobileService();
	
	@GetMapping("/mobiles")
	public ArrayList<Mobile> getMobiles()
	{
		return mobileService.getMobiles();
	}
	
	@GetMapping("mobiles/{mobileId}")
	public Mobile getMobileId(@PathVariable("mobileId")int mobileId)
	{
		return mobileService.getMobileId(mobileId);
	}
	
	@PostMapping("/mobiles/addnewmobile")
	public Mobile addMobile(@RequestBody Mobile mobile)
	{
		return mobileService.addMobile(mobile);
	}
	
	@PutMapping("mobiles/{mobileId}")
	public Mobile updateMobile(@PathVariable("mobileId")int mobileId,@RequestBody Mobile mobile)
	{
				
		return mobileService.updateMobile(mobileId, mobile);
		
	}
	
	@DeleteMapping("mobiles/{mobileId}")
	public void deleteMapping(@PathVariable("mobileId")int mobileId)
	{
		mobileService.deleteMobile(mobileId);
	}

}

