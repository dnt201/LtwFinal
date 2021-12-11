<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/10/2021
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container rounded bg-white mt-2 mb-1">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                         width="150px"
                                                                                         src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                    class="font-weight-bold">${model.name}</span><span
                    class="text-black-50">${model.email}</span><span> </span></div>
        </div>
        <div class="col-md-9 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Full Name: </label>
                        <input type="text" class="form-control" placeholder="Enter your name..." value="${model.name}"
                               name="username">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Email: </label>
                        <input type="text" class="form-control" placeholder="Enter your email..." value="${model.email}"
                               name="email">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Address: </label>
                        <input type="text" class="form-control" placeholder="Enter your address..."
                               value="${model.address}"
                               name="address">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Phone number: </label>
                        <input type="number" class="form-control" placeholder="Enter your phone number..."
                               value="${model.phone}">
                    </div>
                </div>
                <div class="mt-5 text-center">
                    <button class="btn btn-primary profile-button" type="button">Save
                        Profile
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 ">
            <h1>List order</h1>
        </div>
        ${orders.size()}

        <c:forEach var="item" items="${orders}">
            <div class="row">
                <div class="col-md-4">${item.order_id}</div>
                <div class="col-md-4">
                    <table>
                        <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        <tr>
                            <c:forEach var="lineItem" items="${item.getOrderItemsList()}">
                                <td class="col-md-4">${lineItem.productModel.productName}</td>
                                <td class="col-md-4">${lineItem.quantity}</td>
                                <td class="col-md-4">${(lineItem.productModel.price-(lineItem.productModel.price*lineItem.productModel.discount.discountPercent/100))*lineItem.quantity}</td>
                            </c:forEach>
                        </tr>
                    </table>
                </div>
                <div class="col-md-4">${item.total}</div>
                <div class="col-md-4">${item.createAt}</div>
            </div>
        </c:forEach>
    </div>


    <!-- End list order-->
</div>
</div>
