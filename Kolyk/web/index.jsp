<%@ page import="DB.DTO.PostDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Kolyk</title>
    <style>
        .card, form, .post_filter {
            display: flex;
        }
        form {
            flex-direction: column;
            width: 100%;
        }
        .post_filter {
            width: 100%;
        }
        .card .post_filter .filters, .card .post_filter .sorters {
            min-width: 50%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .card .post_filter .filters .title , .card .post_filter .sorters .title{
            font-size: 35px;
        }
        .card .post_filter .filters .input-field, .card .post_filter .sorters .input-field{
            margin-bottom: 50px;
        }
        .card .post_filter .filters .fields, .card .post_filter .sorters .fields{
            margin-top: 20px;
            width: 80%;
        }
        .card .button {
            display: flex;
            justify-content: center;
        }
        .kolyk {
            min-width: 90%;
            max-width: 90%;
        }
        .content {
            display: flex;
            flex-direction: column;
            align-items: center;
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
  </head>
  <body>
    <div class="container-fluid">
      <%@include file="header.jsp" %>
      <div class="form">
        <div class="card">
            <form action="">
                <div class="post_filter">
                    <div class="filters">
                        <span class="title">Filters</span>
                        <div class="fields">
                            <div class="input-field col s12">
                                <select multiple>
                                    <option value="1">Almaty</option>
                                    <option value="2">Shymkent</option>
                                    <option value="3">Astana</option>
                                </select>
                                <label>Cities</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Passenger Car</option>
                                    <option value="2">Crossover</option>
                                    <option value="3">Minivan</option>
                                </select>
                                <label>Type of Car</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Petrol</option>
                                    <option value="2">Diesel</option>
                                    <option value="3">Gas-petrol</option>
                                    <option value="4">Gas</option>
                                    <option value="5">Hybrid</option>
                                    <option value="6">Electric</option>
                                </select>
                                <label>Type of Engine</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Left</option>
                                    <option value="2">Right</option>
                                </select>
                                <label>Steering position</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Front Transmission</option>
                                    <option value="2">Full Transmission</option>
                                    <option value="3">Back Transmission</option>
                                </select>
                                <label>Transmission</label>
                            </div>
                        </div>
                    </div>
                    <div class="sorters">
                        <span class="title">Sorters</span>
                        <div class="fields">
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Ascending</option>
                                    <option value="2">Descending</option>
                                </select>
                                <label>By Price</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Newest</option>
                                    <option value="2">Oldest</option>
                                </select>
                                <label>By Post Date</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Newest</option>
                                    <option value="2">Oldest</option>
                                </select>
                                <label>By Age of Car</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Ascending</option>
                                    <option value="2">Descending</option>
                                </select>
                                <label>Steering position</label>
                            </div>
                            <div class="input-field col s12">
                                <select>
                                    <option value="1">Ascending</option>
                                    <option value="2">Descending</option>
                                </select>
                                <label>Transmission</label>
                            </div>
                        </div>
                    </div>
                </div>
                <dib class="button">
                    <a class="waves-effect waves-light btn">Filter</a>
                </dib>
            </form>
        </div>
      </div>
      <div class="content">
          <c:forEach items="${postDTOs}" var="postDTO">
              <div class="card kolyk">
                  <div class="image">
                      <img src="https://lumiere-a.akamaihd.net/v1/images/vt_cars3_nextgenerationextendedlook_900f0dd1.jpeg" width="200px" height="200px">
                  </div>
                  <div class="card_content">
                      <div class="content_title">
                          <span class="mark">${postDTO.getTitle()}</span>
                          <span class="some_text">for</span> <span class="price">${postDTO.getPrice()}</span>
                      </div>
                      <div class="content_description">
                          <p>${postDTO.getAge()}, ${postDTO.getPrice()}, ${postDTO.getDate()}</p>
                      </div>
                  </div>
              </div>
          </c:forEach>
      </div>
      <%@include file="footer.jsp" %>
    </div>
  </body>
</html>
