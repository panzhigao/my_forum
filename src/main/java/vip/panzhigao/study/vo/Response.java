package vip.panzhigao.study.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author panzhigao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private int code;

    private T data;

    private String msg;

    private Response(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Response(IResultCode resultCode, T data) {
        this(resultCode.getCode(), data, resultCode.getMessage());
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(ResultCode.SUCCESS, data);
    }

    public static <T> Response<T> success(T data,String msg) {
        return new Response<>(ResultCode.SUCCESS, data,msg);
    }

    public static <T> Response<T> success(String msg) {
        return new Response<>(ResultCode.SUCCESS, null,msg);
    }

    public static <T> Response<T> fail() {
        return new Response<>(ResultCode.FAILURE, null,ResultCode.FAILURE.message);
    }

    public static <T> Response<T> fail(T data) {
        return new Response<>(ResultCode.FAILURE, data);
    }

    public static <T> Response<T> fail(T data,String msg) {
        return new Response<>(ResultCode.FAILURE, data,msg);
    }

    public static <T> Response<T> fail(String msg) {
        return new Response<>(ResultCode.FAILURE,null,msg);
    }

}
