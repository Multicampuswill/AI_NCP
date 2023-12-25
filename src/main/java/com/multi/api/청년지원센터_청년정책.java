package com.multi.api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.client.RestTemplate;

public class 청년지원센터_청년정책 {

	public static void main(String[] args) {
		//url + parameter
		String url = "https://www.youthcenter.go.kr/opi/empList.do";
		String paramter = "?openApiVlak=2853a1265426c8954d6b244d&pageIndex=1&display=10&query=청년취업";
		
		//http 요청 --> 응답(xml)
		RestTemplate rest = new RestTemplate();
		String response = rest.getForObject(url + paramter, String.class);
		//System.out.println(response);
		
		//xml --> json변경 
		JSONObject json = XML.toJSONObject(response);
		System.out.println(json);
		
		//json분석 후 추출(parser, 파서) 
		//json바깥쪽부터 안으로 들어오면서 추출을 함.
		JSONObject empsInfo = json.getJSONObject("empsInfo");//값이 json일 때 
		JSONArray arr = empsInfo.getJSONArray("emp");//값이 jsonarray일 때 
		System.out.println(arr.getJSONObject(0).getString("bizId"));
		System.out.println(arr.getJSONObject(0).getString("polyBizSjnm"));
		System.out.println(arr.getJSONObject(0).getString("plcyTpNm"));
		System.out.println(arr.getJSONObject(0).getString("cnsgNmor"));
		System.out.println(arr.getJSONObject(0).getString("rqutProcCn"));
	}

}
