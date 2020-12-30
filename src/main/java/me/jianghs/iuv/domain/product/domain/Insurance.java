package me.jianghs.iuv.domain.product.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @className: Insurance
 * @description: 险种
 * @author: jianghs430
 * @createDate: 2020/12/22 16:17
 * @version: 1.0
 */
@Data
public class Insurance {

    /**
     * 险种编码
     */
    private String code;

    /**
     * 险种名称
     */
    private String name;

    /**
     * 责任列表
     */
    private List<Responsibility> responsibilityList;

    /**
     * 投保规则
     */
    private List<PolicyRule> policyRuleList;

    /**
     * 计算险种的生效日期
     * @return
     */
    public Date calValidate() {
        return new Date();
    }

    /**
     * 计算保额 累加责任保额
     */
    public BigDecimal calSumAssured() {
        BigDecimal result = new BigDecimal(0);
        for (Responsibility responsibility : responsibilityList) {
            result.add(responsibility.calSumAssured());
        }
        return result;
    }

    /**
     * 计算保费，随机返回一个保费
     */
    public BigDecimal calPremium() {
        Random random = new Random(10000);
        Double val = random.nextDouble();
        return BigDecimal.valueOf(val);
    }

    /**
     * 规则校验
     */
    public boolean check() {
        boolean checkResult = true;
        for (PolicyRule rule : policyRuleList) {
            if (rule.run()) {
                checkResult = false;
            }
        }
        return checkResult;
    }

    /**
     * 获取所有未校验通过的信息
     * @return
     */
    public List<String> getUnPassedMsg() {
        List<String> msgList = new ArrayList<>();
        for (PolicyRule rule : policyRuleList) {
            if (!rule.isPassed()) {
                msgList.add(rule.getMsg());
            }
        }
        return msgList;
    }
}
