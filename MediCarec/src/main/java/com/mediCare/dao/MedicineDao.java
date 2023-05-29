package com.mediCare.dao;

import com.mediCare.entity.Medicine;

public interface MedicineDao {
	
	public String mAdd(Medicine medi);
	public String mDelete(int mid);
	public Medicine mSearch(int mid);

}
