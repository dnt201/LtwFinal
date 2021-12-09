<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ListProductPage">
    <img class="background" src="<c:url value='/assets/web/images/backgroundProduct.png'/>" alt="background"/>
    <div class="list-product-container">
        <div class="left-sidebar">
            <h2 class="header-left-sidebar"> Bộ lọc sản phẩm</h2>
            <div class="filter-wrap">
                <div class="filter-header">Hãng sản xuất</div>
                <div class="filter-body">
                    <div class="find-filter-wrap">
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value=Acer
                            />
                            <span>Acer</span>
                        </div>
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value=MSI
                            />
                            <span>MSI</span>
                        </div>
                        <div class="filter-item mg-b-8px">
                            <input type="radio" class="option-input radio" name="brand"
                                   value={0}
                            />
                            <span>All</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="filter-wrap m-t-16px">
                <div class="filter-header">Mức giá</div>
                <div class="filter-wrap-price">
                    <div class="price-filter active"> All
                    </div>
                    <div class="price-filter"> Dưới 10tr
                    </div>
                    <div class="price-filter"> 10Tr - 15Tr
                    </div>
                    <div class="price-filter"> 15Tr - 20Tr
                    </div>
                    <div class="price-filter"> 20Tr - 30Tr</div>
                    <div class="price-filter"> 30Tr - 40Tr</div>
                    <div class="price-filter"> Trên 40tr</div>

                    <div class="price-filter-input-wrap">
                        <div class="m-b-8px">Hoặc nhập giá trị dưới đây</div>
                        <div class="filter-input-price">
                            <input class="form-input tu"
                                   placeholder="Từ"
                            />
                            <input class="form-input"
                                   placeholder="Đến"
                            />
                        </div>
                    </div>
                    <button class="btn-apply-price" onclick="">Áp dụng</button>
                </div>
            </div>
        </div>
        <div class="product-list">
            <div class="list-header">
                <div class="header-name-list">
                    <h2 class="mg-r-8px">Loại sản phẩm</h2>
                    <span>Số lượng sản phẩm</span>
                </div>
                <div class="header-sort-list">
                    <span class="mg-r-8px">Sắp xếp theo</span>
                    <select>
                        <option>
                            Mới nhất
                        </option>
                        <option>
                            Giá (thấp - cao)
                        </option>
                        <option>
                            Giá (cao - thấp)
                        </option>
                        <option>
                            Tên (A - Z)
                        </option>
                        <option>
                            Tên (Z - A)
                        </option>
                    </select>
                </div>
            </div>
            <div class="product-list list">
                <%--Bắt đầu render list--%>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=1'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=2'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=3'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=4'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=5'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=6'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product imgaes"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                            <button class="add-to-card">
                                <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                <i class="fas fa-cart-plus add-to-card-icon"></i>
                            </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=7'/>" class="btn-details">Details</a>
                    </div>
                    <div class="item-product">
                        <div class="stick-percent"><p>Giảm 10%</p></div>
                        <img class="img-product" src="<c:url value='/assets/web/images/ge76-1.png'/>" alt="product images"/>
                        <h4 class="name"><b>Tên product</b></h4>
                        <div class="box-price">
                            <div class="sale-product">
                                <span class="price-sale"><fmt:formatNumber type = "number" value = "27000000" /> đ</span>
                                <span class="price-old"><fmt:formatNumber type = "number" value = "30000000" /> đ</span>
                            </div>
                            <c:if test="${User.getRoleModel().getRoleName() !='admin'}">
                                <button class="add-to-card">
                                    <c:out value = "${User.getRoleModel().getRoleName()}"/>
                                    <i class="fas fa-cart-plus add-to-card-icon"></i>
                                </button>
                            </c:if>
                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img
                                                src="<c:url value='/assets/web/images/cpu.png'/>" data-ll-status="loaded"
                                                alt=""/>
                                        <b>i5-10300h</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/gpu.png'/>" alt=""/>
                                        <b>Rx 9900M</b>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/ram.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>8Gb</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img src="<c:url value='/assets/web/images/storage.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <b>SSD: 512</b>
                                            <b>HDD: None</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <div class="detail">
                                        <img src="<c:url value='/assets/web/images/weight.png'/>" data-ll-status="loaded"
                                             alt=""/>
                                        <b>2.4Kg</b>
                                    </div>
                                </td>
                                <td>
                                    <div class="detail ml_16px">
                                        <img
                                                src="<c:url value='/assets/web/images/size.png'/>" alt=""/>
                                        <div class="flex_column_start">
                                            <div>
                                                <b>15.6'</b>
                                                <b>FullHd</b>
                                            </div>
                                            <b>144hz</b>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="<c:url value='/detail-product?product_id=8'/>" class="btn-details">Details</a>
                    </div>
            </div>


        </div>
    </div>
</div>