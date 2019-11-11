package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル検索機能の処理の制御を行うコントローラ.
 * 
 * @author yukiando
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索をする.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "search";
	}
	
	/**
	 * 検索結果を表示する.
	 * 
	 * @param price　価格
	 * @param model　リクエストスコープ
	 * @return　ホテル検索画面　価格を入力せずに検索した場合、全件結果を表示する。価格を入力した場合、その価格以下の検索結果を表示する
	 */
	@RequestMapping("/result")
	public String result(Integer price, Model model) {
		if(price == null) {
			List<Hotel> hotelList = hotelService.searchNull();
			model.addAttribute("hotelList", hotelList);
			return "search";
		}
		List<Hotel> hotelList = hotelService.searchByPrice(price);
		model.addAttribute("hotelList", hotelList);
		return "search";
	}
}
