package com.zoe.frea.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //Entity 클래스들이 이 클래스를 상속할 경우 필드들을 칼럼으로 인식하도록 함.
@EntityListeners(AuditingEntityListener.class) //이 클래스에 auditing기능을 포함 시킴.
public abstract class BaseTimeEntity {
    @CreatedDate //entity 생성되어 저장될때 시간이 자동저장.
    private LocalDateTime createDate;

    @LastModifiedDate//조회된 entity값을 변경할 때 시간이 자동 저장 됨
    private LocalDateTime modifiedDate;
}
