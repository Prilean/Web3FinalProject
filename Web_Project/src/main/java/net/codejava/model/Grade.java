package net.codejava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "grades")
@Getter
@Setter
public class Grade {
	@Id
	@Column(name = "grade_id")
	private Long id;
	private int practice_score;
	private int puzzle_score;
}
