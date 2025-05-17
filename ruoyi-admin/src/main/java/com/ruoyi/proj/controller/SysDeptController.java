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
import com.ruoyi.proj.domain.SysDept;
import com.ruoyi.proj.service.ISysDeptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门Controller
 * 
 * @author alec
 * @date 2025-05-17
 */
@RestController
@RequestMapping("/proj/dept")
public class SysDeptController extends BaseController
{
    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询部门列表
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDept sysDept)
    {
        startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        return getDataTable(list);
    }

    /**
     * 导出部门列表
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:export')")
    @Log(title = "部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDept sysDept)
    {
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        util.exportExcel(response, list, "部门数据");
    }

    /**
     * 获取部门详细信息
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return success(sysDeptService.selectSysDeptByDeptId(deptId));
    }

    /**
     * 新增部门
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:add')")
    @Log(title = "部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.insertSysDept(sysDept));
    }

    /**
     * 修改部门
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:edit')")
    @Log(title = "部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.updateSysDept(sysDept));
    }

    /**
     * 删除部门
     */
    @PreAuthorize("@ss.hasPermi('proj:dept:remove')")
    @Log(title = "部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(sysDeptService.deleteSysDeptByDeptIds(deptIds));
    }
}
