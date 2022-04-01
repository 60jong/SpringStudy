//package com.ykj.springbusiness.repository;
//
//import com.ykj.springbusiness.entity.Member;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//public class JdbMemberRepository implements MemberRepository{
//
//    private DataSource dataSource;
//
//    public JdbMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    public Member save(Member member) throws SQLException {
//        String sql = "insert into member(name) values(?)";
//
//        Connection con = dataSource.getConnection();
//        PreparedStatement pst = con.prepareStatement(sql);
//        pst.setString(1, member.getName());
//
//        pst.executeUpdate();
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return null;
//    }
//}
