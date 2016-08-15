package com.wli.seckill.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wli.seckill.dto.Exporser;
import com.wli.seckill.dto.SeckillExecution;
import com.wli.seckill.dto.SeckillResut;
import com.wli.seckill.exception.DataRewriteException;
import com.wli.seckill.exception.RepeatSkillException;
import com.wli.seckill.exception.SeckillClosedException;
import com.wli.seckill.myenum.SeckillStatus;
import com.wli.seckill.po.Seckill;
import com.wli.seckill.service.SeckillService;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

	@Autowired
	private SeckillService seckillService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 秒杀商品列表
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Seckill> list = seckillService.queryList();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
		if (seckillId == null) {
			return "redirect:/seckill/list";
		}

		Seckill seckill = seckillService.queryById(seckillId);
		if (seckill == null) {
			return "redirect:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	@RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public SeckillResut<Exporser> exposer(@PathVariable("seckillId") long seckillId) {
		SeckillResut<Exporser> result;
		try {
			Exporser exporser = seckillService.exporseSeckillUrl(seckillId);
			result = new SeckillResut<Exporser>(true, exporser);
		} catch (Exception e) {
			logger.info("错误={}", e.getMessage());
			result = new SeckillResut<Exporser>(false, e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/{seckillId}/{md5}/execution",
					method = RequestMethod.POST, 
					produces = "application/json;charset=utf-8")
	@ResponseBody
	public SeckillResut<SeckillExecution> execute(@PathVariable("seckillId") long seckillId,
			@PathVariable("md5") String md5, @CookieValue(value = "userPhone", required = false) Long userPhone) {
		if (userPhone == null) {
			return new SeckillResut<SeckillExecution>(false, "未注册");
		}
		SeckillResut<SeckillExecution> result;
		try {
			SeckillExecution execution = seckillService.executeSkill(seckillId, md5, userPhone);
			result = new SeckillResut<SeckillExecution>(true, execution);
		} catch (SeckillClosedException e) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatus.END);
			return new SeckillResut<SeckillExecution>(true, execution);
		} catch (RepeatSkillException e) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatus.REPEAT_KILL);
			return new SeckillResut<SeckillExecution>(true, execution);
		} catch (DataRewriteException e) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatus.REWRITE);
			return new SeckillResut<SeckillExecution>(true, execution);
		} catch (Exception e) {
			SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatus.ERROR);
			return new SeckillResut<SeckillExecution>(true, execution);
		}
		return result;
	}
	
	//获取服务器时间
	@RequestMapping(value="/nowTime",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	@ResponseBody
	public SeckillResut<Long> nowTime(){
		Date now=new Date();
		return new SeckillResut<Long>(true, now.getTime());
	}
	
	@RequestMapping(value="/login",
			method=RequestMethod.GET
			)
	@ResponseBody
	public Map login(){
		System.out.println("enter");
		Map map=new HashMap();
		map.put("success",false);
		return map;
	}
	
	

}
