package com.works.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.works.bean.Goods;

public class Utils {
	public static String readFile(String Path) {
		BufferedReader reader = null;
		String resStr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				resStr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resStr;
	}

	public static Map<String, JSONObject> getGoodsFromFile(String path) {
		Map<String, JSONObject> goodsMap = new HashMap<String, JSONObject>();
		String JsonGoods = readFile(path);
		JSONArray jAGoods = JSONArray.parseArray(JsonGoods);
		int sizeGoods = jAGoods.size();
		// 解析所有货品信息
		for (int j = 0; j < sizeGoods; j++) {
			JSONObject jOGoods = jAGoods.getJSONObject(j);
			goodsMap.put(jOGoods.get("barcode").toString(), jOGoods);
		}
		return goodsMap;
	}

	public static Map<String, String> getSalesFromFile(String path) {
		Map<String, String> salesMap = new HashMap<String,String>();
		String JsonSale = readFile(path);
		JSONArray jASale = JSONArray.parseArray(JsonSale);
		int sizeSales = jASale.size();

		// 解析参加活动的商品信息
		for (int i = 0; i < sizeSales; i++) {
			JSONObject jOSale = jASale.getJSONObject(i);
			String saleType = jOSale.getString("type");
			String str = jOSale.getString("barcodes");
			String[] saleArr = str.trim().split(",");
			for (int j = 0; j < saleArr.length; j++) {
				salesMap.put(saleArr[j], saleType);
			}
		}
		
		return salesMap;
	}

	public static void printList(List<Goods> goods) {
		String result = "";
		double totalPrice = 0;
		List<Goods> saleList = new ArrayList<Goods>();
		result += "             <没钱赚商店>购物清单                              " + "\n";
		for (Goods good : goods) {
			switch (good.getSaletype()) {
			case "BUY_THREE_GET_ONE_FREE":
				result += good.toString()
						+ numberFormat(good.getPrice() * (good.getCount() - good.getCount() / 3), "0.00") + "(元)"
						+ "\n";
				totalPrice += good.getPrice() * (good.getCount() - good.getCount() / 3);
				saleList.add(good);
				break;
			default:
				result += good.toString() + numberFormat(good.getPrice() * good.getCount(), "0.00") + "(元)" + "\n";
				totalPrice += good.getPrice() * good.getCount();
				break;
			}
		}
		System.out.println(result);

		String saleResult = "";
		double cutPrice = 0;
		if (saleList != null && saleList.size() > 0) {
			saleResult += "买三免一商品：" + "\n";
			for (Goods good : saleList) {
				if (good.getCount() >= 3) {
					saleResult += "名称：" + good.getName() + "，数量：" + good.getCount() / 3 + good.getUnit() + "\n";
					cutPrice += good.getPrice() * (good.getCount() / 3);
				}
			}
			if (cutPrice != 0) {
				System.out.println(saleResult);
			}
		}

		System.out.print("总计：" + numberFormat(totalPrice, "0.00") + "元");
		if (cutPrice != 0) {
			System.out.println("，节省：" + numberFormat(cutPrice, "0.00") + "元");
		}
	}

	public static String numberFormat(double num, String format) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(num);
	}

}
