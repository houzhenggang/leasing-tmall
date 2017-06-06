package com.hshc.relay.vo;

import com.hshc.relay.dto.Page;

/**
 * @author 钟林俊
 * @version V1.0 2017-05-26 16:42
 */
public class PageVo extends BaseResponseVo {

    private Page<?> page;

    private PageVo(Page<?> page, boolean success){
        this.page = page;
        setSuccess(success);
    }

    public static PageVo success(Page<?> page){
        return new PageVo(page, true);
    }

    public Page<?> getPage() {
        return page;
    }

    public void setPage(Page<?> page) {
        this.page = page;
    }
}
