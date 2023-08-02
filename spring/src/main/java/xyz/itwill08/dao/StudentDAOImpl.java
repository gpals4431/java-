package xyz.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.Setter;

//StringDAO ����� �̿��Ͽ� DAO Ŭ���� �ۼ� - spring-jdbc ���̺귯���� ������Ʈ�� ���� ó��
//=> JDBCTemplate ��ü�� �޼ҵ带 ȣ���Ͽ� DAOŬ������ �޼ҵ� �ۼ�

public class StudentDAOImpl implements StudentDAO {
	// JdbcTemplate ��ü�� �����ϱ� ���� �ʵ� ����
	// => spring Bean Configuration File���� DAO Ŭ������ spring bean���� ����Ҷ�
	// JdbcTemplate Ŭ������ spring bean�� �����޾� ������ ����
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
			//EmptyResultDataAccessException : queryForObject() �޼ҵ忡���� �˻����� ���� ��� �߻��Ǵ� ����
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
	
	//���� Ŭ������ �ڽ� Ŭ���� ����
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
