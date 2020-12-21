package com.cognizant.identifyprofiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.identifyprofiles.clients.ProfileClient;
import com.cognizant.identifyprofiles.exception.ProductTypeNotFoundException;
import com.cognizant.identifyprofiles.model.Orders;
import com.cognizant.identifyprofiles.model.Product;
import com.cognizant.identifyprofiles.model.Profile;

@Service
public class IdentifyProfilesServiceImpl implements IdentifyProfilesService {

	@Autowired
	private ProfileClient profileClient;

	@Override
	public Orders matchProfile(Orders orders) throws ProductTypeNotFoundException {
		List<Product> productList = orders.getProducts();
		List<Profile> profileList = profileClient.getAllProfiles();
		for (Product p : productList) {
			String productType = p.getProductType();
			for (Profile p2 : profileList) {
				if (p2.getProfiletype().equalsIgnoreCase(productType)) {
					p.setReturnpolicy(p2.getReturnpolicy());
					p.setWarranty(p2.getWarranty());
					p.setExpiry(p2.getExpiry());
					p.setFragility(p2.getFragility());
					break;
				}
			}
		}
		orders.setProducts(productList);
		return orders;
	}

}
