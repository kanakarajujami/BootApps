package com.nt.ms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.TravelPlan;
import com.nt.service.TravelPlanMgmtServiceImpl;

@RestController
@RequestMapping("travelplan-api")
public class TravelPlanOperationsController {
  @Autowired	
  private TravelPlanMgmtServiceImpl travelPlanService;	
   @PostMapping("/save")
  public ResponseEntity<String> registerTravelPlan(@RequestBody TravelPlan plan){
    try
        {
    	   String msg=travelPlanService.enrollTravelPlan(plan);
	       return new ResponseEntity<String>(msg,HttpStatus.OK);
	     }
    catch(Exception e)
    {
    	e.printStackTrace();
    	return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }//end of register travel method
   @GetMapping("/categories")
   public ResponseEntity<?> getAllTravelPlanCategories(){
	  try
	    {
		  Map<Integer,String> planCategories=travelPlanService.getTravelPlanCategories();
		  return new ResponseEntity<Map<Integer,String>>(planCategories,HttpStatus.OK);
	   }catch(Exception e) 
	   {
		   e.printStackTrace();
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	   }
   }//end of getAllTravelPlanCategories()
   @GetMapping("/findAll")
   public ResponseEntity<?> getAllTravelPlans(){
	   try 
	   {
		   List<TravelPlan> listPlans=travelPlanService.showTravelPlans();
		   return new ResponseEntity<List<TravelPlan>>(listPlans,HttpStatus.OK);
	   }catch(Exception e) 
	   {
		   e.printStackTrace();
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	   }
   }//getAllTravelPlans() method
   @PutMapping("/update")
   public ResponseEntity<String> UpdateTravelPlan(@RequestBody TravelPlan plan){
	  try
	     {
		   String msg=travelPlanService.updateTravelPlan(plan);
		   return new ResponseEntity<String>(msg,HttpStatus.OK);
	     }catch(Exception e) 
	   {
			   e.printStackTrace();
			   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		   }
   }//updateTravelPlan()...
   @GetMapping("/travelplan/{planId}")
   public ResponseEntity<?> showTravelPlanById(@PathVariable Integer planId){
	  try 
	  {
		 TravelPlan plan=travelPlanService.showTravelPlanById(planId) ;
		 return new ResponseEntity<TravelPlan>(plan,HttpStatus.OK);
	  } catch(Exception e) 
	   {
		   e.printStackTrace();
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	  
   }//end of showTravelPlanById().....
   @PatchMapping("/partialUpdate/{planId}/{status}")
   public ResponseEntity<String> updateTravelPlanStatusById(@PathVariable Integer planId,@PathVariable String status){
	   try
	   {
		  String msg=travelPlanService.updateTravelPlanStatus(planId, status) ;
		  return new ResponseEntity<String>(msg,HttpStatus.OK);
	   }catch(Exception e) 
	   {
		   e.printStackTrace();
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	   }
   }//end of updateTravelPlanStatus()
   @DeleteMapping("/delete/{planId}")
   public ResponseEntity<String> deleteTravelPlanById(@PathVariable Integer planId){
	   try 
	   {
		   String msg=travelPlanService.deleteTravelPlan(planId);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
	   }catch(Exception e) 
	   {
		   e.printStackTrace();
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	   }
   }//end of deleteTravelPlan()....
}
