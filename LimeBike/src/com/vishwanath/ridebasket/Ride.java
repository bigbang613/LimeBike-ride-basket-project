package com.vishwanath.ridebasket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Ride {
	private Date start, end;
	private HashMap<String, Integer> basketItems;
	private SimpleDateFormat format;

	public Ride(String start, String end, int apples, int brownies, int carrots, int diamonds) {

		format = new SimpleDateFormat("hh:mm");
		basketItems = new HashMap<>();

		try {
			this.start = format.parse(start); // assuming start time and end time in HH:MM format
			this.end = format.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		basketItems.put("apples", apples);
		basketItems.put("brownies", brownies);
		basketItems.put("carrots", carrots);
		basketItems.put("diamonds", diamonds);

	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public HashMap<String, Integer> getBasketItems() {
		return basketItems;
	}

}
