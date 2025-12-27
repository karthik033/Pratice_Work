package com.camcast.crm.ListnerUtility;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.camcast.crm.ListnerUtility.ListnerImpClass.class)
public class InvoiceTest extends BaseClass {

	@Test
	public void createContacttest() {
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "");
		System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
		System.out.println("step_4");
	}

	@Test
	public void createOrgtest() {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, false);
		System.out.println("step_1");
		System.out.println("step_2");
		System.out.println("step_3");
		System.out.println("step_4");
	}
}
