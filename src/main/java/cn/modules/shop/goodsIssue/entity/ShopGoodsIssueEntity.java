package cn.modules.shop.goodsIssue.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.base.AbstractModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.toolkit.Sequence;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
* 商品问答表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 22:31:00
*/
@TableName("shop_goods_issue")
public class ShopGoodsIssueEntity extends AbstractModel<ShopGoodsIssueEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * Id
    */
    @Excel(name = "Id")
    @TableId(value="id")
    private Long id;
    /**
    * 商品问题
    */
    @Excel(name = "商品问题")
    @TableField(value="question")
    private String question;
    /**
    * 商品答案
    */
    @Excel(name = "商品答案")
    @TableField(value="answer")
    private String answer;
    /**
    * 获取: Id
    */
    public Long getId() {
        return id;
    }
    /**
    * 设置: Id
    * 
    */
    public void setId(Long id) {
        this.id = id;
    }
    /**
    * 获取: 商品问题
    */
    public String getQuestion() {
        return question;
    }
    /**
    * 设置: 商品问题
    * 
    */
    public void setQuestion(String question) {
        this.question = question;
    }
    /**
    * 获取: 商品答案
    */
    public String getAnswer() {
        return answer;
    }
    /**
    * 设置: 商品答案
    * 
    */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public void preInsert() {
        Sequence sequence = new Sequence(0, 0);
        this.id = sequence.nextId();
    }
    @Override
    public void preUpdate() {

    }
    @JSONField(serialize = false)
    @Override
    public boolean getIsNewRecord() {
        return isNewRecord || getId() == null;

    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}


