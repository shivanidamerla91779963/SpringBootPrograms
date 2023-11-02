package com.example21.service;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example21.model.Mobile;
import com.example21.repository.MobileRepository;

public class MobileService implements MobileRepository 
{
	HashMap<Integer,Mobile> hmap=new HashMap<>();
	int mid=4;
	public MobileService()
	{
		Mobile m1=new Mobile(1,"realme","realme.jpg");
		Mobile m2=new Mobile(2,"iphone","iphone.jpg");
		Mobile m3=new Mobile(3,"vivo","vivo.jpg");
		hmap.put(m1.getId(),m1);
		hmap.put(m2.getId(),m2);
		hmap.put(m3.getId(),m3);
		
	}
	
	@Override
	public ArrayList<Mobile> getMobiles() {
		// TODO Auto-generated method stub
		ArrayList<Mobile> mobiles=new ArrayList<>(hmap.values());
		return mobiles;
	}

	@Override
	public Mobile getMobileId(int mobileId) {
		// TODO Auto-generated method stub
		Mobile mobile=hmap.get(mobileId);
		if(mobile==null)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return mobile;
	}

	@Override
	public Mobile addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		mobile.setId(mid);
		hmap.put(mid, mobile);
		mid=mid+1;
		return mobile;
	}

}
