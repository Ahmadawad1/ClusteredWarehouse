package com.progresssoft.warehouse.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresssoft.warehouse.common.Constants;
import com.progresssoft.warehouse.common.Logger;
import com.progresssoft.warehouse.common.ResponseType;
import com.progresssoft.warehouse.dto.DealDTO;
import com.progresssoft.warehouse.repository.DealRepository;

@Service
public class DealsService {
  
  Logger logger = Logger.getInstance(); 
  
  @Autowired
  private DealRepository repo;
  
  public DealDTO getDealById(long id) {
  	  logger.log(Constants.DEAL_API_CONSUME);
	  DealDTO dealDetails = repo.findById(id).orElse(new DealDTO());
      return dealDetails;
  }
  
  public ResponseType save(DealDTO deal) {
	  try {
		  if (getDealById(deal.getId()) == null) {
			  if (repo.save(deal) != null){
				  return ResponseType.Success;
			  }
		  	  logger.log(Constants.GENERIC_ERROR_MESSAGE);
		      return ResponseType.InternalError;
		  }
		  return ResponseType.AlreadyExisted;
	  } catch(Exception e) {
	  	  logger.log(e.getMessage());
		  return ResponseType.InternalError;
	  }
    
  }
}

