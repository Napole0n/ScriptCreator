/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.classes.principal;

/**
 *
 * @author Murilo
 */
public enum TypeCreator {
    VARCHAR(1),
    INT(2),
    CHAR(3),
    TINYTEXT(4),
    TEXT(5),
    BLOB(6),
    FLOAT(8),
    DOUBLE(9),
    DECIMAL(10),
    BIGINT(11),
    MEDIUMINT(12),
    SMALLINT(13),
    TINYINT(14),
    SET(15),
    DATE(16),
    DATETIME(17),
    TIMESTAMP(18),
    TIME(19),
    YEAR(20),
    MEDIUMTEXT(21),
    MEDIUMBLOB(22),
    LONGTEXT(23),
    LONGBLOB(24),
    ENUM(25);

    public int constSelected;

    private TypeCreator(int number) {
        constSelected = number;
    }

    public int getTypeValue() {
        return constSelected;
    }

}
