package com.jnickle.demos.ToolRentals;

public class ChargeData {
	
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;
	
	public ChargeData(double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	public double getDailyCharge() {
		return dailyCharge;
	}

	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}

	public boolean isWeekendCharge() {
		return weekendCharge;
	}

	public boolean isHolidayCharge() {
		return holidayCharge;
	}

}
