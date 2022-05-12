package com.erdal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
@NoArgsConstructor
public class InstructorDetail {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "youtube_channel", length = 128)
	private String youtubeChannelUrl;

	@Column(name = "hobby")
	private String hobby;

	public InstructorDetail(String youtubeChannelUrl, String hobby) {
		this.youtubeChannelUrl = youtubeChannelUrl;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannelUrl=" + youtubeChannelUrl + ", hobby=" + hobby + "]";
	}
}
