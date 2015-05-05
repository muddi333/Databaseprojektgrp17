package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daoimpl01917.MySQLReceptDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import dto01917.ProduktBatchKompDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;
import dto01917.ReceptDTO;
import dto01917.ReceptKompDTO;

public class TestDAO {

	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}

	/**--------------------------------------------------------------------------------------------*/
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
		assertEquals(prbOBJ.size(), 5);
	}

	//	@Test
	//	public void testcreateProduktBatch() throws DALException{
	//		ProduktBatchDTO test;
	//		prb.createProduktBatch(test= new ProduktBatchDTO(6, 1, 1));
	//		ProduktBatchDTO prbOBJ = prb.getProduktBatch(6);
	//		assertEquals(1, prbOBJ.getStatus());
	//		assertEquals(1, prbOBJ.getReceptId());
	//		assertEquals(6, prbOBJ.getPbId());
	//	}
	//
	//		@Test
	//		public void testupdateProduktBatch() throws DALException{
	//			ProduktBatchDTO test;
	//			prb.updateProduktBatch(test= new ProduktBatchDTO(6, 1, 2)); //opdatere recept_id til 2
	//			ProduktBatchDTO prbOBJ = prb.getProduktBatch(6);
	//			assertEquals(2, prbOBJ.getReceptId());
	//		}
	/**--------------------------------------------------------------------------------------------*/
	MySQLProduktBatchKompDAO prbk = new MySQLProduktBatchKompDAO();

	@Test
	public void testgetProduktBatchKomp() throws DALException{
		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(4, 7);
		assertEquals(0.5, prbkOBJ.getTara(),0.0);
		assertEquals(0.99, prbkOBJ.getNetto(),0.0);
		assertEquals(3, prbkOBJ.getOprId());
		assertEquals(7, prbkOBJ.getRbId());
		assertEquals(4, prbkOBJ.getPbId());
	}
	@Test
	public void testgetProduktBatchKompList() throws DALException{
		List<ProduktBatchKompDTO> prbkOBJ = prbk.getProduktBatchKompList();
		assertEquals(prbkOBJ.size(), 14);
	}
	@Test
	public void testgetProduktBatchKompListId() throws DALException{
		List<ProduktBatchKompDTO> prbkOBJ = prbk.getProduktBatchKompList(4);
		assertEquals(prbkOBJ.size(), 4); // da der er 4 med pb_id 4 i databasen
	}
	//	@Test
	//	public void testcreateProduktBatchKomp() throws DALException{
	//		ProduktBatchKompDTO test;
	//		prbk.createProduktBatchKomp(test= new ProduktBatchKompDTO(5, 1, 0.5, 1.00, 3));
	//		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(5,1);
	//		assertEquals(0.5, prbkOBJ.getTara(),0.0);
	//		assertEquals(1.00, prbkOBJ.getNetto(),0.0);
	//		assertEquals(3, prbkOBJ.getOprId());
	//		assertEquals(1, prbkOBJ.getRbId());
	//		assertEquals(5, prbkOBJ.getPbId());
	//	}
	//	@Test
	//	public void testupdateProduktBatchKomp() throws DALException{
	//		ProduktBatchKompDTO test;
	//		prbk.updateProduktBatchKomp(test= new ProduktBatchKompDTO(5, 1, 0.6, 1.01, 3)); //opdatere recept_id til 2
	//		ProduktBatchKompDTO prbkOBJ = prbk.getProduktBatchKomp(5,1);
	//		assertEquals(0.6, prbkOBJ.getTara(),0.0);
	//		assertEquals(1.01, prbkOBJ.getNetto(),0.0);
	//	}
	/**--------------------------------------------------------------------------------------------*/
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
		assertEquals(rvbOBJ.size(), 7);
	}
	@Test
	public void testgetRaavareBatchListId() throws DALException{
		List<RaavareBatchDTO> rvbOBJ = rvb.getRaavareBatchList(5);
		assertEquals(rvbOBJ.size(), 2);
	}
	//	@Test
	//	public void testcreateRaavareBatch() throws DALException{
	//		RaavareBatchDTO test;
	//		rvb.createRaavareBatch(test = new RaavareBatchDTO(8, 8, 200.0));
	//		RaavareBatchDTO rvbOBJ = rvb.getRaavareBatch(8);
	//		assertEquals(8, rvbOBJ.getRbId());
	//		assertEquals(200.0, rvbOBJ.getMaengde(),0.0);
	//		assertEquals(6, rvbOBJ.getRbId());
	//	}
	//	@Test
	//	public void testupdateRaavareBatch() throws DALException{
	//		RaavareBatchDTO test;
	//		rvb.updateRaavareBatch(test = new RaavareBatchDTO(8, 7, 100.0));
	//		RaavareBatchDTO rvbOBJ = rvb.getRaavareBatch(8);
	//		assertEquals(7, rvbOBJ.getRaavareId());
	//		assertEquals(100.0, rvbOBJ.getMaengde(),0.0);
	//	}
	/**--------------------------------------------------------------------------------------------*/
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
		assertEquals(rvOBJ.size(), 7);
	}
	//	@Test
	//	public void testcreateRaavare() throws DALException{
	//		RaavareDTO test;
	//		rv.createRaavare(test = new RaavareDTO(8, "fisk", "Bornholm"));
	//		RaavareDTO rvOBJ = rv.getRaavare(8);
	//		assertEquals("fisk", rvOBJ.getRaavareNavn());
	//		assertEquals("Bornholm", rvOBJ.getLeverandoer());
	//		assertEquals(8, rvOBJ.getRaavareId());
	//	}
	//	@Test
	//	public void testupdateRaavare() throws DALException{
	//		RaavareDTO test;
	//		rv.updateRaavare(test = new RaavareDTO(8, "tun", "Middelhavet"));
	//		RaavareDTO rvOBJ = rv.getRaavare(8);
	//		assertEquals("tun", rvOBJ.getRaavareNavn());
	//		assertEquals("Middelhavet", rvOBJ.getLeverandoer());
	//		assertEquals(8, rvOBJ.getRaavareId());
	//	}
	/**--------------------------------------------------------------------------------------------*/
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
		assertEquals(rcOBJ.size(), 3);
	}
	//	@Test
	//	public void testcreateRecept() throws DALException{
	//		ReceptDTO test;
	//		rc.createRecept(test = new ReceptDTO(4, "saras"));
	//		ReceptDTO rcOBJ = rc.getRecept(4);
	//		assertEquals("saras", rcOBJ.getReceptNavn());
	//		assertEquals(4, rcOBJ.getReceptId());
	//	}
	//	@Test
	//	public void testupdateRecept() throws DALException{
	//		ReceptDTO test;
	//		rc.updateRecept(test = new ReceptDTO(4, "manakish"));
	//		ReceptDTO rcOBJ = rc.getRecept(4);
	//		assertEquals("manakish", rcOBJ.getReceptNavn());
	//		assertEquals(4, rcOBJ.getReceptId());
	//	}
	/**--------------------------------------------------------------------------------------------*/
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
		
	}
	
}