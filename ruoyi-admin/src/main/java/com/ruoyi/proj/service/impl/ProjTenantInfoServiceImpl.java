package com.ruoyi.proj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.proj.mapper.ProjTenantInfoMapper;
import com.ruoyi.proj.domain.ProjTenantInfo;
import com.ruoyi.proj.service.IProjTenantInfoService;

/**
 * 租客信息Service业务层处理
 * 
 * @author alex
 * @date 2025-05-17
 */
@Service
public class ProjTenantInfoServiceImpl implements IProjTenantInfoService 
{
    @Autowired
    private ProjTenantInfoMapper projTenantInfoMapper;

    /**
     * 查询租客信息
     * 
     * @param tenantId 租客信息主键
     * @return 租客信息
     */
    @Override
    public ProjTenantInfo selectProjTenantInfoByTenantId(Long tenantId)
    {
        return projTenantInfoMapper.selectProjTenantInfoByTenantId(tenantId);
    }

    /**
     * 查询租客信息列表
     * 
     * @param projTenantInfo 租客信息
     * @return 租客信息
     */
    @Override
    public List<ProjTenantInfo> selectProjTenantInfoList(ProjTenantInfo projTenantInfo)
    {
        return projTenantInfoMapper.selectProjTenantInfoList(projTenantInfo);
    }

    /**
     * 新增租客信息
     * 
     * @param projTenantInfo 租客信息
     * @return 结果
     */
    @Override
    public int insertProjTenantInfo(ProjTenantInfo projTenantInfo)
    {
        projTenantInfo.setCreateTime(DateUtils.getNowDate());
        return projTenantInfoMapper.insertProjTenantInfo(projTenantInfo);
    }

    /**
     * 修改租客信息
     * 
     * @param projTenantInfo 租客信息
     * @return 结果
     */
    @Override
    public int updateProjTenantInfo(ProjTenantInfo projTenantInfo)
    {
        projTenantInfo.setUpdateTime(DateUtils.getNowDate());
        return projTenantInfoMapper.updateProjTenantInfo(projTenantInfo);
    }

    /**
     * 批量删除租客信息
     * 
     * @param tenantIds 需要删除的租客信息主键
     * @return 结果
     */
    @Override
    public int deleteProjTenantInfoByTenantIds(Long[] tenantIds)
    {
        return projTenantInfoMapper.deleteProjTenantInfoByTenantIds(tenantIds);
    }

    /**
     * 删除租客信息信息
     * 
     * @param tenantId 租客信息主键
     * @return 结果
     */
    @Override
    public int deleteProjTenantInfoByTenantId(Long tenantId)
    {
        return projTenantInfoMapper.deleteProjTenantInfoByTenantId(tenantId);
    }
}
