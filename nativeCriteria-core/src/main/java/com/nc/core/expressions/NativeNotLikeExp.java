package com.nc.core.expressions;

import org.apache.commons.lang3.StringUtils;
import com.nc.core.QueryProvider;
import com.nc.utils.VarGenerator;

/**
 * Native NOT LIKE expression.
 */
public class NativeNotLikeExp implements NativeExp
{
	private String columnName;
	private String varName;
	private String value;
	
	/**
	 *
	 * @param columnName the column name
	 * @param value the value
	 */
	public NativeNotLikeExp(String columnName, String value)
	{
		if (StringUtils.isBlank(columnName))
			throw new IllegalStateException("columnName is null!");
		if (StringUtils.isBlank(value))
			throw new IllegalStateException("value is null!");
		
		this.columnName = columnName;
		this.value = value;
	}
	
	@Override
	public String toSQL()
	{
		varName = VarGenerator.gen(columnName);
		return columnName + " NOT LIKE ?";
	}

	@Override
	public void setValues(QueryProvider query)
	{
		query.setString(varName, value);
	}

//	@Override
//	public void setValues(SQLQuery query)
//	{
//		query.setString(varName, value);
//	}
}