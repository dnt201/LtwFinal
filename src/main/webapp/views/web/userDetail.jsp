<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${model.getRoleModel().getRoleName() !='admin'}">
    <div class="container rounded bg-white mt-2 mb-1">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <img class="rounded-circle mt-5"
                         width="150px"
                         src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
                    />
                    <h3 class="font-weight-bold">${model.name}</h3>
                    <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                            class="fa fa-user"></i> ${model.username}</span>
                    <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                            class="fa fa-envelope"></i> ${model.email}</span>
                    <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                            class="fa fa-phone"></i> ${model.phone}</span>
                    <span class="text-black-50 f-s-20px t-a-left w-100p"><i
                            class="fa fa-address-book"></i> ${model.address}</span>
                    <div class="mt-5 text-center">
                        <a class="btn btn-primary profile-button" href="<c:url value='/me?action=update-profile'/>">Update
                            profile </a>
                    </div>
                </div>
            </div>
            <div class="col-md-9 border-right">
                <div class="row">
                    <div class="col-md-12 ">
                        <h1 class="t-a-center m-b-12px">List order (${orders.size()})</h1>
                    </div>

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
            </div>
        </div>
    </div>
</c:if>

<c:if test="${model.getRoleModel().getRoleName() =='admin'}">
    <div class="container rounded bg-white mt-2 mb-1">
        <div class="col">
            <h1 class="t-a-center">Hello admin!</h1>
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle"
                     width="150px"
                     src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
                />
                <h3 class="font-weight-bold">${model.name}</h3>
                <span class="text-black-50 f-s-20px"><i class="fa fa-user"></i> ${model.username}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-envelope"></i> ${model.email}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-phone"></i> ${model.phone}</span>
                <span class="text-black-50 f-s-20px"><i class="fa fa-address-book"></i> ${model.address}</span>
                <div class="mt-5 text-center">
                    <a class="btn btn-primary profile-button" href="<c:url value='/me?action=update-profile'/>">Update
                        profile </a>
                </div>
            </div>
        </div>
    </div>
</c:if>
