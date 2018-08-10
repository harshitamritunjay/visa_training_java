package com.visa.prj.client;

//import com.visa.prj.dao.*   bad practice. checkstyle will not allow
import com.visa.prj.dao.MobileDao;
import com.visa.prj.dao.MobileDaoFileImpl;
import com.visa.prj.entity.Mobile;

public class MobileClient {

	public static void main(String[] args) {
		Mobile mobile = new Mobile(2, "Oneplus6T", 70000.00, "4G");
		MobileDao mobileDao = new MobileDaoFileImpl();// can switch between db and file as and when required
		mobileDao.addMobile(mobile);
		// we can have a loose coupling between client and implementation.
	}

}
