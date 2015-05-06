package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.RaavareBatchDTO;

public class TestRaavareBatch {

	@Before
	public void prep()throws DALException{
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	MySQLRaavareBatchDAO rvb = new MySQLRaavareBatchDAO();

	@Test
	public void testgetRaavareBatch() throws DALException{
		RaavareBatchDTO rvbOBJ = rvb.getRaavareBatch(7);
		assertEquals(7, rvbOBJ.getRaavareId());
		assertEquals(100.0, rvbOBJ.getMaengde(),0.0);
		assertEquals(7, rvbOBJ.getRbId());
	}
	@Test
	public void testgetRaavareBatchList() throws DALException{
		List<RaavareBatchDTO> rvbOBJ = rvb.getRaavareBatchList();
		assertEquals(rvbOBJ.size(), 8);
	}
	@Test
	public void testgetRaavareBatchListId() throws DALException{
		List<RaavareBatchDTO> rvbOBJ = rvb.getRaavareBatchList(5);
		assertEquals(rvbOBJ.size(), 2);
	}
	@Test
	public void testcreateRaavareBatch(){
		RaavareBatchDTO test;
		try{
			rvb.createRaavareBatch(test = new RaavareBatchDTO(8, 8, 200.0));
			RaavareBatchDTO rvbOBJ = rvb.getRaavareBatch(8);
			assertEquals(8, rvbOBJ.getRbId());
			assertEquals(200.0, rvbOBJ.getMaengde(),0.0);
			assertEquals(8, rvbOBJ.getRbId());
		} catch (DALException e) { System.out.println(e.getMessage()); }

	}
	@Test
	public void testupdateRaavareBatch(){
		RaavareBatchDTO test;
		try{
			rvb.updateRaavareBatch(test = new RaavareBatchDTO(8, 7, 100.0));
			RaavareBatchDTO rvbOBJ = rvb.getRaavareBatch(8);
			assertEquals(7, rvbOBJ.getRaavareId());
			assertEquals(100.0, rvbOBJ.getMaengde(),0.0);
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
