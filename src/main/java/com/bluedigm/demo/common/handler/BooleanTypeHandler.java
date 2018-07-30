package com.bluedigm.demo.common.handler;

import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Alias("BooleanTypeHandler")
@MappedTypes(Boolean.class)
public class BooleanTypeHandler extends BaseTypeHandler<Boolean> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, convert(parameter));
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return convert(rs.getString(columnName));
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return convert(rs.getString(columnIndex));
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return convert(cs.getString(columnIndex));
	}

	private String convert(Boolean b) {
		return b ? "Y" : "N";
	}

	private Boolean convert(String s) {
		return s.equals("Y") || s.equals("1");
	}
}
