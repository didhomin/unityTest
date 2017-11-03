package com.wdfall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wdfall.vo.ItemVO;


@Repository
public interface ItemDao {

	List<ItemVO> itemList();


	
}
