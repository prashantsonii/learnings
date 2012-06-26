package com.promouit.misc.problems;

import com.promouit.dlist.domain.Node;
import com.promouit.dlist.impl.CircularDLinkedList;

public class Track {
	
	public int findStartingStation(int[] distances, int[] fuel) {
		CircularDLinkedList<StationDetails> dLinkedList = new CircularDLinkedList<StationDetails>();
		Node<StationDetails> startingStation = null;
		for(int i = 0; i<distances.length; i++){
			Node<StationDetails> currentStation = dLinkedList.insertAndReturnNode(new StationDetails(i, fuel[i] - distances[i]));
			if(startingStation!=null){
				if(currentStation.getData().compareTo(startingStation.getData())>0)
					startingStation = currentStation;
			}else{
				startingStation = currentStation;
			}
		}

		Node<StationDetails> endStation = startingStation.getNext();
		int sum = startingStation.getData().getFuel();
		while(startingStation != endStation){
			if(sum < 0){
				startingStation= startingStation.getPrevious();
				sum+=startingStation.getData().getFuel();
			}else{
				sum+=endStation.getData().getFuel();
				endStation = endStation.getNext();
			}
		}
		return startingStation.getData().getStationIndex();

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
