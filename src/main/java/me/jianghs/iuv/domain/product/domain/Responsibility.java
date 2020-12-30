package me.jianghs.iuv.domain.product.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @className: Responsibility
 * @description:
 * @author: jianghs430
 * @createDate: 2020/12/22 16:18
 * @version: 1.0
 */
@Data
public class Responsibility {
    /**
     * 责任编码
     */
    private String code;

    /**
     * 责任名称
     */
    private String name;

    /**
     * 计算责任保额
     */
    public BigDecimal calSumAssured() {
        Random random = new Random(10000);
        Double val = random.nextDouble();
        return BigDecimal.valueOf(val);
    }


}
