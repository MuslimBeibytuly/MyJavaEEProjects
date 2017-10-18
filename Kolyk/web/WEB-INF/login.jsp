
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>

<style>
    form {
        padding: 10px;
    }

    @-webkit-keyframes autofill {
        to {
            background: transparent;
        }
    }

    input:-webkit-autofill {
        -webkit-animation-name: autofill;
        -webkit-animation-fill-mode: both;
    }

    .input-field {
        padding: 0 !important;
    }
</style>

<form action="${pageContext.request.contextPath}/login" method="POST">
    <h4>Login</h4>
    <div class="row" style="margin-top: 20px;">
        <div class="input-field col s12">
            <input id="email" type="email" class="validate" name="email">
            <label for="email">Email</label>
        </div>
    </div>

    <div class="row">
        <div class="input-field col s12">
            <input id="password" type="password" class="validate" name="password">
            <label for="password">Password</label>
        </div>
    </div>

    <button class="btn waves-effect waves-light" type="submit" name="action">Login
        <i class="material-icons right">send</i>
    </button>
</form>

<%@include file="../footer.jsp" %>