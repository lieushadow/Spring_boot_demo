package cn.liuminhua.demo.model;

/**
 * Created by lmh on 2016/9/18.
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;
    private long time;


    public static Result SuccessResult() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("hello,刘敏华");
        return result;
    }

    public static Result SuccessResult(String msg) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result SuccessResult(String msg, T data) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static Result FaildResult() {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求失败");
        return result;
    }

    public static Result FaildResult(int status, String msg) {
        Result result = new Result();
        result.setCode(status);
        result.setMsg(msg);
        return result;
    }


    public Result() {
        this.time = System.currentTimeMillis();
    }

    public Result(int code, String msg, T data, long time) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
