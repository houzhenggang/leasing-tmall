package com.taobao.api.response;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.FenxiaoItemRecord;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * TOP API: taobao.fenxiao.distributor.items.get response.
 * 
 * @author top auto create
 * @since 1.0, null
 */
public class FenxiaoDistributorItemsGetResponse extends TaobaoResponse {

	private static final long serialVersionUID = 1188147293968477853L;

	/** 
	 * 下载记录对象
	 */
	@ApiListField("records")
	@ApiField("fenxiao_item_record")
	private List<FenxiaoItemRecord> records;

	/** 
	 * 查询结果记录数
	 */
	@ApiField("total_results")
	private Long totalResults;


	public void setRecords(List<FenxiaoItemRecord> records) {
		this.records = records;
	}
	public List<FenxiaoItemRecord> getRecords( ) {
		return this.records;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}
	public Long getTotalResults( ) {
		return this.totalResults;
	}
	


}
