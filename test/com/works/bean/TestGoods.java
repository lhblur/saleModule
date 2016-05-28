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
		Goods good = new Goods("ITEM0001","可乐","瓶","食品","饮料",3.0,5,"NO");
		assertEquals("ITEM0001", good.getBarcode());
		assertEquals("可乐", good.getName());
		assertEquals("瓶", good.getUnit());
		assertEquals("食品", good.getCategory());
		assertEquals("饮料", good.getSubcategory());
		assertEquals(3.0, good.getPrice(),0.1);
		assertEquals(5, good.getCount());
		assertEquals("NO", good.getSaletype());
	}
	
	@Test
	public void testSet() {
		Goods good = new Goods();
		good.setBarcode("ITEM0006");
		good.setName("卷纸");
		good.setUnit("包");
		good.setCategory("日用品");
		good.setSubcategory("纸品");
		good.setPrice(2.8);
		good.setCount(5);
		good.setSaletype("BUY_THREE_GET_ONE_FREE");
		
		assertEquals("ITEM0006", good.getBarcode());
		assertEquals("卷纸", good.getName());
		assertEquals("包", good.getUnit());
		assertEquals("日用品", good.getCategory());
		assertEquals("纸品", good.getSubcategory());
		assertEquals(2.8, good.getPrice(),0.1);
		assertEquals(5, good.getCount());
		assertEquals("BUY_THREE_GET_ONE_FREE", good.getSaletype());
	}

}
