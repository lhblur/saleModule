package com.works.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class TestUtils extends TestCase {

	@Before
	protected void setUp() throws Exception {
	}

	@After
	protected void tearDown() throws Exception {
	}

	@Test
	public void testReadFile() {
		String path = "test/test.txt";
		String res = Utils.readFile(path);
		assertEquals("This is a test file.", res);
	}

	@Test
	public void testGetGoodsFromFile() {
		String path = "test/goods.json";
		Map<String, JSONObject> map = new HashMap<String,JSONObject>();
		String jsonStr = "{\"barcode\":\"ITEM0000\",\"name\":\"可乐\",\"unit\":\"瓶\",\"category\":\"食品\",\"subcategory\":\"碳酸饮料\",\"price\":\"3.0\"}";
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		map.put("ITEM0000",jsonObject);
		assertEquals(map, Utils.getGoodsFromFile(path));
	}

	@Test
	public void testGetSalesFromFile() {
		String path = "test/sales.json";
		Map<String, String> map = new HashMap<String,String>();
		map.put("ITEM0000", "BUY_THREE_GET_ONE_FREE");
		map.put("ITEM0002", "BUY_THREE_GET_ONE_FREE");
		assertEquals(map, Utils.getSalesFromFile(path));
	}

	@Test
	public void testNumberFormat() {
		double num = 13.143;
		assertEquals("13.14", Utils.numberFormat(num, "0.00"));
	}

}
