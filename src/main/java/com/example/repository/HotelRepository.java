package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * 
 * hotelsテーブルを操作するリポジトリ.
 * 
 * @author yukiando
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};

	/**
	 * ホテル情報を価格が低い順で全件取得する.
	 * 
	 * @return ホテルリスト
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price";
		return template.query(sql, HOTEL_ROW_MAPPER);
	}

	/**
	 * 価格から価格が低い順にホテル情報を取得する.
	 * 
	 * @param price 価格
	 * @return ホテルリスト
	 */
	public List<Hotel> findByPrice(Integer price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ORDER BY price";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
}
