package com.works.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TestGoods extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		Goods good = new Goods("ITEM0001","����","ƿ","ʳƷ","����",3.0,5,"NO");
		assertEquals("ITEM0001", good.getBarcode());
		assertEquals("����", good.getName());
		assertEquals("ƿ", good.getUnit());
		assertEquals("ʳƷ", good.getCategory());
		assertEquals("����", good.getSubcategory());
		assertEquals(3.0, good.getPrice(),0.1);
		assertEquals(5, good.getCount());
		assertEquals("NO", good.getSaletype());
	}
	
	@Test
	public void testSet() {
		Goods good = new Goods();
		good.setBarcode("ITEM0006");
		good.setName("��ֽ");
		good.setUnit("��");
		good.setCategory("����Ʒ");
		good.setSubcategory("ֽƷ");
		good.setPrice(2.8);
		good.setCount(5);
		good.setSaletype("BUY_THREE_GET_ONE_FREE");
		
		assertEquals("ITEM0006", good.getBarcode());
		assertEquals("��ֽ", good.getName());
		assertEquals("��", good.getUnit());
		assertEquals("����Ʒ", good.getCategory());
		assertEquals("ֽƷ", good.getSubcategory());
		assertEquals(2.8, good.getPrice(),0.1);
		assertEquals(5, good.getCount());
		assertEquals("BUY_THREE_GET_ONE_FREE", good.getSaletype());
	}

}
