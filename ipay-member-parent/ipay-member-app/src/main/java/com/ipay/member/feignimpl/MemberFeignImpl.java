package com.ipay.member.feignimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.ipay.core.req.BaseReq;
import com.ipay.core.req.PageQueryReq;
import com.ipay.core.resp.BaseResp;
import com.ipay.core.resp.PageQueryResp;
import com.ipay.member.dao.criteria.MemberCriteria;
import com.ipay.member.dao.model.MemberDO;
import com.ipay.member.feign.MemberFeign;
import com.ipay.member.feign.model.Member;
import com.ipay.member.feign.query.MemberQuery;
import com.ipay.member.service.MemberService;

@RestController
public class MemberFeignImpl implements MemberFeign{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
	
	@Autowired
	MemberService memberService;
	
	@Override
	public PageQueryResp<List<Member>> getMembersByPage(@RequestBody PageQueryReq<MemberQuery> req) {
		logger.info("{}",req);
		PageQueryResp<List<Member>> rep=null;
//		try{
		//TODO 请求校验
		MemberQuery memberQueryReq=req.getData();
		//封装请求参数
		MemberCriteria memberCriteria=new MemberCriteria();
		memberCriteria.setMemberName(memberQueryReq.getMemberName());
		memberCriteria.setMemberType(memberQueryReq.getMemberType());
		memberCriteria.setStatus(memberQueryReq.getStatus());
		//调用接口
		Page<MemberDO> memberDOPage=
				memberService.getUsersByPage(memberCriteria, req.getPageNum(), req.getPageSize());

		//封装返回参数
		ArrayList<Member> memberResult=new ArrayList<Member>();
		for(MemberDO memberDO:memberDOPage){
			Member member=new Member();
			BeanUtils.copyProperties(memberDO, member);
			memberResult.add(member);
		}
		
		rep=new PageQueryResp<List<Member>>(memberResult,memberDOPage.getPageNum()
				,memberDOPage.getPageSize(),memberDOPage.getTotal(),memberDOPage.getPages());
			
//		}
//		catch(ReturnCodeException e1){
//			rep= new PageQueryResp<List<Member>>(e1);
//		}
//		catch(Exception e2){
//			logger.error("unknow error",e2);
//			rep=new PageQueryResp<List<Member>>(new ReturnCodeException(ReturnCode.ERROR, e2.getMessage()));
//		}
		logger.info("{}",rep);
		return rep;
	}

	@Override
	public BaseResp<Member> getMemberById(@RequestBody BaseReq<Integer> req) {
		MemberDO userDO= memberService.getUserById(req.getData());
		Member user=new Member();
		BeanUtils.copyProperties(userDO, user);
		BaseResp<Member> resp=new BaseResp<Member>(user);
		return resp;
	}

	@Override
	public BaseResp<Integer> updateMemberById(@RequestBody BaseReq<Member> req) {
		Member user=req.getData();
		MemberDO userDO=new MemberDO();
		BeanUtils.copyProperties(user,userDO);
		Integer num=memberService.updateMemberById(userDO);
		BaseResp<Integer> resp=new BaseResp<Integer>(num);
		return resp;
	}

	@Override
	public BaseResp<Void> clearMemberCache() {
		memberService.reloadMember();
		return new BaseResp<Void>();
	}

}
