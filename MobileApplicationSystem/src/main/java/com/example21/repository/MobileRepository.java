package com.example21.repository;
import com.example21.model.Mobile;
import java.util.ArrayList;


public interface MobileRepository 
{
	ArrayList<Mobile>  getMobiles();
	Mobile getMobileId(int mobileId);
	Mobile addMobile(Mobile mobile);
}
