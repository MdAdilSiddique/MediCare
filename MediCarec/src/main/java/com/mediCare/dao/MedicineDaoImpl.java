package com.mediCare.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mediCare.entity.Medicine;

@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public String mAdd(Medicine medi) {
		Medicine midi=mSearch(medi.getmID());
		if(midi==null)
		{
			int rowCount=JdbcTemplate.update("insert into MedicineRecord values('"+medi.getmID()+"','"+medi.getmName()+"','"+medi.getmCount()+"','"+medi.getmDescription()+"')");
			if(rowCount==1)
			{
				return "success";
			}else {
				return "existed.jsp";
			}
		}else
		{
			return "existed.jsp";
		}
	}
	

	@Override
	public String mDelete(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine mSearch(int mid) {
		Medicine md;
		List<Medicine> mediList=JdbcTemplate.query("select * from MedicineRecord where ID='"+mid+"'", (rs,rowCount) -> {
			Medicine m=new Medicine();
			m.setmID(Integer.parseInt(rs.getString("ID")));
			m.setmName(rs.getString("NAME"));
			m.setmCount(Integer.parseInt(rs.getString("COUNT")));
			m.setmDescription(rs.getString("DESCREPTION"));
			return m;
		});
		if(mediList.isEmpty()==true)
		{
			
			md=null;
		}else {
			
			return md=mediList.get(0);
		}
		return md;
	}


}
