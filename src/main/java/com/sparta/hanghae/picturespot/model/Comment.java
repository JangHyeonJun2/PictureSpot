package com.sparta.hanghae.picturespot.model;

import com.sparta.hanghae.picturespot.dto.request.comment.CommentUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOARD_ID")
    private Board board;



    @Builder
    public Comment(String content, User user, Board board) {
        this.content = content;
        this.user = user;
        this.board = board;
    }

    public Comment update(CommentUpdateRequestDto requestDto) {
        this.content = requestDto.getContent();
        return this;
    }
}
