package test01917;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLOperatoerDAO;
import daointerfaces01917.DALException;
import dto01917.OperatoerDTO;

public class TestOperatoer {
	@Before
	public void prep(){
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
	}
	MySQLOperatoerDAO opr = new MySQLOperatoerDAO();

	@Test
	public void testgetOperatoer() throws DALException{
		OperatoerDTO oprOBJ = opr.getOperatoer(3);
		assertEquals("Luigi C", oprOBJ.getOprNavn());
		assertEquals("LC", oprOBJ.getIni());
		assertEquals("090990-9009", oprOBJ.getCpr());
		assertEquals("jEfm5aQ", oprOBJ.getPassword());
		assertEquals(3, oprOBJ.getOprId());
	}
	@Test
	public void testcreateOperatoer(){
		OperatoerDTO oprDTO;
		try {
			opr.createOperatoer(oprDTO = new OperatoerDTO(4,"Don Juan","DoJu","000000-0000","iloveyou"));
			OperatoerDTO oprOBJ = opr.getOperatoer(4);
			assertEquals("Don Juan", oprOBJ.getOprNavn());
			assertEquals("DoJu", oprOBJ.getIni());
			assertEquals("000000-0000", oprOBJ.getCpr());
			assertEquals("iloveyou", oprOBJ.getPassword());
			assertEquals(4, oprOBJ.getOprId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}

	@Test
	public void testupdateOperatoer(){
		OperatoerDTO oprDTO;
		try {
			opr.updateOperatoer(oprDTO = new OperatoerDTO(4,"Don Juan","DJ","123456-0000","iloveyouall"));
			OperatoerDTO oprOBJ = opr.getOperatoer(4);
			assertEquals("Don Juan", oprOBJ.getOprNavn());
			assertEquals("DJ", oprOBJ.getIni());
			assertEquals("123456-0000", oprOBJ.getCpr());
			assertEquals("iloveyouall", oprOBJ.getPassword());
			assertEquals(4, oprOBJ.getOprId());
		} catch (DALException e) { System.out.println(e.getMessage()); }
	}

	@Test
	public void testgetOperatoerList() throws DALException{
		List<OperatoerDTO> oprOBJ = opr.getOperatoerList();
		assertEquals(oprOBJ.size(), 4);
	}
}