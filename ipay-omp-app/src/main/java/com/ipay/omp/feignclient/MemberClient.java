package com.ipay.omp.feignclient;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipay.core.req.BaseReq;
import com.ipay.core.req.PageQueryReq;
import com.ipay.core.resp.BaseResp;
import com.ipay.core.resp.PageQueryResp;
import com.ipay.member.feign.MemberFeign;
import com.ipay.member.feign.model.Member;
import com.ipay.member.feign.query.MemberQuery;

@Service
public class MemberClient {
	private Logger logger = LoggerFactory.getLogger(MemberClient.class);
	@Autowired
	MemberFeign memberFeign;

	public PageQueryResp<List<Member>> getUsersByUser(PageQueryReq<MemberQuery> req){
		logger.info("{}",req);
		PageQueryResp<List<Member>> resp=memberFeign.getMembersByPage(req);
		logger.info("{}",resp);
		return resp;
	};
	public BaseResp<Member> getUserById(BaseReq<Integer> req){
		logger.info("{}",req);
		BaseResp<Member> resp= memberFeign.getMemberById(req);
		logger.info("{}",resp);
    	return resp;
    }
}
