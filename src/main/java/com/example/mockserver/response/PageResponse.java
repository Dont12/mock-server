package com.example.mockserver.response;

public class PageResponse {
    private Long size;
    private Long maxPage;
    private Long totalCount;

    public PageResponse() {
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Long maxPage) {
        this.maxPage = maxPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
