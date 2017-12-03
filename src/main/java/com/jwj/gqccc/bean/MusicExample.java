package com.jwj.gqccc.bean;

import java.util.ArrayList;
import java.util.List;

public class MusicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusicExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mId is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mId is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mId =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mId <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mId >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mId >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mId <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mId <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mId in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mId not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mId between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mId not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMaddressIsNull() {
            addCriterion("mAddress is null");
            return (Criteria) this;
        }

        public Criteria andMaddressIsNotNull() {
            addCriterion("mAddress is not null");
            return (Criteria) this;
        }

        public Criteria andMaddressEqualTo(String value) {
            addCriterion("mAddress =", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotEqualTo(String value) {
            addCriterion("mAddress <>", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressGreaterThan(String value) {
            addCriterion("mAddress >", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressGreaterThanOrEqualTo(String value) {
            addCriterion("mAddress >=", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLessThan(String value) {
            addCriterion("mAddress <", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLessThanOrEqualTo(String value) {
            addCriterion("mAddress <=", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressLike(String value) {
            addCriterion("mAddress like", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotLike(String value) {
            addCriterion("mAddress not like", value, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressIn(List<String> values) {
            addCriterion("mAddress in", values, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotIn(List<String> values) {
            addCriterion("mAddress not in", values, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressBetween(String value1, String value2) {
            addCriterion("mAddress between", value1, value2, "maddress");
            return (Criteria) this;
        }

        public Criteria andMaddressNotBetween(String value1, String value2) {
            addCriterion("mAddress not between", value1, value2, "maddress");
            return (Criteria) this;
        }

        public Criteria andMmusicnameIsNull() {
            addCriterion("mMusicName is null");
            return (Criteria) this;
        }

        public Criteria andMmusicnameIsNotNull() {
            addCriterion("mMusicName is not null");
            return (Criteria) this;
        }

        public Criteria andMmusicnameEqualTo(String value) {
            addCriterion("mMusicName =", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameNotEqualTo(String value) {
            addCriterion("mMusicName <>", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameGreaterThan(String value) {
            addCriterion("mMusicName >", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameGreaterThanOrEqualTo(String value) {
            addCriterion("mMusicName >=", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameLessThan(String value) {
            addCriterion("mMusicName <", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameLessThanOrEqualTo(String value) {
            addCriterion("mMusicName <=", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameLike(String value) {
            addCriterion("mMusicName like", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameNotLike(String value) {
            addCriterion("mMusicName not like", value, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameIn(List<String> values) {
            addCriterion("mMusicName in", values, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameNotIn(List<String> values) {
            addCriterion("mMusicName not in", values, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameBetween(String value1, String value2) {
            addCriterion("mMusicName between", value1, value2, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMmusicnameNotBetween(String value1, String value2) {
            addCriterion("mMusicName not between", value1, value2, "mmusicname");
            return (Criteria) this;
        }

        public Criteria andMcdIsNull() {
            addCriterion("mCD is null");
            return (Criteria) this;
        }

        public Criteria andMcdIsNotNull() {
            addCriterion("mCD is not null");
            return (Criteria) this;
        }

        public Criteria andMcdEqualTo(String value) {
            addCriterion("mCD =", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdNotEqualTo(String value) {
            addCriterion("mCD <>", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdGreaterThan(String value) {
            addCriterion("mCD >", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdGreaterThanOrEqualTo(String value) {
            addCriterion("mCD >=", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdLessThan(String value) {
            addCriterion("mCD <", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdLessThanOrEqualTo(String value) {
            addCriterion("mCD <=", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdLike(String value) {
            addCriterion("mCD like", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdNotLike(String value) {
            addCriterion("mCD not like", value, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdIn(List<String> values) {
            addCriterion("mCD in", values, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdNotIn(List<String> values) {
            addCriterion("mCD not in", values, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdBetween(String value1, String value2) {
            addCriterion("mCD between", value1, value2, "mcd");
            return (Criteria) this;
        }

        public Criteria andMcdNotBetween(String value1, String value2) {
            addCriterion("mCD not between", value1, value2, "mcd");
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