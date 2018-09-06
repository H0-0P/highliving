package com.highliving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.highliving.dao.AddressMapper;
import com.highliving.pojo.Address;

@Service
public class AddressService{
	
	@Autowired
	private AddressMapper addressMapper;

	
	public List<Address> findByUserId(Integer userId) {
		List<Address> list = addressMapper.findByUserId(userId);
		return list;
	}

	public int updateById(Address address) {
		return addressMapper.updateByPrimaryKey(address);
	}
	 
	public int deleteById(Integer addressId) {
		return addressMapper.deleteByPrimaryKey(addressId);
	}
	
	public int insert(Address address) {
		return addressMapper.insert(address);
	}
	
	public Address findDefaultAddress(Integer addressid) {
		return addressMapper.selectByPrimaryKey(addressid);
	}
	
	public Address findFristAddress(Integer userid) {
		return addressMapper.selectByUserId(userid);
	}
}
