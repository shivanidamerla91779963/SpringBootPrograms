package com.exampleHibernate.repository;



import java.util.ArrayList;
import com.exampleHibernate.model.Mobile;

public interface MobileRepository
{
	ArrayList<Mobile> getMobiles();
	Mobile getMobileById(int mobileId);
	Mobile addMobile(Mobile mobile);
	Mobile updateMobile(int mobileId, Mobile mobile);
	void deleteMobile(int mobileId);
		
}

