package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//StringDAO 기능을 이용하여 DAO 클래스 작성 - spring-jdbc 라이브러리를 프로젝트에 빌드 처리
//=> JDBCTemplate 객체의 메소드를 호출하여 DAO클래스의 메소드 작성

public class StudentDAOImpl implements StudentDAO {
	// JdbcTemplate 객체를 저장하기 위한 필드 선언
	// => spring Bean Configuration File에서 DAO 클래스를 spring bean으로 등록할때
	// JdbcTemplate 클래스의 spring bean를 제공받아 의존성 주입
	@Setter
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student values(?,?,?,?,?)";
		return jdbcTemplate.update(sql, student.getNo(), student.getName(), student.getPhone(), student.getAddress(),
				student.getBirthday());
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set name=?, phone=?, address=?, birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(), student.getPhone(), student.getAddress(),
				student.getBirthday(), student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	@Override
	public Student selectStudent(int no) {
		try {

			String sql = "select no, name, phone, address, birthday from student where no=?";

				/*@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student student = new Student();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}
			}, no);*/
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), no);
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : queryForObject() 메소드에서만 검색행이 없는 경우 발생되는 예외
			return null;
		}
	}

	@Override
	public List<Student> selectStudentList() {
		String sql="select no, name, phone, address, birthday from student order by no";

	/*		@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				return student;
			}
		});*/
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}
	
	//내부 클래스로 자식 클래스 생성
	public class StudentRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}
	}

}
