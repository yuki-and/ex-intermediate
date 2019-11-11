package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル関連機能の業務処理を行うサービス.
 * 
 * @author yukiando
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報をID順で全件取得する.
	 * 
	 * @return ホテル情報リスト
	 */
	public List<Hotel> searchNull(){
		return hotelRepository.findAll();
	}
	
	/**
	 * 価格からホテル情報を取得する.
	 * 
	 * @param price　価格
	 * @return　ホテル情報リスト
	 */
	public List<Hotel> searchByPrice(Integer price){
		return hotelRepository.findByPrice(price);
	}
}
