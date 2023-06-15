package com.jnickle.demos.ToolRentals;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.jnickle.demos.ToolRentals.exceptions.InvalidPercentageException;
import com.jnickle.demos.ToolRentals.exceptions.InvalidRentalDayEntryException;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static HashMap<String, ChargeData> CHARGE_CHART = new HashMap<String, ChargeData>();
	private static HashMap<String, Tool> TOOL_CHART = new HashMap<String, Tool>();
	
    public static void main( String[] args )
    {            	
    	RentalAgreement rentalAgreement = createRentalAgreement(args);
    	
    	rentalAgreement.printRentalAgreement();        
    }
    
    public static RentalAgreement createRentalAgreement(String[] args) {
    	
    	initializeCharts();
    	
    	String toolCode = args[0];
    	Date checkoutDate = new Date(args[1]);
    	int rentalDays = Integer.parseInt(args[2]);
    	double discount = Double.parseDouble(args[3]);
    	
    	Tool currentTool = TOOL_CHART.get(toolCode);
    	
    	RentalAgreement rentalAgreement = new RentalAgreement(CHARGE_CHART, TOOL_CHART, currentTool, checkoutDate, rentalDays, discount);
    	
    	return rentalAgreement;
    }
    
    private static void initializeCharts() 
    {
    	ChargeData ladderCharge = new ChargeData(1.99,true,true,false);
        ChargeData chainsawCharge = new ChargeData(1.49, true,false,true);
        ChargeData jackhammerCharge = new ChargeData(2.99, true,false,false);
        
        CHARGE_CHART.put("Ladder", ladderCharge);
        CHARGE_CHART.put("Chainsaw", chainsawCharge);
        CHARGE_CHART.put("Jackhammer", jackhammerCharge);
        
        Tool chns = new Tool("CHNS","Chainsaw","Stihl");
        Tool ladw = new Tool("LADW","Ladder","Werner");
        Tool jakd = new Tool("JAKD", "Jackhammer","DeWalt");
        Tool jakr = new Tool("JAKR","Jackhammer","Ridgid");
        
        TOOL_CHART.put("CHNS", chns);
        TOOL_CHART.put("LADW", ladw);
        TOOL_CHART.put("JAKD", jakd);
        TOOL_CHART.put("JAKR", jakr);        
    }
    
}
