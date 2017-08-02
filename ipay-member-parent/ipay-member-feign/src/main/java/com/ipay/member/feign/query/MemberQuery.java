package com.ipay.member.feign.query;

import com.ipay.core.BaseObj;


public class MemberQuery extends BaseObj{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String memberName;

    private Integer memberType;

    private Integer status;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
