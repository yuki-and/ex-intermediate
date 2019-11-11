package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * clothesテーブルを操作するリポジトリ.
 * 
 * @author yukiando
 *
 */
@Repository
public class ClothRepository {

	@Autowired
	NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = (rs, i) ->{
		Cloth cloth = new Cloth();
		cloth.setId(rs.getInt("id"));
		cloth.setCategory(rs.getString("category"));
		cloth.setGenre(rs.getString("genre"));
		cloth.setGender(rs.getInt("gender"));
		cloth.setColor(rs.getString("color"));
		cloth.setPrice(rs.getInt("price"));
		cloth.setSize(rs.getString("size"));
		return cloth;
	};
	
	/**
	 * 性別とカラーから衣服情報を取得する.
	 * 
	 * @param gender 性別
	 * @param color　カラー
	 * @return　衣服情報リスト
	 */
	public List<Cloth> findByGenderAndColor(Integer gender, String color){
		String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE gender = :gender AND color = :color";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		return template.query(sql, param, CLOTH_ROW_MAPPER);
	}
}
