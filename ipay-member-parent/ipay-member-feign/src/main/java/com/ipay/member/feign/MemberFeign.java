package com.ipay.member.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipay.core.req.BaseReq;
import com.ipay.core.req.PageQueryReq;
import com.ipay.core.resp.BaseResp;
import com.ipay.core.resp.PageQueryResp;
import com.ipay.member.feign.model.Member;
import com.ipay.member.feign.query.MemberQuery;


@FeignClient(name="ipay-member-app",url="${ipay-member-app.url:}")
@RequestMapping("/members")
public interface MemberFeign {
	//分页查询用post，get会跟一堆参数
	@RequestMapping(value = "/getMembersByPage", method = RequestMethod.POST)
	PageQueryResp<List<Member>> getMembersByPage(@RequestBody PageQueryReq<MemberQuery> req);
	
	@RequestMapping(value = "/getMemberById", method = RequestMethod.POST)
    BaseResp<Member> getMemberById(@RequestBody BaseReq<Integer> req);
	
	@RequestMapping(value = "/updateMemberById", method = RequestMethod.POST)
    BaseResp<Integer> updateMemberById(@RequestBody BaseReq<Member> req);
	@RequestMapping(value = "/clearMemberCache", method = RequestMethod.POST)
	BaseResp<Void> clearMemberCache();
}
