
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp" %>

<style>
    .my_posts {
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .card {
        display: flex;
    }
    .container-fluid {
        display: flex;
        width: 100%;
        height: 100%;
    }
    .container-fluid .sidenav {
        min-width: 400px;
        max-width: 400px;
    }
    .collection {
        height: 100%;
    }
    .kolyk {
        min-width: 90%;
        max-width: 90%;
    }
    .card_content {
        padding: 10px;
    }
    .mark {
        color: #0000FF;
        text-decoration: underline;
    }
    .price {
        color: #209e25;
    }
    .mark, .price {
        font-size: 20px;
        padding: 0 30px;
    }
    .some_text {
        color: #DDDDDD;
        font-size: 16px;
    }

    .content_description p {
        padding: 0 30px;
    }
</style>

<div class="container-fluid">
    <div class="sidenav">
        <div class="collection with-header">
            <div class="collection-header"><h4>Nikolay Sergeevich Brejnev</h4></div>
            <a href="/createPost/" class="collection-item">Create Post</a>
            <a href="/" class="collection-item">Log Out</a>
        </div>
    </div>
    <div class="my_posts">
        <div class="card kolyk">
            <div class="image">
                <img src="https://lumiere-a.akamaihd.net/v1/images/vt_cars3_nextgenerationextendedlook_900f0dd1.jpeg" width="200px" height="200px">
            </div>
            <div class="card_content">
                <div class="content_title">
                    <span class="mark">Mark</span> <span class="some_text">for</span> <span class="price">20 $</span>
                </div>
                <div class="content_description">
                    <p>2007 г., Седан, 3.5 л, бензин, КПП типтроник, синий, металлик, люк, литые диски, багажник, тонировка,
                        ксенон, корректор фар, противотуманки, дневные ходовые огни, обогрев зеркал</p>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %>