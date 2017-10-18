<%--
  Created by IntelliJ IDEA.
  User: Aniu
  Date: 10/17/2017
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>
<style>
</style>


<div class="container">
    <form action="">
        <h4>Create Post</h4>
        <div class="row">
            <div class="input-field col s12">
                <input id="mark" type="text" class="validate" name="title">
                <label for="mark">Mark of Car</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="description" type="text" class="validate" name="body">
                <label for="description">Description of Car</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="city" type="text" class="validate" name="city">
                <label for="city">City where car is sold</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="date" type="text" class="datepicker" name="date">
                <label for="date">Date</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="age" type="number" class="validate" name="age">
                <label for="age">Age of Car</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="price" type="number" class="validate" name="price">
                <label for="price">Price of Car</label>
            </div>
        </div>

        <button class="btn waves-effect waves-light" type="submit" name="action">Create Post
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>
<%@include file="../footer.jsp" %>
<script>
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year,
        today: 'Today',
        clear: 'Clear',
        close: 'Ok',
        closeOnSelect: false // Close upon selecting a date,
    });
</script>