package com.ipay.member;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ipay.member.dao.criteria.MemberCriteria;
import com.ipay.member.dao.mapper.MemberDOMapper;
import com.ipay.member.dao.model.MemberDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberApplicationTests {
	@Autowired
	MemberDOMapper memberDOMapper;
	@Test
	public void testMemberDOMapper() {
		PageHelper.startPage(1, 20);
		List<MemberDO> memberDOList= memberDOMapper.selectByCriteria(new MemberCriteria());
		System.out.println("Total: " + ((Page<MemberDO>) memberDOList).getTotal());
        for (MemberDO country : memberDOList) {
            System.out.println("=============: " + country.getMemberName());
        }
	}

}
