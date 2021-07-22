package cn.itsource.springboot.query;

import lombok.Data;

@Data
public class BaseQuery {
    private Integer currentPage = 1;
    private Integer pageSize = 5;



    public void setNumber(Integer number){
        this.currentPage = number;
    }
}
