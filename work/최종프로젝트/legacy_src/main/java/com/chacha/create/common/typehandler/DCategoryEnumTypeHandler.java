package com.chacha.create.common.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.chacha.create.common.enums.category.DCategoryEnum;

/**
 * MyBatis에서 {@link DCategoryEnum}와 DB 컬럼(int ID) 간 변환을 담당하는 TypeHandler 클래스
 */
public class DCategoryEnumTypeHandler extends BaseTypeHandler<DCategoryEnum> {

    /**
     * MyBatis가 SQL 바인딩 시 호출하는 메서드로, enum 값을 DB에 저장할 때 사용됩니다.
     * 
     * @param ps          PreparedStatement 객체
     * @param i           파라미터 인덱스
     * @param parameter   매핑할 {@link DCategoryEnum} enum 값
     * @param jdbcType    JDBC 타입 정보 (사용 안 할 수도 있음)
     * @throws SQLException DB 처리 중 예외 발생 시 던져짐
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DCategoryEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId()); // enum → 정수(ID) 변환 후 설정
    }

    /**
     * ResultSet에서 컬럼명으로 값을 읽어 enum으로 변환하는 메서드.
     * 
     * @param rs          ResultSet 객체
     * @param columnName  조회할 컬럼명
     * @return            DB의 int 값을 enum으로 변환한 결과
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public DCategoryEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int id = rs.getInt(columnName);
        return DCategoryEnum.fromId(id); // 정수(ID) → enum 변환
    }

    /**
     * ResultSet에서 컬럼 인덱스로 값을 읽어 enum으로 변환하는 메서드.
     * 
     * @param rs           ResultSet 객체
     * @param columnIndex  조회할 컬럼 인덱스 (1부터 시작)
     * @return             DB의 int 값을 enum으로 변환한 결과
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public DCategoryEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int id = rs.getInt(columnIndex);
        return DCategoryEnum.fromId(id);
    }

    /**
     * CallableStatement에서 결과 값을 읽어 enum으로 변환하는 메서드.
     * (주로 프로시저 호출 결과 처리에 사용)
     * 
     * @param cs           CallableStatement 객체
     * @param columnIndex  조회할 컬럼 인덱스 (1부터 시작)
     * @return             DB의 int 값을 enum으로 변환한 결과
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public DCategoryEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int id = cs.getInt(columnIndex);
        return DCategoryEnum.fromId(id);
    }
}
