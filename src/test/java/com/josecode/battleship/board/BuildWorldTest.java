package com.josecode.battleship.board;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;





import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.movement.Ahead;
import com.josecode.battleship.movement.IMovement;
import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.ShipType;
import com.josecode.battleship.util.ShipUtil;
import com.josecode.battleship.util.Util;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Util.class,ShipUtil.class})
public class BuildWorldTest<L, R> {
    
	private Board<L, R> board;
	BuildWorld<L, R> buildWorld = new BuildWorld<>();
	@Before
	public void inicializarVariables() {
		board = new Board<>(10);
		buildWorld = new BuildWorld<>();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buildShipWithOrientationNorthTest() {
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("N"));
		Ship<L, R> ship = new Ship<>(5,ShipType.getEnum("P"),"P");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(5);
		buildWorld.buildShipInitial(board, 0, ship);
		assertEquals(5, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(5,5), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,6), ship.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,7), ship.getPosition().stream().skip(2).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,8), ship.getPosition().stream().skip(3).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,9), ship.getPosition().stream().reduce((first,second)->second).get()); 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buildShipWithOrientationEastTest() {
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("E"));
		Ship<L, R> ship = new Ship<>(3,ShipType.getEnum("S"),"S");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(4);
		buildWorld.buildShipInitial(board, 0, ship);
		assertEquals(3, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(4,4), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,4), ship.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(6,4), ship.getPosition().stream().skip(2).findFirst().get()); 
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buildShipWithOrientationSouthTest() {
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("S"));
		Ship<L, R> ship = new Ship<>(4,ShipType.getEnum("A"),"A");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(3);
		buildWorld.buildShipInitial(board, 0, ship);
		assertEquals(4, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(3,3), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(3,2), ship.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(3,1), ship.getPosition().stream().skip(2).findFirst().get()); 
		assertEquals((Pair<L, R>) Pair.of(3,0), ship.getPosition().stream().skip(3).findFirst().get());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void buildShipWithOrientationWestTest() {
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("W"));
		Ship<L, R> ship = new Ship<>(2,ShipType.getEnum("B"),"B");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(6);
		buildWorld.buildShipInitial(board, 0, ship);
		assertEquals(2, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(6,6), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,6), ship.getPosition().stream().skip(1).findFirst().get());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void doMovementWhenFirstCellIsAlreadyPoblatedNorthTest() {
		//like the cell starting [5,7] is already porblated inmediatly choose a new postion x and y random 
		// in this case the number 2 for X and Y
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("N"));
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(2);
		PowerMockito.when(Util.getLeft((Pair<L, R>) Pair.of(5,7))).thenReturn(5);
		PowerMockito.when(Util.getRight((Pair<L, R>) Pair.of(5,7))).thenReturn(7);
		Ship<L, R> ship = new Ship<>(4,ShipType.getEnum("A"),"A");
		ship.setPositionStarting((Pair<L, R>) Pair.of(5,7));
		buildWorld.doMovements(getListMovement(), addCellAddedToBoard(board), 0, ship);
		assertEquals(4, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(2,2), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(2,3), ship.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(2,4), ship.getPosition().stream().skip(2).findFirst().get()); 
		assertEquals((Pair<L, R>) Pair.of(2,5), ship.getPosition().stream().skip(3).findFirst().get());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void doWhenOneSecondCellIsAlreadyPoblatedChangePositionWestTest() {
		//like the cell [5,7] is already poblated the cell starting [4,7] change the position from E to S
		// and start the process again.
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("E"));
		Ship<L, R> ship = new Ship<>(4,ShipType.getEnum("A"),"A");
		ship.setPositionStarting((Pair<L, R>) Pair.of(4,7));
		buildWorld.doMovements(getListMovement(), addCellAddedToBoard(board), 0, ship);
		assertEquals(4, ship.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(4,7), ship.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(4,6), ship.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(4,5), ship.getPosition().stream().skip(2).findFirst().get()); 
		assertEquals((Pair<L, R>) Pair.of(4,4), ship.getPosition().stream().skip(3).findFirst().get());
	}
	
	@SuppressWarnings("unchecked")
	private Board<L, R> addCellAddedToBoard(Board<L, R> board){
		Set<Pair<L,R>> setPair = new LinkedHashSet<>();
		setPair.add((Pair<L, R>) Pair.of(5,5));
		setPair.add((Pair<L, R>) Pair.of(5,6));
		setPair.add((Pair<L, R>) Pair.of(5,7));
		setPair.add((Pair<L, R>) Pair.of(5,8));
		setPair.add((Pair<L, R>) Pair.of(5,9));
		board.setCellsAdded(setPair);
		return board;
	}
	
	private List<IMovement<L, R>> getListMovement() {
		List<IMovement<L, R>> listMovement = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			IMovement<L, R> movement = new Ahead<>();
			listMovement.add(movement);
		}
		return listMovement;
	}
	
}
