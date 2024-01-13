package com.ssafy.hw;

import org.springframework.stereotype.Component;

@Component
public class VipUser implements User {

	@Override
	public String getRank() {
		return "Vip";
	}

}
