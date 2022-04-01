package com.ykj.springboot.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class HelloResponseDtoTest {

    private HelloResponseDto dto;

    @Test
    public void 롬복_기능_테스트() {
        String name = "ykj";
        int age = 24;

        dto = new HelloResponseDto(name,age);

        assertThat(dto.getName()).isEqualTo(name);
    }
}