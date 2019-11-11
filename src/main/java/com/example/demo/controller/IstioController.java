package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yangmingkai on 2019-11-11.
 */
@RestController
@Api("用于istio测试")
@RequestMapping("/demo")
public class IstioController {

    @Value("${version}")
    private String version;

    @GetMapping("/version")
    @ApiOperation("获取当前版本")
    public String getVersion() {

        return String.format("This is version %s", version);
    }
}
