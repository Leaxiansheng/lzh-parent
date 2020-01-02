package com.lzh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 操作日志 前端控制器
 */
@RestController
@RequestMapping("/operationLog")
//不加入swagger ui里
@ApiIgnore
public class OperationLogController {
}
