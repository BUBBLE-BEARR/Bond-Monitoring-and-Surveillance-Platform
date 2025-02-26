package com.project.common.core.exception.rsa;

import com.project.common.core.exception.base.BaseException;

/**
 * 	加密参数为空异常类
 * 
 * @author yangyc
 */
public class RSAEncrpyParamNullException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public RSAEncrpyParamNullException(String defaultMessage)
    {
        super("rsa.encrpy.param.null", defaultMessage);
    }
}
