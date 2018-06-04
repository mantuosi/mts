package com.mantuosi.mts.core.bean.users;

import java.util.ArrayList;
import java.util.List;

public class UsersQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UsersQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpassportIsNull() {
            addCriterion("upassport is null");
            return (Criteria) this;
        }

        public Criteria andUpassportIsNotNull() {
            addCriterion("upassport is not null");
            return (Criteria) this;
        }

        public Criteria andUpassportEqualTo(String value) {
            addCriterion("upassport =", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportNotEqualTo(String value) {
            addCriterion("upassport <>", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportGreaterThan(String value) {
            addCriterion("upassport >", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportGreaterThanOrEqualTo(String value) {
            addCriterion("upassport >=", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportLessThan(String value) {
            addCriterion("upassport <", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportLessThanOrEqualTo(String value) {
            addCriterion("upassport <=", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportLike(String value) {
            addCriterion("upassport like", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportNotLike(String value) {
            addCriterion("upassport not like", value, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportIn(List<String> values) {
            addCriterion("upassport in", values, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportNotIn(List<String> values) {
            addCriterion("upassport not in", values, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportBetween(String value1, String value2) {
            addCriterion("upassport between", value1, value2, "upassport");
            return (Criteria) this;
        }

        public Criteria andUpassportNotBetween(String value1, String value2) {
            addCriterion("upassport not between", value1, value2, "upassport");
            return (Criteria) this;
        }

        public Criteria andUaddrIsNull() {
            addCriterion("uaddr is null");
            return (Criteria) this;
        }

        public Criteria andUaddrIsNotNull() {
            addCriterion("uaddr is not null");
            return (Criteria) this;
        }

        public Criteria andUaddrEqualTo(String value) {
            addCriterion("uaddr =", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrNotEqualTo(String value) {
            addCriterion("uaddr <>", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrGreaterThan(String value) {
            addCriterion("uaddr >", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrGreaterThanOrEqualTo(String value) {
            addCriterion("uaddr >=", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrLessThan(String value) {
            addCriterion("uaddr <", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrLessThanOrEqualTo(String value) {
            addCriterion("uaddr <=", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrLike(String value) {
            addCriterion("uaddr like", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrNotLike(String value) {
            addCriterion("uaddr not like", value, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrIn(List<String> values) {
            addCriterion("uaddr in", values, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrNotIn(List<String> values) {
            addCriterion("uaddr not in", values, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrBetween(String value1, String value2) {
            addCriterion("uaddr between", value1, value2, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUaddrNotBetween(String value1, String value2) {
            addCriterion("uaddr not between", value1, value2, "uaddr");
            return (Criteria) this;
        }

        public Criteria andUrankIsNull() {
            addCriterion("urank is null");
            return (Criteria) this;
        }

        public Criteria andUrankIsNotNull() {
            addCriterion("urank is not null");
            return (Criteria) this;
        }

        public Criteria andUrankEqualTo(String value) {
            addCriterion("urank =", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankNotEqualTo(String value) {
            addCriterion("urank <>", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankGreaterThan(String value) {
            addCriterion("urank >", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankGreaterThanOrEqualTo(String value) {
            addCriterion("urank >=", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankLessThan(String value) {
            addCriterion("urank <", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankLessThanOrEqualTo(String value) {
            addCriterion("urank <=", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankLike(String value) {
            addCriterion("urank like", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankNotLike(String value) {
            addCriterion("urank not like", value, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankIn(List<String> values) {
            addCriterion("urank in", values, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankNotIn(List<String> values) {
            addCriterion("urank not in", values, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankBetween(String value1, String value2) {
            addCriterion("urank between", value1, value2, "urank");
            return (Criteria) this;
        }

        public Criteria andUrankNotBetween(String value1, String value2) {
            addCriterion("urank not between", value1, value2, "urank");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}