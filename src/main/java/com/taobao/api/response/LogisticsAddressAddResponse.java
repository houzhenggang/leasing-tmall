package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.AddressResult;
import com.taobao.api.internal.mapping.ApiField;

/**
 * TOP API: taobao.logistics.address.add response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class LogisticsAddressAddResponse extends TaobaoResponse {

	private static final long serialVersionUID = 4251765722789796938L;

	/** 
	 * 只返回修改日期modify_date
	 */
	@ApiField("address_result")
	private AddressResult addressResult;


	public void setAddressResult(AddressResult addressResult) {
		this.addressResult = addressResult;
	}
	public AddressResult getAddressResult( ) {
		return this.addressResult;
	}
	


}
