package com.zhupeng.master.pc.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 后台管理用户表
 * </p>
 *
 * @author zhupeng
 * @since 2020-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pc_user")
public class PcUser extends Model<PcUser> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String backUserNo;

    /**
     * 登录帐号
     */
    private String loginAccount;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 商户编号
     */
    private String merchantCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后更新时间
     */
    private Date lastUpdateTime;

    /**
     * 是否删除 0未删除 1删除
     */
    private Boolean isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
