package marsrover.command.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import marsrover.command.Command;
import marsrover.command.impl.LeftCommand;
import marsrover.command.impl.MoveCommand;
import marsrover.command.impl.RightCommand;


public class CommandFactoryTest {

	@Test
	public void shouldCreateLeftCommand(){
		Command command = CommandFactory.getCommand(null, 'L');
		assertTrue(command instanceof LeftCommand);
		command = CommandFactory.getCommand(null, 'l');
		assertTrue(command instanceof LeftCommand);
	}
	
	@Test
	public void shouldCreateRightCommand(){
		Command command = CommandFactory.getCommand(null, 'R');
		assertTrue(command instanceof RightCommand);
		command = CommandFactory.getCommand(null, 'r');
		assertTrue(command instanceof RightCommand);
	}

	@Test
	public void shouldCreateMoveCommand(){
		Command command = CommandFactory.getCommand(null, 'M');
		assertTrue(command instanceof MoveCommand);
		command = CommandFactory.getCommand(null, 'm');
		assertTrue(command instanceof MoveCommand);		
	}
	
}
