package com.jnickle.demos.ToolRentals;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.jnickle.demos.ToolRentals.exceptions.InvalidPercentageException;
import com.jnickle.demos.ToolRentals.exceptions.InvalidRentalDayEntryException;

public class RentalAgreement {

	private Tool tool;
	private int rentalDays;
	private Date checkoutDate;
	private Date dueDate;
	private double dailyCharge;
	private int chargeDays;
	private double initialCharge;
	private double discountPercent;
	private double discountAmount;
	private double finalCharge;
	
	private HashMap<String, ChargeData> chargeChart;
	private HashMap<String, Tool> toolChart;
	
	private Calendar calendar;
	
	public RentalAgreement(HashMap<String, ChargeData> chargeChart,  HashMap<String, Tool> toolChart, Tool tool, Date checkoutDate, int rentalDays, double discountPercent) 
	{
		
		this.tool = tool;
		this.checkoutDate = checkoutDate;
		this.rentalDays = rentalDays;
		this.discountPercent = discountPercent;
		
		this.chargeChart = chargeChart;
		this.toolChart = toolChart;
		
		this.calendar = Calendar.getInstance();
		this.calendar.setTime(this.checkoutDate);
	}
	
	public void finalizeRentalAgreement() throws InvalidPercentageException, InvalidRentalDayEntryException {
		
		if(this.discountPercent < 0 || this.discountPercent > 100) {
			throw new InvalidPercentageException("Discount percentage entered is invalid. Please enter a value between 0 and 100 percent.");
		}
		
		if(this.rentalDays <= 0) {
			throw new InvalidRentalDayEntryException("Rental day entry is invalid. Please enter a value greater than 0.");
		}
		
		ChargeData chargeData = this.chargeChart.get(this.tool.getType());
		this.dailyCharge = chargeData.getDailyCharge();
		boolean weekdayCharge = chargeData.isWeekdayCharge();
		boolean weekendCharge = chargeData.isWeekendCharge();
		boolean holidayCharge = chargeData.isHolidayCharge();
		
		Date today = new Date();		
		
		for(int i = 1; i <= this.rentalDays; i++) {
			if(holidayCharge && isHoliday(today)) {
				this.finalCharge += this.dailyCharge;
				this.chargeDays++;
			}
			else if(weekendCharge && !isWeekday(today)) {
				this.finalCharge += this.dailyCharge;
				this.chargeDays++;
			}
			else if(weekdayCharge && isWeekday(today)) {
				this.finalCharge += this.dailyCharge;
				this.chargeDays++;
			}
		}
		
		this.calendar.add(Calendar.DATE, this.rentalDays);
		this.dueDate = this.calendar.getTime();
		
		this.initialCharge = this.finalCharge;
		this.discountAmount = this.finalCharge * (this.discountPercent * 0.01);
		this.finalCharge -= this.discountAmount;		
	}
	
	public boolean isHoliday(Date date) {
		
		if(isIndependenceDay(date) || isLaborDay(date)) {
			return true;
		}
		return false;		
	}
	
	@SuppressWarnings("deprecation")
	public boolean isIndependenceDay(Date date) {
		
		if(date.getDate() == 7) {
			if(this.calendar.get(Calendar.DAY_OF_MONTH) == 4 && date.getDay() !=1 && date.getDay() != 6) {
				return true;
			}
			else if(this.calendar.get(Calendar.DAY_OF_MONTH)== 5 && date.getDay() == 2) {
				return true;
			}
			else if(this.calendar.get(Calendar.DAY_OF_MONTH) == 3 && date.getDay() == 5) {
				return true;
			}			
		}
		return false;		
	}
	
	@SuppressWarnings("deprecation")
	private boolean isLaborDay(Date date) {
		
		if(date.getDay() == 2 && this.calendar.get(Calendar.DAY_OF_MONTH) <= 7) {
			return true;
		}
		return false;		
	}
	
	@SuppressWarnings("deprecation")
	private boolean isWeekday(Date date) {
		switch(date.getDay()) {
			case 1:
				return true;
			case 2:
				return true;
			case 3:
				return true;
			case 4:
				return true;
			case 5:
				return true;
			default:
				return false;
			
		}
	}
	
	

	@Override
	public String toString() {		
		
		return "Tool code: " + tool.getCode() + "\n"
				+ "Tool type: " + tool.getType() + "\n"
				+ "Tool brand: " + tool.getBrand() + "\n"
				+ "Rental days:" + rentalDays + "\n"
				+ "Check out date:" + checkoutDate + "\n"
				+ "Due date:" + dueDate + "\n"
				+ "Daily rental charge:" + dailyCharge + "\n"
				+ "Charge days:" + chargeDays + "\n"
				+ "Pre-discount charge:" + String.format("%.2f", this.initialCharge) + "\n"
				+ "Discount percent:" + discountPercent + "\n"
				+ "Discount amount:" + String.format("%.2f", this.discountAmount) + "\n"
				+ "Final charge:" + String.format("%.2f", this.finalCharge);
	}
	
	public void printRentalAgreement() {
		System.out.println(this.toString());
	}

	public Tool getTool() {
		return tool;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public double getDailyCharge() {
		return dailyCharge;
	}

	public int getChargeDays() {
		return chargeDays;
	}

	public double getInitialCharge() {
		return initialCharge;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getFinalCharge() {
		return finalCharge;
	}

	public Calendar getCalendar() {
		return calendar;
	}
}
