package com.project.system.api.domain.vo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.common.core.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 发行人信息对象 t_zzbj_com_info
 *
 * @author qshj
 * @date 2022-05-26
 */
public class TZzbjComInfoVo
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 发行人编码 */
    @Excel(name = "发行人编码")
    private Long comUniCode;

    /** 发行人名称 */
    @Excel(name = "发行人名称")
    private String comUniName;

    /** 公司简称 */
    private String comChiShortName;

    /** 公司英文名称 */
    private String comEngName;

    /** 公司英文简称 */
    private String comEngShortName;

    /** 公司拼音简称 */
    private String comSpeShortName;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 创建人 */
    private Long createUser;

    /** 修改人 */
    private Long updateUser;

    /** 1删除、0正常 */
    private String isDelete;

    /** 1城投、2地产 0其他 */
    private String flag;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String createTimeStart;
    private String createTimeEnd;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String updateTimeStart;
    private String updateTimeEnd;
    
    /** 管控辖区 */
    private int jurisdictionIds;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setComUniCode(Long comUniCode)
    {
        this.comUniCode = comUniCode;
    }

    public Long getComUniCode()
    {
        return comUniCode;
    }
    public void setComUniName(String comUniName)
    {
        this.comUniName = comUniName;
    }

    public String getComUniName()
    {
        return comUniName;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setCreateUser(Long createUser)
    {
        this.createUser = createUser;
    }

    public Long getCreateUser()
    {
        return createUser;
    }
    public void setUpdateUser(Long updateUser)
    {
        this.updateUser = updateUser;
    }

    public Long getUpdateUser()
    {
        return updateUser;
    }
    public void setIsDelete(String isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete()
    {
        return isDelete;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getFlag()
    {
        return flag;
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

    public String getComChiShortName() {
        return comChiShortName;
    }

    public void setComChiShortName(String comChiShortName) {
        this.comChiShortName = comChiShortName;
    }

    public String getComEngName() {
        return comEngName;
    }

    public void setComEngName(String comEngName) {
        this.comEngName = comEngName;
    }

    public String getComEngShortName() {
        return comEngShortName;
    }

    public void setComEngShortName(String comEngShortName) {
        this.comEngShortName = comEngShortName;
    }

    public String getComSpeShortName() {
        return comSpeShortName;
    }

    public void setComSpeShortName(String comSpeShortName) {
        this.comSpeShortName = comSpeShortName;
    }

    public String getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(String createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getUpdateTimeStart() {
        return updateTimeStart;
    }

    public void setUpdateTimeStart(String updateTimeStart) {
        this.updateTimeStart = updateTimeStart;
    }

    public String getUpdateTimeEnd() {
        return updateTimeEnd;
    }

    public void setUpdateTimeEnd(String updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }

    public int getJurisdictionIds() {
		return jurisdictionIds;
	}

	public void setJurisdictionIds(int jurisdictionIds) {
		this.jurisdictionIds = jurisdictionIds;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("comUniCode", getComUniCode())
            .append("comUniName", getComUniName())
            .append("comChiShortName", getComChiShortName())
            .append("comEngName", getComEngName())
            .append("comEngShortName", getComEngShortName())
            .append("comSpeShortName", getComSpeShortName())
            .append("sort", getSort())
            .append("createUser", getCreateUser())
            .append("createTime", getCreateTime())
            .append("updateUser", getUpdateUser())
            .append("updateTime", getUpdateTime())
            .append("isDelete", getIsDelete())
            .append("flag", getFlag())
            .toString();
    }
}
