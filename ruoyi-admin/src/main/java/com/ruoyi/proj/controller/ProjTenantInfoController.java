package com.ruoyi.proj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.proj.domain.ProjTenantInfo;
import com.ruoyi.proj.service.IProjTenantInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 租客信息Controller
 * 
 * @author alex
 * @date 2025-05-17
 */
@RestController
@RequestMapping("/proj/ProjTenantInfo")
public class ProjTenantInfoController extends BaseController
{
    @Autowired
    private IProjTenantInfoService projTenantInfoService;

    /**
     * 查询租客信息列表
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjTenantInfo projTenantInfo)
    {
        startPage();
        List<ProjTenantInfo> list = projTenantInfoService.selectProjTenantInfoList(projTenantInfo);
        return getDataTable(list);
    }

    /**
     * 导出租客信息列表
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:export')")
    @Log(title = "租客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjTenantInfo projTenantInfo)
    {
        List<ProjTenantInfo> list = projTenantInfoService.selectProjTenantInfoList(projTenantInfo);
        ExcelUtil<ProjTenantInfo> util = new ExcelUtil<ProjTenantInfo>(ProjTenantInfo.class);
        util.exportExcel(response, list, "租客信息数据");
    }

    /**
     * 获取租客信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:query')")
    @GetMapping(value = "/{tenantId}")
    public AjaxResult getInfo(@PathVariable("tenantId") Long tenantId)
    {
        return success(projTenantInfoService.selectProjTenantInfoByTenantId(tenantId));
    }

    /**
     * 新增租客信息
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:add')")
    @Log(title = "租客信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjTenantInfo projTenantInfo)
    {
        return toAjax(projTenantInfoService.insertProjTenantInfo(projTenantInfo));
    }

    /**
     * 修改租客信息
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:edit')")
    @Log(title = "租客信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjTenantInfo projTenantInfo)
    {
        return toAjax(projTenantInfoService.updateProjTenantInfo(projTenantInfo));
    }

    /**
     * 删除租客信息
     */
    @PreAuthorize("@ss.hasPermi('proj:ProjTenantInfo:remove')")
    @Log(title = "租客信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tenantIds}")
    public AjaxResult remove(@PathVariable Long[] tenantIds)
    {
        return toAjax(projTenantInfoService.deleteProjTenantInfoByTenantIds(tenantIds));
    }
}
