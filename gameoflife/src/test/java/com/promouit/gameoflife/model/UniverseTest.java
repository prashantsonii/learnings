package com.promouit.gameoflife.model;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.promouit.gameoflife.model.Universe.UniverseBuilder;
import com.promouit.gameoflife.processor.CellLifeCycler;
import com.promouit.gameoflife.processor.NeighbourService;

@RunWith(MockitoJUnitRunner.class)
public class UniverseTest {

	@Test
	public void shouldThrowExceptionForInvalidArguments() {
		Universe universe = new UniverseBuilder(Arrays.asList("X X", "X X").iterator()).buildUniverse();
		CellLifeCycler cellLifeCycler = Mockito.mock(CellLifeCycler.class);
		NeighbourService neighbourService = Mockito.mock(NeighbourService.class);
		universe.setCellLifeCycler(cellLifeCycler);
		universe.setNeighbourService(neighbourService);
		universe.tick();
		Mockito.verify(neighbourService, Mockito.times(1)).makeNeighbourAware(Mockito.any(Cell[][].class));
		Mockito.verify(cellLifeCycler, Mockito.times(1)).expandToPeriphalDeadCells(Mockito.any(Cell[][].class));
		Mockito.verify(cellLifeCycler, Mockito.times(1)).updateCellState(Mockito.any(Cell[][].class));
		Mockito.verify(cellLifeCycler, Mockito.times(1)).contractToLiveCells(Mockito.any(Cell[][].class));
	}
}
