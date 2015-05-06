package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptKompDTO;

public class TestReceptKomp {
	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	MySQLReceptKompDAO rck = new MySQLReceptKompDAO();

	@Test
	public void testgetReceptKomp() throws DALException{
		ReceptKompDTO rckOBJ = rck.getReceptKomp(3, 7);
		assertEquals(1.0, rckOBJ.getNomNetto(),0.0);
		assertEquals(0.1, rckOBJ.getTolerance(),0.0);
		assertEquals(7, rckOBJ.getRaavareId());
		assertEquals(3, rckOBJ.getReceptId());
	}
	@Test
	public void testgetReceptKompList() throws DALException{
		List<ReceptKompDTO> rckOBJ = rck.getReceptKompList();
		assertEquals(rckOBJ.size(), 13);
	}
	@Test
	public void testcreateReceptKomp(){
		ReceptKompDTO test;
		try{
			rck.createReceptKomp(test = new ReceptKompDTO(4, 7, 1.0, 0.1));
			ReceptKompDTO rckOBJ = rck.getReceptKomp(4, 7);
			assertEquals(1.0, rckOBJ.getNomNetto(),0.0);
			assertEquals(0.1, rckOBJ.getTolerance(),0.0);
			assertEquals(7, rckOBJ.getRaavareId());
			assertEquals(4, rckOBJ.getReceptId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
	@Test
	public void testupdateReceptKomp(){
		ReceptKompDTO test;
		try{
			rck.updateReceptKomp(test = new ReceptKompDTO(4, 7, 1.1, 0.2));
			ReceptKompDTO rckOBJ = rck.getReceptKomp(4, 7);
			assertEquals(1.1, rckOBJ.getNomNetto(),0.0);
			assertEquals(0.2, rckOBJ.getTolerance(),0.0);
			assertEquals(7, rckOBJ.getRaavareId());
			assertEquals(4, rckOBJ.getReceptId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
