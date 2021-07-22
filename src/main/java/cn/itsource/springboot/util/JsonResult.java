package cn.itsource.springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    private Boolean success = true;
    private String msg;

    public JsonResult(String msg){
        this.msg = msg;
    }


}
