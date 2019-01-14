package com.hcdev.sgesc.api.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

	@Autowired
	protected MessageSource messageSource; 
}
