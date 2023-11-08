package com.examplejdbc.repository;
import com.examplejdbc.model.Mobile;
import java.util.ArrayList;

public interface MobileRepository {

	ArrayList<Mobile>  getMobiles();
	Mobile getMobileId(int mobileId);
	Mobile addMobile(Mobile mobile);
	Mobile updateMobile(int mobileId,Mobile mobile);
	void deleteMobile(int mobileId);
	
}


