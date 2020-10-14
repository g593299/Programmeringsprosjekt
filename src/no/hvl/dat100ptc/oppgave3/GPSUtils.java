package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		// TODO - START

		double min = da[0];
		for (double i : da) {
			if (i < min) {
				min = i;
			}
		}
		return min;
		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] lat = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			lat[i] = gpspoints[i].getLatitude();
		}
		return lat;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longi = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longi[i] = gpspoints[i].getLongitude();
		}
		return longi;

		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1 = gpspoint1.getLatitude(), longitude1 = gpspoint1.getLongitude(),
				latitude2 = gpspoint2.getLatitude(), longitude2 = gpspoint2.getLongitude();

		// TODO - START
		double dLat = Math.toRadians(latitude2 - latitude1);
		double dLon = Math.toRadians(longitude2 - longitude1);

		latitude1 = Math.toRadians(latitude1);
		latitude2 = Math.toRadians(latitude2);

		double a = Math.pow(Math.sin(dLat / 2), 2)
				+ Math.pow(Math.sin(dLon / 2), 2) * Math.cos(latitude1) * Math.cos(latitude2);

		double c = 2 * Math.asin(Math.sqrt(a));
		d = R * c;
		return d;
	}

	// TODO - SLUTT

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);

		speed = 3.6 * distance / secs;
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START

		int hrs = secs / 3600;
		int min = secs % 3600 / 60;
		int sec = secs % 60;

		return String.format("  %02d:%02d:%02d", hrs, min, sec);

		// TODO - SLUTT

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";

		// TODO - START

		double factor = Math.pow(10, 2);
		d = d * factor;
		double tmp = Math.round(d);
		double rounded = tmp / factor;

		str += rounded;

		while (str.length() < TEXTWIDTH) {
			str = " " + str;
		}

		return str;

		// TODO - SLUTT

	}
}
