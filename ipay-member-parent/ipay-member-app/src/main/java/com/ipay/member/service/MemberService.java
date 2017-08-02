package com.ipay.member.service;

import com.github.pagehelper.Page;
import com.ipay.member.dao.criteria.MemberCriteria;
import com.ipay.member.dao.model.MemberDO;
public interface MemberService {
	Page<MemberDO> getUsersByPage(MemberCriteria memberQuery,int pageNum,int pageSize);
	MemberDO getUserById(Integer id);
}
