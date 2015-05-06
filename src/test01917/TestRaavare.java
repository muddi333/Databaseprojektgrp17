package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareDTO;

public class TestRaavare {
	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	MySQLRaavareDAO rv = new MySQLRaavareDAO();

	@Test
	public void testgetRaavare() throws DALException{
		RaavareDTO rvOBJ = rv.getRaavare(7);
		assertEquals("champignon", rvOBJ.getRaavareNavn());
		assertEquals("Igloo Frostvarer", rvOBJ.getLeverandoer());
		assertEquals(7, rvOBJ.getRaavareId());
	}
	@Test
	public void testgetRaavareList() throws DALException{
		List<RaavareDTO> rvOBJ = rv.getRaavareList();
		assertEquals(rvOBJ.size(), 8);
	}
	@Test
	public void testcreateRaavare(){
		RaavareDTO test;
		try{
			rv.createRaavare(test = new RaavareDTO(8, "fisk", "Bornholm"));
			RaavareDTO rvOBJ = rv.getRaavare(8);
			assertEquals("fisk", rvOBJ.getRaavareNavn());
			assertEquals("Bornholm", rvOBJ.getLeverandoer());
			assertEquals(8, rvOBJ.getRaavareId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
	@Test
	public void testupdateRaavare(){
		RaavareDTO test;
		try{
			rv.updateRaavare(test = new RaavareDTO(8, "tun", "Middelhavet"));
			RaavareDTO rvOBJ = rv.getRaavare(8);
			assertEquals("tun", rvOBJ.getRaavareNavn());
			assertEquals("Middelhavet", rvOBJ.getLeverandoer());
			assertEquals(8, rvOBJ.getRaavareId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}