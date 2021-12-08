package com.example.ltwnhom10.paging;

import com.example.ltwnhom10.sort.Sorter;

public interface Pageable {
    Integer getPage();
    Integer getOffset();
    Integer getLimit();
    Sorter getSorter();
}
