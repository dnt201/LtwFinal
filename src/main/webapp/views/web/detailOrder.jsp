<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div class="detail-order-container">
    <div class="wrap">
        <div class="flex-row jt-ct-center align-item-center">
            <h1 class="m-r-8px t-a-center">Order (id order)</h1>
        </div>
        <div class="detail-order-wrap">
            <div class="quatroiluoiluon jt-ct-sb">
                <div>
                    <div>
                        <span class="w-170px"><b>Customer: </b></span>
                        <span>${model.usersModel.username}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Email: </b></span>
                        <span>${model.usersModel.email}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Numbs of product: </b></span>
                        <c:set var="total" value="${0}"/>
                        <c:forEach var="item" items="${model.orderItemsList}">
                            <c:set var="total" value="${total + item.quantity}"/>
                        </c:forEach>
                        <span>${total}</span>
                    </div>
                    <div>
                        <span class="w-170px"><b>Order Date: </b></span>
                        <span>${model.createAt}</span>
                    </div>
                </div>
                <div class="quatroiluoiluon1">
                    <div>
                        <span class="w-170px"><b>Address: </b></span>
                        <span>${model.usersModel.address}/span>
                    </div>
                    <div>
                        <span><b>Phone number: </b></span>
                        <span>${model.usersModel.phone}</span>
                    </div>

                </div>
            </div>
            <div>
                <table class="w-100p m-b-8px table">
                    <colgroup>
                        <col span="1" style="width: 45%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:10%"/>
                        <col span="1" style="width:15%"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>Product name</th>
                        <th>Unit price</th>
                        <th>Discount</th>
                        <th>Sale price</th>
                        <th>Quantity</th>
                        <th>Total price</th>
                    </tr>
                    </thead>

                    <%--Start-item--%>
                    <tbody>

                    <c:set var="Sum" value="${0}"/>
                    <c:forEach var="item" items="${model.orderItemsList}">
                        <tr class="t-a-center">
                            <td class="t-a-left p-l-4px">
                                <span>${item.productModel.productName}</span>
                            </td>
                            <td>
                                <span>${item.productModel.price}</span>
                            </td>
                            <td>
                                <span>${item.productModel.discount.discountPercent}</span>
                            </td>
                            <td>
                                <span>${item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100}</span>
                            </td>
                            <td>
                                <span>${item.quantity}</span>
                            </td>
                            <td class="t-a-right">
                                <span>${(item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100)*item.quantity}</span>
                                <c:set var="Sum" value="${Sum + (item.productModel.price - item.productModel.price*item.productModel.discount.discountPercent/100)*item.quantity}"/>
                            </td>
                        </tr>
                    </c:forEach>>
                    </tbody>
                    <%--End item--%>
                </table>
            </div>
            <div class="flex-column  align-item-flex-end">
                <span><b>Item price:</b>${Sum}</span><br/>
                <span><b>Shipping price:</b>   0 đ</span><br/>
                <span><b>Total:</b>${Sum}</span>
            </div>
        </div>
    </div>

</div>