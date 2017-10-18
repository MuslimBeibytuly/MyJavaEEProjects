
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
<style>
    .nav-wrapper {
        padding: 0 20px;
    }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pickadate.js/3.5.6/picker.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="/" class="brand-logo">Kolyk</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <c:if test="${user == null}">
                    <li><a href="/register/">Register</a></li>
                    <li><a href="/login/">Login</a></li>
                </c:if>
                <c:if test="${user != null}">
                    <li><a href="/profile/">Profile</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
