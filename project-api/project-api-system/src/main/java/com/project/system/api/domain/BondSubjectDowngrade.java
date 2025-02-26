package com.project.system.api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;

import java.util.Date;

/**
 * 主体评级下调及展望负面
 *
 * @author qshj
 */
public class BondSubjectDowngrade{
    /** 主键 */
    private Long bsdId;

    /** 序号-不需要录入数据库 */
    private Integer serialNumber;

    /** 评级调整日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评级调整日", dateFormat = "yyyy-MM-dd")
    private Date ratingAdjustmentDay;

    /** 发行人代码 */
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人")
    private String comUniName;

    /** 评级机构 */
    @Excel(name = "评级机构")
    private String orgRatingAgencies;

    /** 评级变动前 */
    @Excel(name = "评级变动前")
    private String beforeRatingChange;

    /** 评级变动后 */
    @Excel(name = "评级变动后")
    private String afterRatingChange;

    /** 评级展望 */
    @Excel(name = "评级展望")
    private String outlook;

    /** 1删除、0正常 */
    private String isDelete;
    /** 1城投、2地产 0其他 */
    private String flag;

    /** 创建人 */
    private Long createUser;

    /** 修改人 */
    private Long updateUser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Long getBsdId() {
        return bsdId;
    }

    public void setBsdId(Long bsdId) {
        this.bsdId = bsdId;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getRatingAdjustmentDay() {
        return ratingAdjustmentDay;
    }

    public void setRatingAdjustmentDay(Date ratingAdjustmentDay) {
        this.ratingAdjustmentDay = ratingAdjustmentDay;
    }

    public Long getComUniCode() {
        return comUniCode;
    }

    public void setComUniCode(Long comUniCode) {
        this.comUniCode = comUniCode;
    }

    public String getComUniName() {
        return comUniName;
    }

    public void setComUniName(String comUniName) {
        this.comUniName = comUniName;
    }

    public String getOrgRatingAgencies() {
        return orgRatingAgencies;
    }

    public void setOrgRatingAgencies(String orgRatingAgencies) {
        this.orgRatingAgencies = orgRatingAgencies;
    }

    public String getBeforeRatingChange() {
        return beforeRatingChange;
    }

    public void setBeforeRatingChange(String beforeRatingChange) {
        this.beforeRatingChange = beforeRatingChange;
    }

    public String getAfterRatingChange() {
        return afterRatingChange;
    }

    public void setAfterRatingChange(String afterRatingChange) {
        this.afterRatingChange = afterRatingChange;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
