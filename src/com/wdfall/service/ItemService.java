package com.wdfall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdfall.dao.ItemDao;
import com.wdfall.vo.ItemVO;

@Service
public class ItemService {
	@Autowired
	private SqlSession sqlSession;

	public List<ItemVO> itemList() {
		
		return sqlSession.getMapper(ItemDao.class).itemList();
	}
	int symbolCountA = 1;
	int symbolCountB = 2;
	int symbolCountC = 3;
	int symbolCountD = 4;
	int totalCount = symbolCountA+symbolCountB+symbolCountC+symbolCountD;
	
	String symbolA= "0";
	String symbolB= "1";
	String symbolC= "2";
	String symbolD= "3";

	
	// Map <String,String[]>
	public Map<String, String[]> spin() {
		int count = 0;
		String[] list = new String[totalCount];
		for(int i =0; i<symbolCountA; i++) {
			list[count++] = symbolA;
		}
		for(int i =0; i<symbolCountB; i++) {
			list[count++] = symbolB;
		}
		for(int i =0; i<symbolCountC; i++) {
			list[count++] = symbolC;
		}
		for(int i =0; i<symbolCountD; i++) {
			list[count++] = symbolD;
		}
		Map<String, String[]> map= new HashMap<String,String[]>();
		String[] result = null;
		
		for (int i=0; i<3; i++) {
			result = new String[3];
			for (int j=0; j<3; j++) {
				result[j]=list[RandomNumber()];
			}
			map.put( "reel"+i , result);
		}

		
		return map;
	}
	private int RandomNumber() {
		return (int) (Math.random() * totalCount);
	}
}
