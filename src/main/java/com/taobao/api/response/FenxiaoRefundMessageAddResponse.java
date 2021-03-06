package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.mapping.ApiField;

/**
 * TOP API: taobao.fenxiao.refund.message.add response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class FenxiaoRefundMessageAddResponse extends TaobaoResponse {

	private static final long serialVersionUID = 7639182675222694941L;

	/** 
	 * 退款是否创建成功
	 */
	@ApiField("is_success")
	private Boolean isSuccess;


	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Boolean getIsSuccess( ) {
		return this.isSuccess;
	}
	


}
