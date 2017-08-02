package com.ipay.member.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ipay.member.dao.criteria.MemberCriteria;
import com.ipay.member.dao.model.MemberDO;
@Mapper
public interface MemberDOMapper {
    int deleteByPrimaryKey(Integer memberId);

    int insert(MemberDO record);

    int insertSelective(MemberDO record);
    
    List<MemberDO> selectByCriteria(MemberCriteria criteria);
    
    MemberDO selectByPrimaryKey(Integer memberId);

    int updateByPrimaryKeySelective(MemberDO record);

    int updateByPrimaryKey(MemberDO record);
}