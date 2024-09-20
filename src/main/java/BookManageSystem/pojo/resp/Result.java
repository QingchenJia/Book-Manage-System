package BookManageSystem.pojo.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("success");

        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);

        return result;
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);

        return result;
    }
}
