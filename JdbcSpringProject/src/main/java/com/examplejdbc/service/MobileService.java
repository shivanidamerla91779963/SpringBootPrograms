package com.examplejdbc.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.examplejdbc.model.Mobile;
import com.examplejdbc.repository.MobileRepository;
import com.examplejdbc.model.MobileRowMapper;
@Service
public class MobileService implements MobileRepository
{
	
	@Autowired
	public JdbcTemplate db;
	@Override
	public ArrayList<Mobile> getMobiles()
	{
		List<Mobile> mobileList=db.query("select * from mobile", new MobileRowMapper());
		ArrayList<Mobile> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}
	
	@Override
	public Mobile addMobile(Mobile mobile)
	{
		db.update("insert into mobile(name,image) values(?,?)",mobile.getName(),mobile.getImage());
		
		Mobile newMobile=db.queryForObject("select * from mobile where name=? and image=?",new MobileRowMapper(),mobile.getName(),mobile.getImage());	
		return newMobile;
	}
	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile) {
		
		if(mobile.getName()!=null)
		{
			db.update("update mobile set name=? where id=?",mobile.getName(),mobileId);
		}
		if(mobile.getImage()!=null)
		{
			db.update("update mobile set image=? where id=?",mobile.getImage(),mobileId);
		}
		return getMobileId(mobileId);
		
	}
	@Override
	public void deleteMobile(int mobileId)
	{
		db.update("delete from mobile where id =?",mobileId);
		
	}
	@Override
	public Mobile getMobileId(int mobileId) {
		// TODO Auto-generated method stub
		try
		{
		Mobile mobile=db.queryForObject("select * from mobile where id=?",new MobileRowMapper(),mobileId);
		return mobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
