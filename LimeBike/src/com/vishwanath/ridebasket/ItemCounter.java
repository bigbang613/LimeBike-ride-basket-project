package com.vishwanath.ridebasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ItemCounter {

	private ArrayList<Date> intervals;
	private ArrayList<Ride> rideList;
	private ArrayList<StoreRiders> storeRiders;
	private StoreRiders mStoreRiders;

	public ItemCounter() {
		storeRiders = new ArrayList<>();
		rideList = new ArrayList<>();
		intervals = new ArrayList<>();
	}

	public static void main(String[] args) {

		// creating ride objects given in the problem
		Ride ride1 = new Ride("07:00", "07:30", 2, 1, 0, 0);
		Ride ride2 = new Ride("07:10", "07:55", 1, 0, 3, 0);
		Ride ride3 = new Ride("07:20", "07:45", 1, 2, 0, 4);

		ItemCounter items = new ItemCounter();
		items.process_ride(ride1);
		items.process_ride(ride2);
		items.process_ride(ride3);

		items.print_items_per_interval();

	}

	private void process_ride(Ride ride) {

		// adding all ride objects
		rideList.add(ride);

		// adding all start times and end times for each ride
		intervals.add(ride.getStart());
		intervals.add(ride.getEnd());

		// sorting all start and end times to iterate loop
		Collections.sort(intervals);

		// once all the ride objects are saved, we'll call this (3 ride objects -> 6
		// time intervals)
		if (intervals.size() == 6) {
			for (int i = 0; i < intervals.size() - 1; i++) {
				storeRiders(intervals.get(i), intervals.get(i + 1), findRiders(intervals.get(i), intervals.get(i + 1)));
			}
		}
	}

	// for all intervals in timeIntervals, fetch details from storeRiders to display
	private void print_items_per_interval() {
		int apples = 0, brownies = 0, carrots = 0, diamonds = 0;
		for (int i = 0; i < storeRiders.size(); i++) {
			apples = findApples(storeRiders.get(i).getRiders());
			brownies = findBrownies(storeRiders.get(i).getRiders());
			carrots = findCarrots(storeRiders.get(i).getRiders());
			diamonds = findDiamonds(storeRiders.get(i).getRiders());

			String output = storeRiders.get(i).getStart() + " - " + storeRiders.get(i).getEnd() + " -> " + apples
					+ " apples" + ", " + brownies + " brownies" + ", " + carrots + " carrots" + ", " + diamonds
					+ " diamonds";

			System.out.println(output);
		}
	}

	// finding all ride objects in a given interval
	private ArrayList<Ride> findRiders(Date start, Date end) {
		ArrayList<Ride> temp = new ArrayList<>();
		for (Ride r : rideList) {
			if ((r.getStart().equals(start) || r.getStart().before(start))
					&& (r.getEnd().equals(end) || r.getEnd().after(end))) {
				temp.add(r);
			}
		}
		return temp;
	}

	// storing all ride objects with start time and end time to print later
	private void storeRiders(Date start, Date end, ArrayList<Ride> riders) {
		mStoreRiders = new StoreRiders(start, end, riders);
		storeRiders.add(mStoreRiders);
	}

	// count of apples
	private int findApples(ArrayList<Ride> array) {
		int apples = 0;
		int size = array.size();
		for (int i = 0; i < size; i++)
			apples += array.get(i).getBasketItems().get("apples");
		return apples;

	}

	// count of brownies
	private int findBrownies(ArrayList<Ride> array) {
		int brownies = 0;
		int size = array.size();
		for (int i = 0; i < size; i++)
			brownies += array.get(i).getBasketItems().get("brownies");
		return brownies;

	}

	// count of carrots
	private int findCarrots(ArrayList<Ride> array) {
		int carrots = 0;
		int size = array.size();
		for (int i = 0; i < size; i++)
			carrots += array.get(i).getBasketItems().get("carrots");
		return carrots;

	}

	// count of diamonds
	private int findDiamonds(ArrayList<Ride> array) {
		int diamonds = 0;
		int size = array.size();
		for (int i = 0; i < size; i++)
			diamonds += array.get(i).getBasketItems().get("diamonds");
		return diamonds;

	}

}
