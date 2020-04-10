package just.met.designpattern.design4.impl;

import lombok.Data;

/**
 * @author wangmaogang
 */

public enum StrategyType {

    STRATEGY_A("1","STRATEGY_A"),
    STRATEGY_B("2","STRATEGY_B"),
    STRATEGY_C("3","STRATEGY_C");

    private String id;
    private String type;

    StrategyType(String id,String type){
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
