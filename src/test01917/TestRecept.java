package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptDTO;

public class TestRecept {

	@After
	public void tearDown() throws Exception {
	}

	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	MySQLReceptDAO rc = new MySQLReceptDAO();

	@Test
	public void testgetRecept() throws DALException{
		ReceptDTO rcOBJ = rc.getRecept(3);
		assertEquals("capricciosa", rcOBJ.getReceptNavn());
		assertEquals(3, rcOBJ.getReceptId());
	}
	@Test
	public void testgetReceptList() throws DALException{
		List<ReceptDTO> rcOBJ = rc.getReceptList();
		assertEquals(rcOBJ.size(), 5);
	}
	@Test
	public void testcreateRecept(){
		ReceptDTO test;
		try{
			rc.createRecept(test = new ReceptDTO(5, "saras"));
			ReceptDTO rcOBJ = rc.getRecept(5);
			assertEquals("saras", rcOBJ.getReceptNavn());
			assertEquals(5, rcOBJ.getReceptId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
	@Test
	public void testupdateRecept(){
		ReceptDTO test;
		try{
			rc.updateRecept(test = new ReceptDTO(5, "manakish"));
			ReceptDTO rcOBJ = rc.getRecept(5);
			assertEquals("manakish", rcOBJ.getReceptNavn());
			assertEquals(5, rcOBJ.getReceptId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}