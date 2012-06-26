package com.promouit.misc.problems;

import com.promouit.dlist.impl.DLinkedList;

public class Track {
	
	public int findStartingStation(int[] distances, int[] fuel) {
		DLinkedList<StationDetails> dLinkedList = new DLinkedList<StationDetails>();
		StationDetails startingStation = null;
		for(int i = 0; i<distances.length; i++){
			StationDetails currentStation = new StationDetails(i, fuel[i] - distances[i]);
			if(startingStation!=null){
				if(currentStation.compareTo(startingStation)>0)
					startingStation = currentStation;
			}
			dLinkedList.insert(currentStation);
		}
		//StationDetails endStation = startingStation.get
		
		
		return startingStation.getStationIndex();

	}

	
	
	
	private class StationDetails implements Comparable<StationDetails>{
		private int stationIndex;
		private int fuel;
		public StationDetails(int stationIndex, int fuel) {
			this.stationIndex = stationIndex;
			this.fuel = fuel;
		}
		public int getFuel() {
			return fuel;
		}
		public int getStationIndex() {
			return stationIndex;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj == null)
				return false;
			if(!(obj instanceof StationDetails))
				return false;
			StationDetails another = (StationDetails) obj;
			return this.stationIndex == another.stationIndex && this.fuel == another.fuel;
		}
		public int compareTo(StationDetails o) {
			return this.fuel - o.fuel;
		}
	}
}
