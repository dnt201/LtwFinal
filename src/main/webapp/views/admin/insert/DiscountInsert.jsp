<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="wrap">
    <form class="insert-dis" action="<c:url value='/admin/discount'/>" method="post">
        <input type="hidden" name="action" value="add"/>

        <label class="m-b-4px">discountName</label>
        <input id="discountName"
               name="discountName"
               type="text" placeholder="Enter your discount name..."
        />
        <label class="m-b-4px">description</label>
        <input id="description"
               name="description"
               type="text" placeholder="Enter your description..."
        />
        <label class="m-b-4px">discountPercent</label>
        <input id="discountPercent"
               name="discountPercent"
               type="text" placeholder="Enter your discountPercent..."
        >
        <button type="submit">Submit</button>
    </form>
</div>