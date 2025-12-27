package com.comcast.crm.generic.webDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomnumber() {
		Random random = new Random();
		int Randomvalue = random.nextInt(1000);
		return Randomvalue;
	}
	public String getSystemDateYYYYDDMM() {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;
	}
	public String getRquireDateyyyy(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String requireDate = sim.format(cal.getTime());
		return requireDate;
	}
}
