package com.hshc.relay.controller.tmall;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hshc.relay.annotation.QimenSignAuthentication;
import com.hshc.relay.controller.BaseController;
import com.hshc.relay.controller.erp.ScitemController;
import com.hshc.relay.service.CarLeaseReserveService;
import com.hshc.relay.vo.BaseQimenResponseVo;
import com.taobao.api.request.TmallCarLeaseReserveRequest;
import com.taobao.api.request.TmallCarLeaseConsumeRequest.CosumeCodeReqDto;
import com.taobao.api.response.TmallCarLeaseReserveResponse;
/**
 * 整车租车回传预约信息
 * @author 史珂 2017年5月9日14:00:43
 *
 */
@Controller
public class CarLeaseReserveController extends BaseController {
    private static Logger LOGGER = LoggerFactory.getLogger(ScitemController.class);

    @Autowired
    private CarLeaseReserveService clrService;
    
	@RequestMapping("/lease-reserve")
	@ResponseBody
	@QimenSignAuthentication
	public BaseQimenResponseVo leaseReserve(@RequestBody String res){
		try {
			TmallCarLeaseReserveRequest req = JSON.parseObject(res,TmallCarLeaseReserveRequest.class);
			//获取返回参数
			TmallCarLeaseReserveResponse lr = clrService.leaseReserve(req);
			LOGGER.info("result:"+lr.getBody());
			//保存返回的数据
			clrService.addLeaseReserve(lr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new BaseQimenResponseVo("整车租车回传预约信息成功");
	}
}
