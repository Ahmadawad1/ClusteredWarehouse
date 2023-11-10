package com.progresssoft.warehouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.progresssoft.warehouse.bll.DealsService;
import com.progresssoft.warehouse.dto.DealDTO;
import com.progresssoft.warehouse.common.Constants;
import com.progresssoft.warehouse.common.Logger;
import com.progresssoft.warehouse.common.ResponseType;
import java.time.Instant;

@Controller
public class DealController {
   
	@Autowired
	private DealsService dealsService;
	
	Logger logger = Logger.getInstance();    
	
    @GetMapping("/deal")       
    public ModelAndView deal() {
    	logger.log(Constants.DEAL_API_CONSUME);
        ModelAndView mav = new ModelAndView("deal");
        mav.addObject("dealDetails", new DealDTO());
        return mav;
    }
    
    @PostMapping("/deal")
    public ModelAndView deal(@ModelAttribute("dealDetails") DealDTO dealDetails ) { 
    	logger.log(Constants.DEAL_API_CONSUME);
    	DealDTO deal = new DealDTO(dealDetails.getDealId(), dealDetails.getFromCurrency(), dealDetails.getToCurrency(), Instant.now(), dealDetails.getAmount());
        ModelAndView mav = new ModelAndView(getViewName(dealsService.save(deal)));
        return mav;
    }
    
    private String getViewName(ResponseType response) {
    	String viewName = null;
    	
    	switch (response){
			case Success:
				viewName = "deal";
				break;
			case InternalError:
				viewName = "error";
				break;
			case NotFound:
				viewName = "error";
				break;
			case AlreadyExisted:
				viewName = "error";
				break;
    	}
    	
    	return viewName;
    }


}