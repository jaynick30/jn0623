package com.jnickle.demos.ToolRentals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.jnickle.demos.ToolRentals.exceptions.InvalidPercentageException;
import com.jnickle.demos.ToolRentals.exceptions.InvalidRentalDayEntryException;

public class RequriedJUnitTests {
	
	@Test
	public void mainTest1() {
		
		String[] args = new String[4];
		args[0] = "JAKR";
		args[1] = "09/03/15";
		args[2] = "5";
		args[3] = "101.00";
		
		Date testDate = new Date("09/03/15");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		try {
			rentalAgreement.finalizeRentalAgreement();
		} catch (InvalidPercentageException e) {
			e.printStackTrace();
			Assert.assertEquals("Discount percentage entered is invalid. Please enter a value between 0 and 100 percent.", e.getMessage());
		} catch (InvalidRentalDayEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			Assert.assertEquals("JAKR", rentalAgreement.getTool().getCode());
			Assert.assertEquals("Jackhammer", rentalAgreement.getTool().getType());
			Assert.assertEquals("Ridgid", rentalAgreement.getTool().getBrand());
			Assert.assertEquals(5, rentalAgreement.getRentalDays());
			Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
			Assert.assertEquals(null, rentalAgreement.getDueDate());
			Assert.assertEquals(0.0, rentalAgreement.getDailyCharge(), 0.0);
			Assert.assertEquals(0, rentalAgreement.getChargeDays());
			Assert.assertEquals(0.00, rentalAgreement.getInitialCharge(), 0.0);
			Assert.assertEquals(101.00, rentalAgreement.getDiscountPercent(), 0.0);
			Assert.assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0.0);
			Assert.assertEquals(0.00, rentalAgreement.getFinalCharge(), 0.0);
		}
	}
	
	@Test
	public void mainTest2() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		String[] args = new String[4];
		args[0] = "LADW";
		args[1] = "07/02/20";
		args[2] = "3";
		args[3] = "10.00";
		
		Date testDate = new Date("07/02/20");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		rentalAgreement.finalizeRentalAgreement();
		rentalAgreement.printRentalAgreement();
		
		Assert.assertEquals("LADW", rentalAgreement.getTool().getCode());
		Assert.assertEquals("Ladder", rentalAgreement.getTool().getType());
		Assert.assertEquals("Werner", rentalAgreement.getTool().getBrand());
		Assert.assertEquals(3, rentalAgreement.getRentalDays());
		Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
		
		testDate.setDate(testDate.getDate() + 3);
		Assert.assertEquals(testDate, rentalAgreement.getDueDate());
		Assert.assertEquals(1.99, rentalAgreement.getDailyCharge(), 0.01);
		Assert.assertEquals(3, rentalAgreement.getChargeDays());
		Assert.assertEquals(5.97, rentalAgreement.getInitialCharge(), 0.01);
		Assert.assertEquals(10.00, rentalAgreement.getDiscountPercent(), 0.01);
		Assert.assertEquals(0.60, rentalAgreement.getDiscountAmount(), 0.01);
		Assert.assertEquals(5.37, rentalAgreement.getFinalCharge(), 0.01);
	}
	
	@Test
	public void mainTest3() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		String[] args = new String[4];
		args[0] = "CHNS";
		args[1] = "07/02/15";
		args[2] = "5";
		args[3] = "25.00";
		
		Date testDate = new Date("07/02/15");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		rentalAgreement.finalizeRentalAgreement();
		rentalAgreement.printRentalAgreement();
		
		Assert.assertEquals("CHNS", rentalAgreement.getTool().getCode());
		Assert.assertEquals("Chainsaw", rentalAgreement.getTool().getType());
		Assert.assertEquals("Stihl", rentalAgreement.getTool().getBrand());
		Assert.assertEquals(5, rentalAgreement.getRentalDays());
		Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
		
		testDate.setDate(testDate.getDate() + 5);
		Assert.assertEquals(testDate, rentalAgreement.getDueDate());
		Assert.assertEquals(1.49, rentalAgreement.getDailyCharge(), 0.01);
		Assert.assertEquals(5, rentalAgreement.getChargeDays());
		Assert.assertEquals(7.45, rentalAgreement.getInitialCharge(), 0.01);
		Assert.assertEquals(25.00, rentalAgreement.getDiscountPercent(), 0.01);
		Assert.assertEquals(1.86, rentalAgreement.getDiscountAmount(), 0.01);
		Assert.assertEquals(5.59, rentalAgreement.getFinalCharge(), 0.01);
	}
	
	@Test
	public void mainTest4() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		String[] args = new String[4];
		args[0] = "JAKD";
		args[1] = "09/03/15";
		args[2] = "6";
		args[3] = "0.00";
		
		Date testDate = new Date("09/03/15");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		rentalAgreement.finalizeRentalAgreement();
		rentalAgreement.printRentalAgreement();
		
		Assert.assertEquals("JAKD", rentalAgreement.getTool().getCode());
		Assert.assertEquals("Jackhammer", rentalAgreement.getTool().getType());
		Assert.assertEquals("DeWalt", rentalAgreement.getTool().getBrand());
		Assert.assertEquals(6, rentalAgreement.getRentalDays());
		Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
		
		testDate.setDate(testDate.getDate() + 6);
		Assert.assertEquals(testDate, rentalAgreement.getDueDate());
		Assert.assertEquals(2.99, rentalAgreement.getDailyCharge(), 0.01);
		Assert.assertEquals(6, rentalAgreement.getChargeDays());
		Assert.assertEquals(17.94, rentalAgreement.getInitialCharge(), 0.01);
		Assert.assertEquals(0.00, rentalAgreement.getDiscountPercent(), 0.01);
		Assert.assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0.01);
		Assert.assertEquals(17.94, rentalAgreement.getFinalCharge(), 0.01);
	}
	
	@Test
	public void mainTest5() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		String[] args = new String[4];
		args[0] = "JAKR";
		args[1] = "07/02/15";
		args[2] = "9";
		args[3] = "0.00";
		
		Date testDate = new Date("07/02/15");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		rentalAgreement.finalizeRentalAgreement();
		rentalAgreement.printRentalAgreement();
		
		Assert.assertEquals("JAKR", rentalAgreement.getTool().getCode());
		Assert.assertEquals("Jackhammer", rentalAgreement.getTool().getType());
		Assert.assertEquals("Ridgid", rentalAgreement.getTool().getBrand());
		Assert.assertEquals(9, rentalAgreement.getRentalDays());
		Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
		
		testDate.setDate(testDate.getDate() + 9);
		Assert.assertEquals(testDate, rentalAgreement.getDueDate());
		Assert.assertEquals(2.99, rentalAgreement.getDailyCharge(), 0.01);
		Assert.assertEquals(9, rentalAgreement.getChargeDays());
		Assert.assertEquals(26.91, rentalAgreement.getInitialCharge(), 0.01);
		Assert.assertEquals(0.00, rentalAgreement.getDiscountPercent(), 0.01);
		Assert.assertEquals(0.00, rentalAgreement.getDiscountAmount(), 0.01);
		Assert.assertEquals(26.91, rentalAgreement.getFinalCharge(), 0.01);
	}
	
	@Test
	public void mainTest6() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		String[] args = new String[4];
		args[0] = "JAKR";
		args[1] = "07/02/20";
		args[2] = "4";
		args[3] = "50.00";
		
		Date testDate = new Date("07/02/20");
		
		RentalAgreement rentalAgreement = App.createRentalAgreement(args);
		rentalAgreement.finalizeRentalAgreement();
		rentalAgreement.printRentalAgreement();
		
		Assert.assertEquals("JAKR", rentalAgreement.getTool().getCode());
		Assert.assertEquals("Jackhammer", rentalAgreement.getTool().getType());
		Assert.assertEquals("Ridgid", rentalAgreement.getTool().getBrand());
		Assert.assertEquals(4, rentalAgreement.getRentalDays());
		Assert.assertEquals(testDate, rentalAgreement.getCheckoutDate());
		
		testDate.setDate(testDate.getDate() + 4);
		Assert.assertEquals(testDate, rentalAgreement.getDueDate());
		Assert.assertEquals(2.99, rentalAgreement.getDailyCharge(), 0.01);
		Assert.assertEquals(4, rentalAgreement.getChargeDays());
		Assert.assertEquals(11.96, rentalAgreement.getInitialCharge(), 0.01);
		Assert.assertEquals(50.00, rentalAgreement.getDiscountPercent(), 0.01);
		Assert.assertEquals(5.98, rentalAgreement.getDiscountAmount(), 0.01);
		Assert.assertEquals(5.98, rentalAgreement.getFinalCharge(), 0.01);
	}

}
