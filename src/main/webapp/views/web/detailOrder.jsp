<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<div className="detail-order-container">
    <div className="wrap">
        <div className="flex-row jt-ct-center align-item-center">
            <h1 className="m-r-8px">Order #{props.id}</h1>
        </div>
        {props.thanks && props.thanks===true&& <h3 className="thanks-css t-a-center">Cảm ơn bạn đã mua hàng!</h3>}
        <div className="detail-order-wrap">
            <div className="flex-row jt-ct-sb">
                <div>
                    <div>
                        <span className="w-170px"><b>Customer: </b></span>
                        <span>userName</span>
                    </div>
                    <div>
                        <span className="w-170px"><b>Email: </b></span>
                        <span>email</span>
                    </div>
                    <div>
                        <span className="w-170px"><b>Numbs of product: </b></span>
                        <span>số line order</span>
                    </div>
                    <div>
                        <span className="w-170px"><b>Order Date: </b></span>
                        <span>Ngày tạo</span>
                    </div>
                </div>
                <div className="t-a-right">
                    <div>
                        <span className="w-170px"><b>Address: </b></span>
                        <span>Địa chỉ</span>
                    </div>
                    <div>
                        <span><b>Phone number: </b></span>
                        <span>số đt</span>
                    </div>

                </div>
            </div>
            <div>
                <table className="w-100p m-b-8px table">
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
                    <%--Map here--%>
                    <tr className="t-a-center">
                        <td className="t-a-left p-l-4px">
                            <span> Name product</span>
                        </td>
                        <td>
                            <span>Giá tiền</span>
                        </td>
                        <td>
                            <span>% giảm giá</span>
                        </td>
                        <td>
                            <span>Số tiền sau khi giảm giá</span>
                        </td>
                        <td>
                            <span>Số lượng sản phẩm</span>
                        </td>
                        <td className="t-a-right">
                            <span>Giá tiền sau khi nhân</span>
                        </td>
                    </tr>
                    <%--End map--%>
                    </tbody>
                <%--End item--%>
                </table>
            </div>
            <div className="flex-column  align-item-flex-end">
                <span><b>Item price:</b>Total money</span><br/>
                <span><b>Shipping price:</b>   0 đ</span><br/>
                <span><b>Total:</b>  Total money</span>
            </div>
        </div>
    </div>
    }

</div>