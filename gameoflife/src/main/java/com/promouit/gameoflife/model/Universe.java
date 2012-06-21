package com.promouit.gameoflife.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.promouit.gameoflife.model.Cell.CellBuilder;
import com.promouit.gameoflife.processor.CellLifeCycler;
import com.promouit.gameoflife.processor.NeighbourService;

public class Universe implements TickGenerator {

	private Cell[][] allCells;
	private NeighbourService neighbourService = new NeighbourService();;
	private CellLifeCycler cellLifeCycler = new CellLifeCycler();

	public Universe(Cell[][] allCells) {
		this.allCells = allCells;
	}

	public void tick() {
		allCells = cellLifeCycler.expandToPeriphalDeadCells(allCells);
		neighbourService.makeNeighbourAware(allCells);
		cellLifeCycler.updateCellState(allCells);
		allCells = cellLifeCycler.contractToLiveCells(allCells);
	}

	@Override
	public String toString() {
		StringBuilder univerStr = new StringBuilder();
		for (Cell[] cells : allCells) {
			for (Cell cell : cells)
				univerStr.append(cell.toString()).append(" ");
			univerStr.append("\n");
		}
		return univerStr.toString();
	}
	
	void setCellLifeCycler(CellLifeCycler cellLifeCycler) {
		this.cellLifeCycler = cellLifeCycler;
	}
	
	void setNeighbourService(NeighbourService neighbourService) {
		this.neighbourService = neighbourService;
	}
	
	public static class UniverseBuilder {

		private Iterator<String> iterator;
		
		public UniverseBuilder(Iterator<String> iterator) {
			this.iterator = iterator;
		}
		
		public Universe buildUniverse() {
			if(this.iterator == null)
				throw new IllegalArgumentException("DataIterator should not be null");
			
			int numCols = 0;
			List<Cell[]> listOfCellArrays = new ArrayList<Cell[]>();
			while(iterator.hasNext()){
				String nextLine = iterator.next();
				String[] cellStates = nextLine.trim().split(" ");
				numCols = validateNumCols(numCols, cellStates);
				Cell[] cells = new Cell[numCols];
				for(int i = 0 ; i < cellStates.length ; i++){
					cells[i] = createCell(cellStates[i]);
				}
				listOfCellArrays.add(cells);
			}
			return new Universe(toCell2DArray(listOfCellArrays));
		}

		private Cell[][] toCell2DArray(List<Cell[]> listOfCellArrays) {
			Cell[][] allCells = new Cell[listOfCellArrays.size()][];
			int position = 0;
			for(Cell[] cells : listOfCellArrays)
				allCells[position++] = cells;
			return allCells;
		}

		private Cell createCell(String cellState) {
			CellBuilder cellBuilder = new CellBuilder();
			return cellBuilder.setState(cellState).build();
		}
		
		private int validateNumCols(int numCols, String[] cellStates) {
			if(numCols == 0)
				numCols = cellStates.length;
			else if(numCols != cellStates.length)
				throw new IllegalArgumentException();
			return numCols;
		}
	}
}
