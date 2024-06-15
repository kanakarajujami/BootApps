package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.TravelPlan;

public interface ITravelPlanMgmtService {
public String enrollTravelPlan(TravelPlan plan);
public Map<Integer,String> getTravelPlanCategories();
public List<TravelPlan> showTravelPlans();
public TravelPlan showTravelPlanById(Integer planId);
public String updateTravelPlan(TravelPlan plan);
public String updateTravelPlanStatus(Integer planId,String status);
public String deleteTravelPlan(Integer planId);
}
