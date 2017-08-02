package com.ipay.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ipay.member.dao.criteria.MemberCriteria;
import com.ipay.member.dao.mapper.MemberDOMapper;
import com.ipay.member.dao.model.MemberDO;
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDOMapper memberDOMapper;
	
	
	@Override
	@Cacheable("member")
	public MemberDO getUserById(Integer id) {
		return memberDOMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<MemberDO> getUsersByPage(MemberCriteria criteria,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (Page<MemberDO>)memberDOMapper.selectByCriteria(criteria);
	}
}
