package com.spart.week03.models;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter                                         // 생성된 값을 가져오기 위한 getter를 자동 생성
@MappedSuperclass                               // 상속받은 테이블에 컬럼이 되게 한다.
@EntityListeners(AuditingEntityListener.class)  // 변경이 일어나는 것을 주시하고 있는다?
public abstract class Timestamped {

    @CreatedDate//최초 생성 시점
    private LocalDateTime createdAt;

    @LastModifiedDate// 마지막 변경시점
    private LocalDateTime modifiedAt;
}
