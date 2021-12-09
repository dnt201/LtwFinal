<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="CartPage">
<%--    {showDetailOder && orderCreate.order && <ThankForBuy handleClose={() => setShowDetailOrder(!showDetailOder)} id={orderCreate?.order?._id} user={orderCreate?.order?.user} thanks={true} />}--%>
    <div class="cart-information">
        <h1 class="w-100p center">Thông tin</h1>
        <div class="m-l-8px">
            <h3>Họ tên:</h3>
            <h3>Gmail: </h3>
            <div class="lv1">
                <h3>Số điện thoại: </h3>
                <input type="number"
                       placeholder="Ex: 0333123123"
                />
            </div>
            <div class="lv1">
                <h3>Địa chỉ: </h3>
                <input
                        type="text"
                        placeholder="Ex: 110/20 Phạm Văn Đồng Phường Linh Chiểu"}
                />
            </div>
        </div>
        <div class="t-a-center">
            Bạn chưa đăng nhập, hãy <Link class="lazy-css" to="/login">đăng nhập</Link> để hoàn tất đơn hàng! &#10084;
        </div>
    <div class="container-cart-page">
        <div class="cart-page-left flex-4">
            <div class="left-header">
                <h1> Shopping Cart</h1>
                <span>{cartItems.length} items </span>
            </div>
            <div class="left-list-item">

                <table class="w-100p">
                    <colgroup>
                        <col span="1" style="width:45%" />
                        <col span="1" style="width:15%" />
                        <col span="1" style="width:15%" />
                        <col span="1" style="width:25%" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th>Item</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%-- map cart item--%>
                    <tr key={cartItem.product} class="item vtc-al-baseline ta-center  row-item-lazzy-quatroidat">
                        <td class="flex al-it-center jfct-center item-infor">
                            <div>
                                <span class="cart-item-price">{cartItem.name}</span>
                                <br />
                                <button class="remove-cart-item-btn">Remove <i class="fa fa-times remove-cart-item"></i></button>
                            </div>
                            <img class="cart-item-img" src={cartItem.image} alt="123" />
                        </td>
                        <td>
                            <%--không sale--%>
                            <span class="cart-item-price"> {Intl.NumberFormat('de-DE').format(cartItem.price) + " đ"}  </span>

                            <%--sale--%>
                            <div>
                                <span class="cart-item-price-x"> {Intl.NumberFormat('de-DE').format(cartItem.price) + " đ"}  </span> <br />
                                <span class="cart-item-price sale"> {Intl.NumberFormat('de-DE').format(cartItem.salePrice) + " đ"}  </span>
                            </div>}
                        </td>
                        <td>
                            <input class="w-80p" type="number" id="quantity" name="quantity" value="1" min="1"/>
                        </td>
                        <td >
                            <span>{Intl.NumberFormat('de-DE').format(cartItem.salePrice * cartItem.qty) + " đ"}</span>
                            }
                        </td>
                    </tr>)
                    )}
                    {/* End-item */}
                    </tbody>
                </table>
                <h3 class="ta-center w-100p"> <i>Bạn chưa có sản phẩm nào trong giỏ</i></h3>
            </div>
            <div class="footer">
                <button>Back to shop</button>
            </div>
        </div>

        <div class="cart-page-right ">
            <div class="right-header">
                <h1 class="ta-center"> ShopND</h1>

            </div>
            <div class="right-container flex-8">

            <%--Cart rỗng--%>
                <h3 class="t-a-center"> Opps! Bạn chưa mua gì cả ❤</h3>
                <h2>Summary</h2>
                <div class="m-bt-16px summary-lazy-css">
                    <span>Tổng số lượng hàng: </span>
                    <span class="ta-right f-b">Giá hàng</span>
                </div>

                <div class="m-bt-16px summary-lazy-css">
                    <span>Phí ship: </span>
                    <span class="ta-right f-b">0 đ</span>
                </div>
                <div class="m-bt-px summary-lazy-css">
                    <span>Tổng tiền: </span>
                    <span class="ta-right f-b cl-red">Tổng bill</span>
                </div>
            </>
            }
        </div>
        <div class="footer">
            <button class="checkout-footer">CHECKOUT</button>
        </div>
    </div>
</div>
</div>
