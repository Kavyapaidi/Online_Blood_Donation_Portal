package com.kavyasri.bdp.service;


import java.util.List;

import com.kavyasri.bdp.payload.HealthHistoryDto;


public interface HealthHistoryService {
	public HealthHistoryDto saveHistory(long userid,HealthHistoryDto Hhdto);
	public List<HealthHistoryDto> getHistory(long userid);
	public List<HealthHistoryDto> getHistoryByGender(String gender);
}
