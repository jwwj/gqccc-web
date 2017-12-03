package com.jwj.gqccc.bean;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uId is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uId is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uId =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uId <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uId >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uId >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uId <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uId <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uId like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uId not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uId in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uId not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uId between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uId not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoIsNull() {
            addCriterion("uPhoneInfo is null");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoIsNotNull() {
            addCriterion("uPhoneInfo is not null");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoEqualTo(String value) {
            addCriterion("uPhoneInfo =", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoNotEqualTo(String value) {
            addCriterion("uPhoneInfo <>", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoGreaterThan(String value) {
            addCriterion("uPhoneInfo >", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoGreaterThanOrEqualTo(String value) {
            addCriterion("uPhoneInfo >=", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoLessThan(String value) {
            addCriterion("uPhoneInfo <", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoLessThanOrEqualTo(String value) {
            addCriterion("uPhoneInfo <=", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoLike(String value) {
            addCriterion("uPhoneInfo like", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoNotLike(String value) {
            addCriterion("uPhoneInfo not like", value, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoIn(List<String> values) {
            addCriterion("uPhoneInfo in", values, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoNotIn(List<String> values) {
            addCriterion("uPhoneInfo not in", values, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoBetween(String value1, String value2) {
            addCriterion("uPhoneInfo between", value1, value2, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUphoneinfoNotBetween(String value1, String value2) {
            addCriterion("uPhoneInfo not between", value1, value2, "uphoneinfo");
            return (Criteria) this;
        }

        public Criteria andUscoreIsNull() {
            addCriterion("uScore is null");
            return (Criteria) this;
        }

        public Criteria andUscoreIsNotNull() {
            addCriterion("uScore is not null");
            return (Criteria) this;
        }

        public Criteria andUscoreEqualTo(Integer value) {
            addCriterion("uScore =", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreNotEqualTo(Integer value) {
            addCriterion("uScore <>", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreGreaterThan(Integer value) {
            addCriterion("uScore >", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("uScore >=", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreLessThan(Integer value) {
            addCriterion("uScore <", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreLessThanOrEqualTo(Integer value) {
            addCriterion("uScore <=", value, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreIn(List<Integer> values) {
            addCriterion("uScore in", values, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreNotIn(List<Integer> values) {
            addCriterion("uScore not in", values, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreBetween(Integer value1, Integer value2) {
            addCriterion("uScore between", value1, value2, "uscore");
            return (Criteria) this;
        }

        public Criteria andUscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("uScore not between", value1, value2, "uscore");
            return (Criteria) this;
        }

        public Criteria andUlevelIsNull() {
            addCriterion("uLevel is null");
            return (Criteria) this;
        }

        public Criteria andUlevelIsNotNull() {
            addCriterion("uLevel is not null");
            return (Criteria) this;
        }

        public Criteria andUlevelEqualTo(Integer value) {
            addCriterion("uLevel =", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelNotEqualTo(Integer value) {
            addCriterion("uLevel <>", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelGreaterThan(Integer value) {
            addCriterion("uLevel >", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("uLevel >=", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelLessThan(Integer value) {
            addCriterion("uLevel <", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelLessThanOrEqualTo(Integer value) {
            addCriterion("uLevel <=", value, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelIn(List<Integer> values) {
            addCriterion("uLevel in", values, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelNotIn(List<Integer> values) {
            addCriterion("uLevel not in", values, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelBetween(Integer value1, Integer value2) {
            addCriterion("uLevel between", value1, value2, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("uLevel not between", value1, value2, "ulevel");
            return (Criteria) this;
        }

        public Criteria andUdelnumIsNull() {
            addCriterion("uDelNum is null");
            return (Criteria) this;
        }

        public Criteria andUdelnumIsNotNull() {
            addCriterion("uDelNum is not null");
            return (Criteria) this;
        }

        public Criteria andUdelnumEqualTo(Integer value) {
            addCriterion("uDelNum =", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumNotEqualTo(Integer value) {
            addCriterion("uDelNum <>", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumGreaterThan(Integer value) {
            addCriterion("uDelNum >", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("uDelNum >=", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumLessThan(Integer value) {
            addCriterion("uDelNum <", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumLessThanOrEqualTo(Integer value) {
            addCriterion("uDelNum <=", value, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumIn(List<Integer> values) {
            addCriterion("uDelNum in", values, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumNotIn(List<Integer> values) {
            addCriterion("uDelNum not in", values, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumBetween(Integer value1, Integer value2) {
            addCriterion("uDelNum between", value1, value2, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUdelnumNotBetween(Integer value1, Integer value2) {
            addCriterion("uDelNum not between", value1, value2, "udelnum");
            return (Criteria) this;
        }

        public Criteria andUidenumIsNull() {
            addCriterion("uIdeNum is null");
            return (Criteria) this;
        }

        public Criteria andUidenumIsNotNull() {
            addCriterion("uIdeNum is not null");
            return (Criteria) this;
        }

        public Criteria andUidenumEqualTo(Integer value) {
            addCriterion("uIdeNum =", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumNotEqualTo(Integer value) {
            addCriterion("uIdeNum <>", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumGreaterThan(Integer value) {
            addCriterion("uIdeNum >", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("uIdeNum >=", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumLessThan(Integer value) {
            addCriterion("uIdeNum <", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumLessThanOrEqualTo(Integer value) {
            addCriterion("uIdeNum <=", value, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumIn(List<Integer> values) {
            addCriterion("uIdeNum in", values, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumNotIn(List<Integer> values) {
            addCriterion("uIdeNum not in", values, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumBetween(Integer value1, Integer value2) {
            addCriterion("uIdeNum between", value1, value2, "uidenum");
            return (Criteria) this;
        }

        public Criteria andUidenumNotBetween(Integer value1, Integer value2) {
            addCriterion("uIdeNum not between", value1, value2, "uidenum");
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