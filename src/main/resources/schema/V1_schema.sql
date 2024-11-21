
CREATE TABLE board (
    id NUMBER(11) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, -- 순번
    code NUMBER(11) NOT NULL, -- 게시물 구분 코드
    title VARCHAR2(255) NOT NULL, -- 제목
    content CLOB, -- 내용
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 시작일
    end_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 종료일
    reg_id VARCHAR2(30) NOT NULL, -- 등록 id
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 등록일
    mod_id VARCHAR2(30), -- 수정 id
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 수정일
);

CREATE TABLE upload_file (
    id NUMBER(20) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, -- 파일 id
    file_target VARCHAR2(20) NOT NULL, -- 파일 대상
    file_name VARCHAR2(255), -- 파일명
    save_file_name VARCHAR2(255) NOT NULL, -- 저장된 파일명
    file_path VARCHAR2(255), -- full 파일경로
    file_dir VARCHAR2(255), -- 파일경로
    content_type VARCHAR2(100), -- 파일 타입
    file_size NUMBER(20), -- 파일 크기
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 등록일
);


CREATE TABLE file_map (
    id NUMBER(20) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, -- id
    board_id NUMBER(20) NOT NULL, -- 게시물 id
    file_id NUMBER(20) NOT NULL, -- 파일 id
    CONSTRAINT fk_board_id FOREIGN KEY (board_id) REFERENCES board(id), -- 외래키 제약조건
    CONSTRAINT fk_upload_file_id FOREIGN KEY (file_id) REFERENCES upload_file(id) -- 외래키 제약조건
);
