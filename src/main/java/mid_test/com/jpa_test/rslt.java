package mid_test.com.jpa_test;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class rslt<T> {

    public rslt(String code, String msg) {
        this.msg = msg;
        this.code = code;
        this.status = (code == "success") ? true : false;
    }

    public rslt(boolean success, String msg) {
        this.msg = msg;
        this.code = (success) ? "success" : "error";
        this.status = success;
    }

    public rslt(boolean success, String msg, List<T> datalist) {
        this.code = (success) ? "success" : "error";
        this.msg = msg;
        this.status = success;
        this.datalist = datalist;
    }

    public rslt(boolean success, String msg, T data) {
        this.code = (success) ? "success" : "error";
        this.msg = msg;
        this.status = success;
        this.data = data;
    }

    private String msg;
    private String code;
    private Boolean status;

    private T data;
    private List<T> datalist;
}
