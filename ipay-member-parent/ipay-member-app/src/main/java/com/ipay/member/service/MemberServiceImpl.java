package com.ipay.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

	@Override
	@CacheEvict(value="member",key="#record.getMemberId()")
	public Integer updateMemberById(MemberDO record) {
		return memberDOMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@CacheEvict(value="member",allEntries=true)
	public void reloadMember() {
	}
}
