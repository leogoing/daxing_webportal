package com.yihuan.entity;

import java.io.Serializable;

public class Index implements Serializable{
	private Integer identity_id;
	
	public Integer getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(Integer identityId) {
		identity_id = identityId;
	}

	@Override
	public String toString() {
		return "Index [identity_id=" + identity_id + "]";
	}
	
}
