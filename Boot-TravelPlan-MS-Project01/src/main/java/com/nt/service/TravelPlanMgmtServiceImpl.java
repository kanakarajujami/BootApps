package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.config.AppConfigProperties;
import com.nt.entity.PlanCategory;
import com.nt.entity.TravelPlan;
import com.nt.repository.IPlanCategoryRepository;
import com.nt.repository.ITravelPlanRepository;
import com.ntconstants.TravelPlanConstants;
@Service("travelPlanService")
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	@Autowired
	private IPlanCategoryRepository categoryRepo;
	
	private Map<String,String> messages;
	@Autowired
	public TravelPlanMgmtServiceImpl(AppConfigProperties props) {
		messages=props.getMessages();
	}
	@Override
	public String enrollTravelPlan(TravelPlan plan) {
		  Integer planId= travelPlanRepo.save(plan).getPlanId(); 
		  return planId==null?messages.get(TravelPlanConstants.SAVE_FAILURE):messages.get(TravelPlanConstants.SAVE_SUCCESS)+planId;
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
	       List<PlanCategory> list=categoryRepo.findAll();
		   Map<Integer,String> planCategories=new HashMap<Integer,String>();
		   list.forEach(category->{
		        planCategories.put(category.getCategoryId(),category.getCategoryName());
		   });
		   return planCategories;
	}

	@Override
	public List<TravelPlan> showTravelPlans() {
	         return  travelPlanRepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		return travelPlanRepo.findById(planId).orElseThrow(()-> new IllegalArgumentException(messages.get(TravelPlanConstants.FIND_BY_ID_FAILURE)));
		}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
	   Optional<TravelPlan> opt=travelPlanRepo.findById(plan.getPlanId());
	   if(opt.isPresent()) {
		   TravelPlan savedPlan=opt.get();
		   travelPlanRepo.save(savedPlan);
		   return messages.get(TravelPlanConstants.UPDATE_SUCCESS)+savedPlan.getPlanId();
	   }
		return messages.get(TravelPlanConstants.UPDATE_FAILURE)+plan.getPlanId();
	}

	@Override
	public String updateTravelPlanStatus(Integer planId, String status) {
		 Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		 if(opt.isPresent()) {
			 TravelPlan plan=opt.get();
			 plan.setActiveSW(status);
			 travelPlanRepo.save(plan);
			 return messages.get(TravelPlanConstants.STATUS_CHANGE_SUCCESS)+planId;
		 }
		return messages.get(TravelPlanConstants.STATUS_CHANGE_FAILURE)+planId;
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		 Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		 if(opt.isPresent()) {
			 TravelPlan plan=opt.get();
			 travelPlanRepo.delete(plan);
			 return messages.get(TravelPlanConstants.DELETE_SUCCESS)+planId;
		 }
		  return planId+"::"+ messages.get(TravelPlanConstants.DELETE_FAILURE);
	 }

}
