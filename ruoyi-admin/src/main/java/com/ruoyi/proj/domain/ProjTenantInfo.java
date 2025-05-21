package com.ruoyi.proj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 租客信息对象 proj_tenant_info
 * 
 * @author alex
 * @date 2025-05-21
 */
public class ProjTenantInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租客ID */
    private Long tenantId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDeleted;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 民族 */
    @Excel(name = "民族")
    private String ethnicity;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 工作单位 */
    @Excel(name = "工作单位")
    private String company;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hireDate;

    /** 离职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveDate;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 是否在职 */
    @Excel(name = "是否在职")
    private String isEmployed;

    /** 离职原因 */
    @Excel(name = "离职原因")
    private String leaveReason;

    /** 离职证明 */
    @Excel(name = "离职证明")
    private String resignationCert;

    /** 所在部门 */
    @Excel(name = "所在部门")
    private String department;

    /** 岗位 */
    @Excel(name = "岗位")
    private String position;

    /** 职级 */
    @Excel(name = "职级")
    private String jobLevel;

    /** 工号 */
    @Excel(name = "工号")
    private String employeeId;

    /** 创建人 */
    @Excel(name = "创建人")
    private String creator;

    /** 修改人 */
    @Excel(name = "修改人")
    private String modifier;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlate;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencyContact;

    /** 紧急联系人电话 */
    @Excel(name = "紧急联系人电话")
    private String emergencyPhone;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String maritalStatus;

    /** 联系地址 */
    @Excel(name = "联系地址")
    private String contactAddress;

    /** 入行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 申请原因 */
    @Excel(name = "申请原因")
    private String applyReason;

    /** 续住原因 */
    @Excel(name = "续住原因")
    private String renewalReason;

    /** 状态 */
    @Excel(name = "状态")
    private String statue;

    public void setTenantId(Long tenantId) 
    {
        this.tenantId = tenantId;
    }

    public Long getTenantId() 
    {
        return tenantId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }

    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }

    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }

    public void setEthnicity(String ethnicity) 
    {
        this.ethnicity = ethnicity;
    }

    public String getEthnicity() 
    {
        return ethnicity;
    }

    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }

    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }

    public void setHireDate(Date hireDate) 
    {
        this.hireDate = hireDate;
    }

    public Date getHireDate() 
    {
        return hireDate;
    }

    public void setLeaveDate(Date leaveDate) 
    {
        this.leaveDate = leaveDate;
    }

    public Date getLeaveDate() 
    {
        return leaveDate;
    }

    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }

    public void setIsEmployed(String isEmployed) 
    {
        this.isEmployed = isEmployed;
    }

    public String getIsEmployed() 
    {
        return isEmployed;
    }

    public void setLeaveReason(String leaveReason) 
    {
        this.leaveReason = leaveReason;
    }

    public String getLeaveReason() 
    {
        return leaveReason;
    }

    public void setResignationCert(String resignationCert) 
    {
        this.resignationCert = resignationCert;
    }

    public String getResignationCert() 
    {
        return resignationCert;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    public void setJobLevel(String jobLevel) 
    {
        this.jobLevel = jobLevel;
    }

    public String getJobLevel() 
    {
        return jobLevel;
    }

    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }

    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }

    public void setModifier(String modifier) 
    {
        this.modifier = modifier;
    }

    public String getModifier() 
    {
        return modifier;
    }

    public void setLicensePlate(String licensePlate) 
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() 
    {
        return licensePlate;
    }

    public void setEmergencyContact(String emergencyContact) 
    {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContact() 
    {
        return emergencyContact;
    }

    public void setEmergencyPhone(String emergencyPhone) 
    {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyPhone() 
    {
        return emergencyPhone;
    }

    public void setMaritalStatus(String maritalStatus) 
    {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() 
    {
        return maritalStatus;
    }

    public void setContactAddress(String contactAddress) 
    {
        this.contactAddress = contactAddress;
    }

    public String getContactAddress() 
    {
        return contactAddress;
    }

    public void setEntryTime(Date entryTime) 
    {
        this.entryTime = entryTime;
    }

    public Date getEntryTime() 
    {
        return entryTime;
    }

    public void setApplyReason(String applyReason) 
    {
        this.applyReason = applyReason;
    }

    public String getApplyReason() 
    {
        return applyReason;
    }

    public void setRenewalReason(String renewalReason) 
    {
        this.renewalReason = renewalReason;
    }

    public String getRenewalReason() 
    {
        return renewalReason;
    }

    public void setStatue(String statue) 
    {
        this.statue = statue;
    }

    public String getStatue() 
    {
        return statue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tenantId", getTenantId())
            .append("userId", getUserId())
            .append("idCard", getIdCard())
            .append("name", getName())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("address", getAddress())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .append("deleteTime", getDeleteTime())
            .append("gender", getGender())
            .append("age", getAge())
            .append("birthday", getBirthday())
            .append("ethnicity", getEthnicity())
            .append("education", getEducation())
            .append("company", getCompany())
            .append("hireDate", getHireDate())
            .append("leaveDate", getLeaveDate())
            .append("avatar", getAvatar())
            .append("isEmployed", getIsEmployed())
            .append("leaveReason", getLeaveReason())
            .append("resignationCert", getResignationCert())
            .append("department", getDepartment())
            .append("position", getPosition())
            .append("jobLevel", getJobLevel())
            .append("employeeId", getEmployeeId())
            .append("creator", getCreator())
            .append("modifier", getModifier())
            .append("licensePlate", getLicensePlate())
            .append("emergencyContact", getEmergencyContact())
            .append("emergencyPhone", getEmergencyPhone())
            .append("maritalStatus", getMaritalStatus())
            .append("contactAddress", getContactAddress())
            .append("entryTime", getEntryTime())
            .append("applyReason", getApplyReason())
            .append("renewalReason", getRenewalReason())
            .append("statue", getStatue())
            .toString();
    }
}
