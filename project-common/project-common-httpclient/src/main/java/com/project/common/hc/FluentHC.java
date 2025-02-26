package com.project.common.hc;
import com.project.common.hc.http.FRequest;
import com.project.common.hc.http.IFRequest;
import com.project.common.hc.specific.HtFRequest;
import okhttp3.Call.Factory;

public class FluentHC {
    private final Factory client;

    public FluentHC(Factory client) {
        this.client = client;
    }

    public IFRequest call() {
        FRequest fRequest = new FRequest(this.client);
        return  fRequest;
    }

    public IFRequest htCall() {
        HtFRequest htFRequest = new HtFRequest(this.client);
        return htFRequest;
    }
}
