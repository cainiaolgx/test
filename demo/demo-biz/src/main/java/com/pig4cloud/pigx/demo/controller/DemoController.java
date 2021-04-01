/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pigx.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pigx.common.core.util.R;
import com.pig4cloud.pigx.common.log.annotation.SysLog;
import com.pig4cloud.pigx.demo.entity.Demo;
import com.pig4cloud.pigx.demo.service.DemoService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * demo 表
 *
 * @author pigx code generator
 * @date 2021-03-31 14:48:12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/demo" )
@Api(value = "demo", tags = "demo 表管理")
public class DemoController {

    private final  DemoService demoService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param demo demo 表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getDemoPage(Page page, Demo demo) {
        return R.ok(demoService.page(page, Wrappers.query(demo)));
    }


    /**
     * 通过id查询demo 表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(demoService.getById(id));
    }

    /**
     * 新增demo 表
     * @param demo demo 表
     * @return R
     */
    @ApiOperation(value = "新增demo 表", notes = "新增demo 表")
    @SysLog("新增demo 表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('demo_demo_add')" )
    public R save(@RequestBody Demo demo) {
        return R.ok(demoService.save(demo));
    }

    /**
     * 修改demo 表
     * @param demo demo 表
     * @return R
     */
    @ApiOperation(value = "修改demo 表", notes = "修改demo 表")
    @SysLog("修改demo 表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('demo_demo_edit')" )
    public R updateById(@RequestBody Demo demo) {
        return R.ok(demoService.updateById(demo));
    }

    /**
     * 通过id删除demo 表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除demo 表", notes = "通过id删除demo 表")
    @SysLog("通过id删除demo 表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('demo_demo_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(demoService.removeById(id));
    }

}
