package com.ssg.web2.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
