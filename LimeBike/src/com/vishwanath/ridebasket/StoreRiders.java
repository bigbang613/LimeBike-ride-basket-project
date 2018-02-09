package com.vishwanath.ridebasket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class StoreRiders {
	private String startTime, endTime;
	private ArrayList<Ride> riders;
	private SimpleDateFormat format;

	public StoreRiders(Date start, Date end, ArrayList<Ride> riders) {
		format = new SimpleDateFormat("hh:mm");
		this.startTime = format.format(start);
		this.endTime = format.format(end);
		this.riders = riders;
	}

	public String getStart() {
		return startTime;
	}

	public String getEnd() {
		return endTime;
	}

	public ArrayList<Ride> getRiders() {
		return riders;
	}

}
