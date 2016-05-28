package com.works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.works.bean.Goods;
import com.works.util.Utils;

public class Main {

	static Map<String, JSONObject> goodsMap = new HashMap<String, JSONObject>();
	static Map<String, String> salesMap = new HashMap<String, String>();

	static String goodsPath = "goods.json";
	static String salePath = "saleList.json";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		init();
		//Scanner scan = new Scanner(System.in);
		//String strs = scan.nextLine();
		String strs = Utils.readFile("input.txt");
		String[] input = strs.trim().split(",");
		List<Goods> buyList = new ArrayList<Goods>();
		for (int i = 0; i < input.length; i++) {
			Goods good = new Goods();
			good = getGoodFromBarcode(input[i]);
			buyList.add(good);
		}
		Utils.printList(buyList);
		//scan.close();
	}
	
	public static void init() {
		goodsMap = Utils.getGoodsFromFile(goodsPath);
		salesMap = Utils.getSalesFromFile(salePath);
	}

	
	
	public static Goods getGoodFromBarcode(String barcodes) {
		Goods good = new Goods();
		String barcode = barcodes.split("-")[0];
		int num = 1;
		String saletype = "NO";
		if (salesMap.containsKey(barcode)) {
			saletype = salesMap.get(barcode);
		}

		if (barcodes.contains("-")) {
			num = Integer.valueOf(barcodes.split("-")[1]);
		}

		if (goodsMap.containsKey(barcode)) {
			JSONObject jsonObject = goodsMap.get(barcode);
			good.setBarcode(jsonObject.getString("barcode"));
			good.setCategory(jsonObject.getString("category"));
			good.setName(jsonObject.getString("name"));
			good.setCount(num);
			good.setPrice(jsonObject.getDouble("price"));
			good.setSaletype(saletype);
			good.setSubcategory(jsonObject.getString("subcategory"));
			good.setUnit(jsonObject.getString("unit"));
		} else {
			System.out.println("无此商品");
			System.exit(0);
		}
		return good;
	}

	

}
