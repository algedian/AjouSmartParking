package smartparking;

import java.util.Comparator;

public class ParkingLotComparator implements Comparator<ParkingLot>{

	@Override
	public int compare(ParkingLot o1, ParkingLot o2) {
		Integer d1 = o1.getDistance();
		Integer d2 = o2.getDistance();
		return d1.compareTo(d2);
	}

}
