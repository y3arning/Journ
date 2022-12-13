package com.example.demo.dao.mappers;


import com.example.demo.entities.StudentDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    @Select("select full_text, value from groups g where g.title = #{i_title, mode=IN, jdbcType=VARCHAR}")
    @Results({
            @Result(column = "full_text", property = "name"),
            @Result(column = "value", property = "value")
    })
    List<StudentDto> getStudents(@Param("i_title") String title);

    @Insert("insert into groups (id, full_text, title, value) values (#{i_id, mode=IN, jdbcType=BIGINT}, " +
            "#{i_full_text, mode=IN, jdbcType=VARCHAR}, " +
            "#{i_title, mode=IN, jdbcType=VARCHAR}," +
            " #{i_value, mode=IN, jdbcType=INTEGER})")
    void insertStudent(@Param("i_id") long id,
                       @Param("i_full_text") String fulltext,
                       @Param("i_title") String title,
                       @Param("i_value") int value );


    @Select("select max(id) from groups")
    Long getMaxId();

    @Update("update groups g set g.value = g.value + 1 where g.full_text = #{i_full_text, mode=IN, jdbcType=VARCHAR}")
    public void updateValue(@Param("i_full_text") String full_text);


}
