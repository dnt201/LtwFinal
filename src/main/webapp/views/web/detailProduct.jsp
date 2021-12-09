<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="detail-product-page-container">
    <div class="product-detail">
        <div class="product-detail-left loader_center">
            <img src={`${product.images}`} alt="123"/>
        </div>
        <div class="product-detail-right">
            <h1 class="name">Name product (có sale hong?)</h1>
            <div class='rating'>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                <span><i>0 lượt đánh giá</i></span>
            </div>
            <p class="des"> Description </p>
            <div class="status-quantity-price">
                <div class="status-quantity">
                    <div class="status">
                        <span class="all-ready-span"><i class="fa fa-check"></i>Còn hàng</span>
                        <%--<span class="sold-out-span"><FontAwesomeIcon icon={faTimes} /> Hết hàng</span>--%>
                    </div>
                    <div class="quantity">
                        <span>Số lượng</span>
                        <input class="quantity-input" type="number" id="quantity" name="quantity"
                               min="1"
                               value="1"
                        />
                    </div>
                </div>
                <div class="price">
                    <div class="new-price"> 100000</div>
                    <div class="old-price"> 100000</div>
                </div>
            </div>

            <div class="button">
                <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                <button onclick="" }> Add to cart <i class="fa fa-cart-arrow-down"></i></button>
                <button onClick=""> Buy now <i class="fa fa-receipt"></i></button>
                </c:if>
                <c:if test="${User.getRoleModel().getRoleName() =='admin'}">
                    <button className="btn-details" onClick=""> Details</button>
                </c:if>
            </div>

        </div>
    </div>
    <div class="review-wrap">
        <div class="create-review-container">
            <h1 class="t-a-center mg-32016">Đánh giá & nhận xét sản phẩm</h1>
            <div class="create-review">
                <div class="review-metqua">
                    <select class="review-select">
                        <option value='0'>Select...</option>
                        <option value='1'>1 - Poor</option>
                        <option value='2'>2 - Fair</option>
                        <option value='3'>3 - Good</option>
                        <option value='4'>4 - Very Good</option>
                        <option value='5'>5 - Excellent</option>
                    </select>
                    <button class="btn-post-review" onClick="">Post</button>
                </div>
                <textarea class="review-input" id="w3review" name="w3review" rows="4"/></textarea>
            </div>
            <div class="review-container">
                <span class="review-header">Reviews</span>
                <div class='rating'>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span style="color: #f8e825;}"><i class="far fa-star"></i></span>
                    <span><i>0 lượt đánh giá</i></span>
                </div>
            </div>
        </div>
    </div>
    <div class="product-detail-information">
        <div class="wrap">
            <h2>Thông số kỹ thuật</h2>
            <div class="line-item">
                <div>Tên sản phẩm</div>
                <div>Msi Gf63</div>
            </div>
            <div class="line-item">
                <div>Thương hiệu</div>
                <div>Acer</div>
            </div>
            <div class="line-item">
                <div>Màu sắc</div>
                <div>8GB (4GB + 4GB Onboard) DDR4 2400MHz ( 1 Khe cắm / Hỗ trợ tối đa 20GB )</div>
            </div>
            <div class="line-item"> Thông tin chung</div>
            <div class="line-item">
                <div>Thế hệ CPU</div>
                <div>Core i5 , Intel Core thế hệ thứ 10 - Intel Core i5-1035G1 ( 1.2 GHz - 3.4 GHz / 4MB / 2 nhân, 4
                    luồng )
                </div>
            </div>
            <div class="line-item">
                <div>Card đồ họa</div>
                <div>NVIDIA GeForce MX330 2GB GDDR5 / Intel UHD Graphics</div>
            </div>
            <div class="line-item">
                <div>RAM</div>
                <div>8GB (4GB + 4GB Onboard) DDR4 2400MHz ( 1 Khe cắm / Hỗ trợ tối đa 20GB )</div>
            </div>
            <div class="line-item">
                <div>Màn hình</div>
                <div>8GB (4GB + 4GB Onboard) DDR4 2400MHz ( 1 Khe cắm / Hỗ trợ tối đa 20GB )</div>
            </div>
            <div class="line-item">
                <div>Lưu trữ</div>
                <div>8GB (4GB + 4GB Onboard) DDR4 2400MHz ( 1 Khe cắm / Hỗ trợ tối đa 20GB )</div>
            </div>
            <div class="line-item">
                <div>Pin</div>
                <div>3 cell 36 Wh , Pin liền</div>
            </div>
            <div class="line-item">
                <div>Cổng kết nối</div>
                <div>1 x M.2 NVMe, 1 x HDMI, 2 x USB 3.2, 1 x USB 2.0, LAN 1 Gb/s</div>
            </div>
        </div>
    </div>
</div>