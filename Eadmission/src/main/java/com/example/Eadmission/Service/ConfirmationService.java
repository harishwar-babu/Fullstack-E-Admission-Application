
package com.example.Eadmission.Service;

import java.util.List;

import com.example.Eadmission.Model.ConfirmationModel;

public interface ConfirmationService {
	
	public String SuccessMessage(ConfirmationModel detail);
	
	boolean Checker(String appid, String code);
	
	public List<ConfirmationModel> choices();
}
