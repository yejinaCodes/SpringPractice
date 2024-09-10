package com.ssg.web2.todo.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
}
