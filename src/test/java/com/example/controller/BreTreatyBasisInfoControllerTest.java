package com.example.controller;


import com.example.entity.BreTreatAllInfoDto;
import com.example.service.TreatyService;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
class BreTreatyBasisInfoControllerTest {

    private static final String AUTHORIZATION = "Authorization";
    @InjectMocks
    private  BreTreatyBasisInfoController breTreatyBasisInfoController;
    @Mock
    private TreatyService treatyService;

    private MockMvc mvc;

    @Before
    public void init() {
        //初始化
        MockitoAnnotations.initMocks(this);
        //构建mvc环境
        mvc = MockMvcBuilders.standaloneSetup(breTreatyBasisInfoController).build();
    }


    @Test
    public void test() throws Exception {
        BreTreatAllInfoDto dto = new BreTreatAllInfoDto();
        dto.setBreSlipNumber("");
        mvc.perform(post("/ebs/v1/volumes/123/action/attach")
                .header(AUTHORIZATION, "123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dto.toString())
                )
                .andExpect(status().isOk());


    }

}