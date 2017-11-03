package com.wdfall.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wdfall.service.ItemService;
import com.wdfall.vo.ItemVO;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 글목록페이지로 이동
	 * 
	 * @return jsp경로
	 */

	@RequestMapping("/itemList")
	@ResponseBody
	public List<ItemVO> itemList() {
		List<ItemVO> itemList = itemService.itemList();
		return itemList;
	}
	
	@RequestMapping("/spin")
	@ResponseBody
	public Map<String, String[]> spin() {
		Map<String, String[]> map = itemService.spin();
		return map;
	}
}
