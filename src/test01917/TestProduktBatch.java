package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class TestProduktBatch {

	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}

	MySQLProduktBatchDAO  prb = new MySQLProduktBatchDAO();

	@Test
	public void testgetProduktBatch() throws DALException{
		ProduktBatchDTO prbOBJ = prb.getProduktBatch(4);
		assertEquals(1, prbOBJ.getStatus());
		assertEquals(3, prbOBJ.getReceptId());
		assertEquals(4, prbOBJ.getPbId());
	}
	@Test
	public void testgetProduktBatchList() throws DALException{
		List<ProduktBatchDTO> prbOBJ = prb.getProduktBatchList();
		assertEquals(prbOBJ.size(), 6);
	}
	@Test
	public void testcreateProduktBatch(){
		ProduktBatchDTO test;
		try{
		prb.createProduktBatch(test= new ProduktBatchDTO(6, 1, 1));
		ProduktBatchDTO prbOBJ = prb.getProduktBatch(6);
		assertEquals(1, prbOBJ.getStatus());
		assertEquals(1, prbOBJ.getReceptId());
		assertEquals(6, prbOBJ.getPbId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
	@Test
	public void testupdateProduktBatch(){
		ProduktBatchDTO test;
		try{
		prb.updateProduktBatch(test= new ProduktBatchDTO(6, 1, 2)); //opdatere recept_id til 2
		ProduktBatchDTO prbOBJ = prb.getProduktBatch(6);
		assertEquals(2, prbOBJ.getReceptId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}
}