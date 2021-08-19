package com.food.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.food.view")
public class CommonExceptionHandler {
	
	/*@ExceptionHandler(AException.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("errorA.jsp");
		return mav;
		
	}
	*/
	
	
	
	// �߰��ϰ� �ʹٸ� �ش� ���ܸ� �߰��ϸ� �ȴ�. 
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("controllerError/error.jsp");
	
		return mav;
		
	}
	
}
