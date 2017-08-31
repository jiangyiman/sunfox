package com.sun.fox.mybatis.base.bmapper.impl;


import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Iterator;
import java.util.Set;

public class InsertRetKeyProvider  extends MapperTemplate {

    public InsertRetKeyProvider( Class<?> mapperClass, MapperHelper mapperHelper ) {
        super(mapperClass, mapperHelper);
    }

    public String insertRetObjSelective( MappedStatement ms ) {
        Class<?> entityClass = this.getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        Boolean hasIdentityKey = false;
        Iterator var6 = columnList.iterator();
        EntityColumn column;
        label95:
        do {
            while(true) {
                while(true) {
                    do {
                        do {
                            if (!var6.hasNext()) {
                                sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
                                sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
                                var6 = columnList.iterator();
                                while(true) {
                                    while(true) {
                                        do {
                                            if (!var6.hasNext()) {
                                                sql.append("</trim>");
                                                sql.append("<trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\">");
                                                var6 = columnList.iterator();

                                                while(var6.hasNext()) {
                                                    column = (EntityColumn)var6.next();
                                                    if (column.isInsertable()) {
                                                        if (column.isIdentity()) {
                                                            sql.append(SqlHelper.getIfCacheNotNull(column, column.getColumnHolder((String)null, "_cache", ",")));
                                                        } else {
                                                            sql.append(SqlHelper.getIfNotNull(column, column.getColumnHolder((String)null, (String)null, ","), this.isNotEmpty()));
                                                        }

                                                        if (StringUtil.isNotEmpty(column.getSequenceName())) {
                                                            sql.append(SqlHelper.getIfIsNull(column, this.getSeqNextVal(column) + " ,", this.isNotEmpty()));
                                                        } else if (column.isIdentity()) {
                                                            sql.append(SqlHelper.getIfCacheIsNull(column, column.getColumnHolder() + ","));
                                                        } else if (column.isUuid()) {
                                                            sql.append(SqlHelper.getIfIsNull(column, column.getColumnHolder((String)null, "_bind", ","), this.isNotEmpty()));
                                                        }
                                                    }
                                                }

                                                sql.append("</trim>");
                                                return sql.toString();
                                            }
                                            column = (EntityColumn)var6.next();
                                        } while(!column.isInsertable());
                                        if (!StringUtil.isNotEmpty(column.getSequenceName()) && !column.isIdentity() && !column.isUuid()) {
                                            sql.append(SqlHelper.getIfNotNull(column, column.getColumn() + ",", this.isNotEmpty()));
                                        } else {
                                            sql.append(column.getColumn() + ",");
                                        }
                                    }
                                }
                            }
                            column = (EntityColumn)var6.next();
                        } while(!column.isInsertable());
                    } while(StringUtil.isNotEmpty(column.getSequenceName()));
                    if (column.isIdentity()) {
                        sql.append(SqlHelper.getBindCache(column));
                        if (hasIdentityKey.booleanValue()) {
                            continue label95;
                        }
                        this.newSelectKeyMappedStatement(ms, column);
                        hasIdentityKey = true;
                    } else if (column.isUuid()) {
                        sql.append(SqlHelper.getBindValue(column, this.getUUID()));
                    }
                }
            }
        } while(column.getGenerator() != null && column.getGenerator().equals("JDBC"));

        throw new MapperException(ms.getId() + "对应的实体类" + entityClass.getCanonicalName() + "中包含多个MySql的自动增长列,最多只能有一个!");

    }


    /**
     * 为实现
     * @param ms
     * @return
     */
    public String insertRetKeySelective( MappedStatement ms ) {
        return null;
    }

    public String insertRetListObjSelective( MappedStatement ms) {
        Class<?> entityClass = this.getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, true, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        Iterator var5 = columnList.iterator();

        while(var5.hasNext()) {
            EntityColumn column = (EntityColumn)var5.next();
            if (!column.isId() && column.isInsertable()) {
                sql.append(column.getColumnHolder("record") + ",");
            }
        }

        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }
}
