package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.RefundDetail;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * TOP API: taobao.fenxiao.refund.query response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class FenxiaoRefundQueryResponse extends TaobaoResponse {

	private static final long serialVersionUID = 5365186474357763128L;

	/** 
	 * 代销采购退款列表
	 */
	@ApiListField("refund_list")
	@ApiField("refund_detail")
	private List<RefundDetail> refundList;

	/** 
	 * 按查询条件查到的记录总数
	 */
	@ApiField("total_results")
	private Long totalResults;


	public void setRefundList(List<RefundDetail> refundList) {
		this.refundList = refundList;
	}
	public List<RefundDetail> getRefundList( ) {
		return this.refundList;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}
	public Long getTotalResults( ) {
		return this.totalResults;
	}
	


}
