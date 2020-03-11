<%@ page import="pl.sda.twitter.constans.SessionValues" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.messages != null}">
        <div style="position: relative; width: 400px; padding: 16px 0 0; margin: 100px auto 0;">
            <c:forEach items="${sessionScope.messages}" var="element">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="dismissMessage('${element}')">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${element}
                </div>
            </c:forEach>
        </div>

<%--        <%--%>
<%--            final String messages = SessionValues.MESSAGES.getValue();--%>
<%--            session.removeAttribute(messages);--%>
<%--        %>--%>

        <script>
            function dismissMessage(message) {
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "remove-message?message=" + message, true);
                xhr.send();
            }
        </script>


    </c:when>
</c:choose>
