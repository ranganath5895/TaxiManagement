package com.taxi.management.helpers;

public class TripChargeCalc {

	public static int tripFareCaluculation(int totalKms) {

		int totalFare = 0;

		int minFare = 50;

		if (totalKms > 20) {

			totalFare = minFare + ((totalKms - 20) * 8) + (10 * 5) + (3 * 5) + (1 * 5);
		} else if ((totalKms > 10) && (totalKms <= 20)) {
			totalFare = minFare + ((totalKms - 10) * 5) + (3 * 5) + (1 * 5);
		} else if ((totalKms > 5) && (totalKms <= 10)) {
			totalFare = minFare + ((totalKms - 5) * 3) + (1 * 5);
		} else if ((totalKms > 0) && (totalKms <= 5)) {
			totalFare = minFare + (1 * 5);
		} else {
			totalFare = 0;
		}

		return totalFare;
	}
}
