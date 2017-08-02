package com.ipay.omp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipay.core.req.BaseReq;
import com.ipay.core.req.PageQueryReq;
import com.ipay.core.resp.PageQueryResp;
import com.ipay.core.util.UUIDUtil;
import com.ipay.member.feign.model.Member;
import com.ipay.member.feign.query.MemberQuery;
import com.ipay.omp.OmpConfig;
import com.ipay.omp.feignclient.MemberClient;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	OmpConfig ompConfig;
    @Autowired
    MemberClient memberClient;
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String hello(Model model,@PathVariable Integer id) {
    	BaseReq<Integer> req=new BaseReq<Integer>(UUIDUtil.randomUUIDStr(),ompConfig.getSpringApplicationName(), id);
        model.addAttribute("mainData",memberClient.getUserById(req));
        return "member/hello";
    }
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public String query(Model model,Integer pageNum,Integer pageSize) {
    	MemberQuery memberQuery=new MemberQuery();
    	memberQuery.setMemberName("test1501161784");
    	PageQueryReq<MemberQuery> req=new PageQueryReq<MemberQuery>(UUIDUtil.randomUUIDStr(),ompConfig.getSpringApplicationName(),memberQuery);
    	if(pageSize!=null){
    		req.setPageSize(pageSize);
    	}
    	if(pageNum!=null){
    		req.setPageNum(pageNum);
    	}
    	PageQueryResp<List<Member>> resp= memberClient.getUsersByUser(req);
        model.addAttribute("mainData", resp);
        return "member/query";
    }
   

}
