package com.example.recruitmenttask.controller;

import com.example.recruitmenttask.model.School;
import com.example.recruitmenttask.model.projection.MonthlyChildSettlement;
import com.example.recruitmenttask.model.projection.MonthlyParentSettlement;
import com.example.recruitmenttask.model.projection.MonthlySchoolSettlement;
import com.example.recruitmenttask.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SchoolControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private SchoolService schoolService;

    @Test
    public void should_create_school() throws Exception {
        //given
        School school = new School(1, "Testname", 300.5F);
        given(schoolService.saveSchool(any(School.class))).willAnswer((x) -> x.getArgument(0));

        //when
        ResultActions response = mvc.perform(post("/schools")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(school)));

        //then
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id",
                        is(school.getId())))
                .andExpect(jsonPath("$.name",
                        is(school.getName())));
    }

    @Test
    public void should_get_list_of_schools() throws Exception {
        //given
        List<School> schools = List.of(new School(1, "First school", 200F), new School(2, "Second school", 280.4F));
        given(schoolService.getAllSchools()).willReturn(schools);

        //when
        ResultActions response = mvc.perform(get("/schools"));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(schools.size())));
    }

    @Test
    public void should_get_school_by_given_id() throws Exception {
        //given
        Integer id = 1;
        School school = new School(1, "School", 240.4F);
        given(schoolService.getSchoolById(id)).willReturn(school);

        //when
        ResultActions response = mvc.perform(get("/schools/{id}", id));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",
                        is(school.getName())));
    }

    @Test
    public void should_get_monthly_school_settlement() throws Exception {
        //given
        Integer schoolId = 1;
        int month = 5;
        MonthlySchoolSettlement mss = new MonthlySchoolSettlement("School", "MAY", 500.5F);
        given(schoolService.getSchoolSettlementByMonth(schoolId, month)).willReturn(mss);

        //when
        ResultActions response = mvc.perform(get("/schools/settlements/{id}", schoolId)
                .param("month", String.valueOf(month)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name",
                        is(mss.getName())))
                .andExpect(jsonPath("$.month",
                        is(mss.getMonth())));
    }

    @Test
    public void should_get_monthly_parent_settlement() throws Exception {
        //given
        Integer schoolId = 3;
        Integer parentId = 2;
        int month = 8;
        MonthlyChildSettlement mcs = new MonthlyChildSettlement("Child name", "School", 100, 1200.0F);
        MonthlyParentSettlement mps = new MonthlyParentSettlement("Parent name", "Parent lastname", List.of(mcs), 1200.0F);
        given(schoolService.getParentSettlementByMonth(schoolId, month, parentId)).willReturn(mps);

        //when
        ResultActions response = mvc.perform(get("/schools/settlements/{id}/{parentId}", schoolId, parentId)
                .param("month", String.valueOf(month)));

        //then
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstname",
                        is(mps.getFirstname())))
                .andExpect(jsonPath("$.lastname",
                        is(mps.getLastname())));
    }

}