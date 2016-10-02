package com.josecode.battleship.board;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;





import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.josecode.battleship.element.Ship;
import com.josecode.battleship.util.Orientation;
import com.josecode.battleship.util.ShipType;
import com.josecode.battleship.util.ShipUtil;
import com.josecode.battleship.util.Util;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Util.class,ShipUtil.class})
public class BuildWorldTest<L, R> {
    
	private Board<L, R> board;
	
	@Before
	public void inicializarVariables() {
		board = new Board<>(10);
	}
	
	@Test
	public void buildShipWithOrientationNorthTest() {
		BuildWorld<L, R> build = new BuildWorld<>();
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("N"));
		Ship<L, R> ship = new Ship<>(5,ShipType.getEnum("P"),"P");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(5);
		Ship<L, R> shipFinal = build.buildShipInitial(board, 0, ship);
		assertEquals(5, shipFinal.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(5,5), shipFinal.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,6), shipFinal.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,7), shipFinal.getPosition().stream().skip(2).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,8), shipFinal.getPosition().stream().skip(3).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,9), shipFinal.getPosition().stream().reduce((first,second)->second).get()); 
	}
	
	@Test
	public void buildShipWithOrientationEastTest() {
		BuildWorld<L, R> build = new BuildWorld<>();
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("E"));
		Ship<L, R> ship = new Ship<>(3,ShipType.getEnum("S"),"S");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(4);
		Ship<L, R> shipFinal = build.buildShipInitial(board, 0, ship);
		assertEquals(3, shipFinal.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(4,4), shipFinal.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,4), shipFinal.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(6,4), shipFinal.getPosition().stream().skip(2).findFirst().get()); 
	}
	
	@Test
	public void buildShipWithOrientationSouthTest() {
		BuildWorld<L, R> build = new BuildWorld<>();
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("S"));
		Ship<L, R> ship = new Ship<>(4,ShipType.getEnum("A"),"A");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(3);
		Ship<L, R> shipFinal = build.buildShipInitial(board, 0, ship);
		assertEquals(4, shipFinal.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(3,3), shipFinal.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(3,2), shipFinal.getPosition().stream().skip(1).findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(3,1), shipFinal.getPosition().stream().skip(2).findFirst().get()); 
		assertEquals((Pair<L, R>) Pair.of(3,0), shipFinal.getPosition().stream().skip(3).findFirst().get());
	}
	
	@Test
	public void buildShipWithOrientationWestTest() {
		BuildWorld<L, R> build = new BuildWorld<>();
		PowerMockito.mockStatic(ShipUtil.class,Util.class);
		PowerMockito.when(ShipUtil.getRandomOrientation()).thenReturn(Orientation.getEnum("W"));
		Ship<L, R> ship = new Ship<>(2,ShipType.getEnum("B"),"B");
		PowerMockito.when(Util.getRandomNumber(10)).thenReturn(6);
		Ship<L, R> shipFinal = build.buildShipInitial(board, 0, ship);
		assertEquals(2, shipFinal.getPosition().size());
		assertEquals((Pair<L, R>) Pair.of(6,6), shipFinal.getPosition().stream().findFirst().get());
		assertEquals((Pair<L, R>) Pair.of(5,6), shipFinal.getPosition().stream().skip(1).findFirst().get());
	}
}
