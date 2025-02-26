package com.project.common.hc.filter;

import com.project.common.hc.http.FRequest;
import com.project.common.hc.http.FResponse;

public interface Filter {
    void beforeExecute(FRequest var1);

    void afterExecute(FRequest var1, FResponse var2);
}
