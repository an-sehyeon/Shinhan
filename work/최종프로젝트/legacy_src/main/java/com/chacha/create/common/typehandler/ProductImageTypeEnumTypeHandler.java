package com.chacha.create.common.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.chacha.create.common.enums.image.ProductImageTypeEnum;

/**
 * MyBatis TypeHandler for {@link ProductImageTypeEnum}
 * <p>
 * DB의 문자열 컬럼(p_img_enum)과 Java Enum {@link ProductImageTypeEnum} 간의 변환을 지원합니다.
 * Enum을 DB에 저장할 때는 문자열 코드로 변환하여 저장하고,
 * DB에서 조회할 때는 문자열 코드를 다시 Enum으로 변환합니다.
 * </p>
 */
public class ProductImageTypeEnumTypeHandler extends BaseTypeHandler<ProductImageTypeEnum> {

    /**
     * PreparedStatement에 enum 값을 DB에 저장할 문자열로 변환해 설정합니다.
     *
     * @param ps        PreparedStatement 객체
     * @param i         파라미터 인덱스
     * @param parameter 변환할 {@link ProductImageTypeEnum} enum 값
     * @param jdbcType  JDBC 타입 (사용 안 할 수도 있음)
     * @throws SQLException DB 처리 중 예외 발생 시 던져짐
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ProductImageTypeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode()); // Enum → DB 문자열 코드 변환
    }

    /**
     * ResultSet에서 컬럼명으로 조회한 문자열을 Enum으로 변환해 반환합니다.
     *
     * @param rs         ResultSet 객체
     * @param columnName 컬럼명
     * @return DB 문자열 코드에 해당하는 {@link ProductImageTypeEnum} 또는 null
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public ProductImageTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return code == null ? null : ProductImageTypeEnum.fromCode(code);
    }

    /**
     * ResultSet에서 컬럼 인덱스로 조회한 문자열을 Enum으로 변환해 반환합니다.
     *
     * @param rs          ResultSet 객체
     * @param columnIndex 컬럼 인덱스 (1부터 시작)
     * @return DB 문자열 코드에 해당하는 {@link ProductImageTypeEnum} 또는 null
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public ProductImageTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return code == null ? null : ProductImageTypeEnum.fromCode(code);
    }

    /**
     * CallableStatement에서 컬럼 인덱스로 조회한 문자열을 Enum으로 변환해 반환합니다.
     *
     * @param cs          CallableStatement 객체
     * @param columnIndex 컬럼 인덱스 (1부터 시작)
     * @return DB 문자열 코드에 해당하는 {@link ProductImageTypeEnum} 또는 null
     * @throws SQLException DB 조회 중 예외 발생 시 던져짐
     */
    @Override
    public ProductImageTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return code == null ? null : ProductImageTypeEnum.fromCode(code);
    }
}
