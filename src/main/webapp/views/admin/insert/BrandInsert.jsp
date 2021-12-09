<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="wrap">
    <form class="insert-brand" action="<c:url value='/admin/brand'/>" method="post">
        <input type="hidden" name="action" value="add"/>
        <label class="m-b-4px">Brand</label>
        <input id="brand_name"
               name="brand_name"
               type="text" placeholder="Enter your brand..."
        />
        <button type="submit">Submit</button>
    </form>
</div>
