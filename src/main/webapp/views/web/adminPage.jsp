<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/8/2021
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div>
    <form class="insert-brand" action="<c:url value='/admin/brand'/>" method="get">
        <input type="hidden" name="action" value="add"/>
        <label class="m-b-4px">Brand</label>
        <input id="brand_name"
               name="brand_name"
              type="text" placeholder="Enter your brand..."
        />
        <button type="submit">Submit</button>
    </form>
    <form class="insert-dis" action="<c:url value='/admin/discount'/>" method="get">
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
        <input id ="discountPercent"
               name="discountPercent"
               type="text" placeholder="Enter your discountPercent..."
        >
        <button type="submit">Submit</button>
    </form>
    <form class="insert-product" action="<c:url value='/admin/product'/>" method="get">
        <input type="hidden" name="action" value="add"/>
    </form>
</div>