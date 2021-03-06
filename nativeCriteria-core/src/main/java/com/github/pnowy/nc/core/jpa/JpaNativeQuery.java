package com.github.pnowy.nc.core.jpa;

import com.github.pnowy.nc.core.NativeQuery;
import com.github.pnowy.nc.core.NativeQuery;
import com.github.pnowy.nc.core.QueryInfo;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * JPA implementation of native query.
 * 
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.07.13 00:12
 */
public class JpaNativeQuery implements NativeQuery
{
	private Query query;
	private QueryInfo queryInfo;

	public JpaNativeQuery(String sql, Query sqlQuery)
	{
		this.queryInfo = new QueryInfo(sql);
		this.query = sqlQuery;
	}

	@Override
	public List list()
	{
		return query.getResultList();
	}

	@Override
	public Object uniqueResult()
	{
		return query.getSingleResult();
	}

	@Override
	public NativeQuery setMaxResults(int maxResults)
	{
		query.setMaxResults(maxResults);
		return this;
	}

	@Override
	public NativeQuery setFirstResult(int firstResult)
	{
		query.setFirstResult(firstResult);
		return this;
	}

	@Override
	public NativeQuery setParameter(String name, Object val)
	{
		queryInfo.getParameters().put(name, val);
		query.setParameter(name, val);
		return this;
	}

	@Override
	public NativeQuery setString(String name, String value)
	{
		queryInfo.getParameters().put(name, value);
		query.setParameter(name, value);
		return this;
	}

	@Override
	public NativeQuery setParameterList(String name, Collection values)
	{
		queryInfo.getParameters().put(name, values);
		query.setParameter(name, values);
		return this;
	}

	@Override
	public NativeQuery setParameterList(String name, Object[] values)
	{
		queryInfo.getParameters().put(name, values);
		query.setParameter(name, values);
		return this;
	}

	@Override
	public QueryInfo getQueryInfo()
	{
		return queryInfo;
	}
}
