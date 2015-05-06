package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class TestProduktBatchKomp {
	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}

	MySQLProduktBatchKompDAO prbk = new MySQLProduktBatchKompDAO();

	@Test
	public void testgetProduktBatchKomp() throws DALException{
		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(4,7);
		assertEquals(0.5, prbkOBJ.getTara(),0.0);
		assertEquals(0.99, prbkOBJ.getNetto(),0.0);
		assertEquals(3, prbkOBJ.getOprId());
		assertEquals(7, prbkOBJ.getRbId());
		assertEquals(4, prbkOBJ.getPbId());
	}
	@Test
	public void testgetProduktBatchKompList() throws DALException{
		List<ProduktBatchKompDTO> prbkOBJ = prbk.getProduktBatchKompList();
		assertEquals(prbkOBJ.size(), 15);
	}
	@Test
	public void testgetProduktBatchKompListId() throws DALException{
		List<ProduktBatchKompDTO> prbkOBJ = prbk.getProduktBatchKompList(4);
		assertEquals(prbkOBJ.size(), 4); // da der er 4 med pb_id 4 i databasen
	}
	@Test
	public void testcreateProduktBatchKomp(){
		ProduktBatchKompDTO test;
		try{
		prbk.createProduktBatchKomp(test= new ProduktBatchKompDTO(5, 1, 0.5, 1.00, 3));
		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(5,1);
		assertEquals(0.5, prbkOBJ.getTara(),0.0);
		assertEquals(1.00, prbkOBJ.getNetto(),0.0);
		assertEquals(3, prbkOBJ.getOprId());
		assertEquals(1, prbkOBJ.getRbId());
		assertEquals(5, prbkOBJ.getPbId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
	@Test
	public void testupdateProduktBatchKomp(){
		ProduktBatchKompDTO test;
		try{
		prbk.updateProduktBatchKomp(test= new ProduktBatchKompDTO(5, 1, 0.6, 1.01, 3)); //opdatere recept_id til 2
		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(5,1);
		assertEquals(0.6, prbkOBJ.getTara(),0.0);
		assertEquals(1.01, prbkOBJ.getNetto(),0.0);
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
