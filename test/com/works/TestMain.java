package com.works;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.works.bean.Goods;

import junit.framework.TestCase;

public class TestMain extends TestCase{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetGoodFromBarcode() {
		Main.init();
		Goods good = new Goods("ITEM0000","可乐","瓶","食品","碳酸饮料",3.0,3,"NO");
		assertEquals(good, Main.getGoodFromBarcode("ITEM0000-3"));
	}

}
