package com.lzh.controller;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.sheet.wrapper.NoTemplateSheetWrapper;
import com.github.crab2died.sheet.wrapper.NormalSheetWrapper;
import com.lzh.annotation.Pass;
import com.lzh.base.PublicResultConstant;
import com.lzh.config.ResponseHelper;
import com.lzh.config.ResponseModel;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by lzh on 2018/11/10.
 * 注意！！excel 模板文件中的        定义符	               描述	           优先级(大到小)
 $appoint_line_style	当前行样式	           3
 $single_line_style	   单行样式	               2
 $double_line_style	   双行样式	               2
 $default_style	       默认样式	               1
 $data_index	          数据插入的起始位置	   -
 $serial_number    	  插入序号标记             -
 *
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

}
