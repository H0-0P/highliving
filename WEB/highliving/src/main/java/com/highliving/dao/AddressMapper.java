package com.highliving.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.highliving.pojo.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    
    List<Address> findByUserId(Integer userId);
    
    void updateByUserId(Address address);
    
    void deleteByUserId(Integer userId);
    
    Address selectByUserId(Integer userid);
}