package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		gpspoints = new GPSPoint[n];

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		// TODO - START
		
		if(antall<gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
		}
		
		return inserted;
		

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation); 
		

		// TODO - START
		boolean inserted = false;
		if(insertGPS(gpspoint)) {
			inserted = true;
		}
		return inserted;
		
		

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START


		for (GPSPoint gpspoint : gpspoints) {
			System.out.println(gpspoint.toString());
		}

		

		// TODO - SLUTT
		
		 System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
