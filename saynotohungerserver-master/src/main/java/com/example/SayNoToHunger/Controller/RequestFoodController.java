package com.example.SayNoToHunger.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.SayNoToHunger.Model.Requestfood;
import com.example.SayNoToHunger.ServiceLayer.InterfacesSL.IRequestFoodService;

@CrossOrigin
@RestController
public class RequestFoodController{

	@Autowired
	IRequestFoodService requestFoodService;
	

    @RequestMapping("/getRequestfood")
    List<Requestfood> GetRequestfood(int receiverId) {
		
        return requestFoodService.GetRequestfood(receiverId);
    }

    @RequestMapping(value = "/insertrequestfood", method = RequestMethod.POST)
    Integer InsertRequestfood(@RequestBody Requestfood foodrequest){
        return requestFoodService.InsertRequestfood(foodrequest);
    }
	
}
