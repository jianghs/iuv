package me.jianghs.iuv.domain.product.domain;

import lombok.Data;

/**
 * @className: PolicyRule
 * @description: 投保规则
 * @author: jianghs430
 * @createDate: 2020/12/22 16:26
 * @version: 1.0
 */
@Data
public class PolicyRule {
    /**
     * 规则编码
     */
    private String code;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 规则
     */
    private String rule;

    /**
     * 是否通过
     */
    private boolean passed;

    /**
     * 规则提示语
     */
    private String msg;


    /**
     * 运行规则
     * @return
     */
    public boolean run() {
        /*
        * mock 规则运行， rule非空表示通过
        * 运行完设置提示语
        * */
        if (rule == null || "".equals(rule)) {
            this.msg = "未通过";
            this.passed = false;
        } else {
            this.passed = true;
            this.msg = "通过";
        }
        return this.passed;
    }

}
