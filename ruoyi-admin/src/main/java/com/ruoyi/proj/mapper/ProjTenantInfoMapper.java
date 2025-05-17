package com.ruoyi.proj.mapper;

import java.util.List;
import com.ruoyi.proj.domain.ProjTenantInfo;

/**
 * 租客信息Mapper接口
 * 
 * @author alex
 * @date 2025-05-17
 */
public interface ProjTenantInfoMapper 
{
    /**
     * 查询租客信息
     * 
     * @param tenantId 租客信息主键
     * @return 租客信息
     */
    public ProjTenantInfo selectProjTenantInfoByTenantId(Long tenantId);

    /**
     * 查询租客信息列表
     * 
     * @param projTenantInfo 租客信息
     * @return 租客信息集合
     */
    public List<ProjTenantInfo> selectProjTenantInfoList(ProjTenantInfo projTenantInfo);

    /**
     * 新增租客信息
     * 
     * @param projTenantInfo 租客信息
     * @return 结果
     */
    public int insertProjTenantInfo(ProjTenantInfo projTenantInfo);

    /**
     * 修改租客信息
     * 
     * @param projTenantInfo 租客信息
     * @return 结果
     */
    public int updateProjTenantInfo(ProjTenantInfo projTenantInfo);

    /**
     * 删除租客信息
     * 
     * @param tenantId 租客信息主键
     * @return 结果
     */
    public int deleteProjTenantInfoByTenantId(Long tenantId);

    /**
     * 批量删除租客信息
     * 
     * @param tenantIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjTenantInfoByTenantIds(Long[] tenantIds);
}
