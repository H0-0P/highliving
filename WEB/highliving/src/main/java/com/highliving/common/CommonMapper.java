package com.highliving.common;

public interface CommonMapper<T> {
	T findById(int id);
	T updateById(int id);
	void insert(T t);
}
