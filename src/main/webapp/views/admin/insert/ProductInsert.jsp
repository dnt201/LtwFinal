<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<div class="wrap-form-center">
    <form id="wtfloihoai" action="<c:url value='/admin/product'/>" class="formCenter shadow p-3 mb-5 bg-body rounded">
        <div class="form-header">
            <h1>Product Insert or Update</h1>
            <ul class="list-inline text-sm">
                <li class="list-inline-item"><button disabled class=" btn btn-outline-warning"><i
                        class="fas fa-copy me-2">
                </i>Copy</button></li>
                <li class="list-inline-item"><button disabled class=" btn btn-outline-info"><i
                        class="fas fa-download me-2">
                </i>Import</button></li>
            </ul>
            <h6><i class="text-danger">${messageResponse}</i></h6>
        </div>
        <section>
            <div>
                <div class="">
                    <div class="">
                        <div class="card-header">
                            <div class="card-heading">
                                <h4 class="fw-bold">Form product</h4>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Product name <i class="fa fa-laptop"></i>
                                    </h6>
                                    <input name="productName" class="form-control" value="${model.productName}"
                                           placeholder="Enter your product name ...">
                                </div>
                            </div>
                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Description <i class="fa fa-cloud"></i></h6>
                                    <input name="description" class="form-control" value="${model.description}"
                                           placeholder="Enter your description ...">
                                </div>
                            </div>

                            <div class="row gy-3">
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Image <i class="fa fa-images"></i></h6>
                                    <input type =hidden id ="store-url-firebase" name="image">
                                    <input type="file" id="image-up-firebase" name="khongphaicainay" class="form-control"
                                           required>
                                    <c:if test="${empty model}">
                                    <img class="image-previews"  alt="Pumb" id="image-preview-up-firebase"/>
                                    </c:if>
                                    <c:if test="${not empty model}">
                                        <img src="${model.image}"class="image-previews"  alt="Pumb" id="image-preview-up-firebase"/>
                                    </c:if>
                                </div>
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Price <i class="fa fa-dollar-sign"></i></h6>
                                    <input name="price" class="form-control" value="${model.price}"
                                           placeholder="Enter your price ...">
                                    <h6 class="form-label fw-bold">Brand: <i class="fa fa-copyright"></i></h6>
                                    <select class="form-select" name="brand_id" id="brandModel">
                                    <c:if test="${empty model}">
                                        <c:forEach var="brand" items="${brandModel}">
                                            <option value="${brand.brand_id}"> ${brand.brand_name}</option>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty model}">
                                        <c:forEach var="brand" items="${brandModel}">
                                            <option value="${brand.brand_id}"
                                                    <c:if test="${brand.brand_id == model.brandModel.brand_id}">selected="selected"
                                            </c:if>>
                                                    ${brand.brand_name}
                                            </option>
                                        </c:forEach>
                                    </c:if>
                                    </select>
                                    <h6 class="form-label fw-bold">discount_id <i class="fa fa-tags"></i></h6>
                                    <%--KHông product -> add--%>
                                    <select class="form-select" name="discount_id" id="discount_id">
                                    <c:if test="${empty model}">
                                        <c:forEach var="discount" items="${discountModel}">
                                            <option value="${discount.discount_id}"> ${discount.discountName}</option>
                                        </c:forEach>
                                    </c:if>
                                    <%--Có product -> Update và default check là model--%>
                                    <c:if test="${not empty model}">
                                        <c:forEach var="discount" items="${discountModel}">
                                            <option value="${discount.discount_id}"
                                                    <c:if test="${discount.discount_id == model.discount.discount_id}">selected="selected"
                                            </c:if>>
                                                    ${discount.discountName}
                                            </option>
                                        </c:forEach>
                                    </c:if>
                                    </select>
                                </div>

                            </div>

                            <div class="row gy-3">
                                <div class="col-md-3">
                                    <h6 class="form-label fw-bold">Cpu <i class="fa fa-microchip"></i></h6>
                                    <input name="sCpu" class="form-control" value="${model.sCpu}"
                                           placeholder="Enter your sCpu ...">
                                </div>
                                <div class="col-md-9">
                                    <h6 class="form-label fw-bold">Detail CPU: </h6>
                                    <input name="cpu" class="form-control" value="${model.cpu}"
                                           placeholder="Enter your detail cpu ...">
                                </div>
                            </div>
                            <div class="row gy-3">
                                <div class="col-md-3">
                                    <h6 class="form-label fw-bold">Vga <i class="fa fa-vr-cardboard"></i></h6>
                                    <input name="sVga" class="form-control" value="${model.sVga}"
                                           placeholder="Enter your sVga ...">
                                </div>
                                <div class="col-md-9">
                                    <h6 class="form-label fw-bold">Detail VGA:</h6>
                                    <input name="vga" class="form-control" value="${model.vga}"
                                           placeholder="Enter your vga ...">
                                </div>
                            </div>
                            <div class="row gy-3">
                                <div class="col-md-3">
                                    <h6 class="form-label fw-bold">Ram <i class="fa fa-weight-hanging"></i></h6>
                                    <input name="sRam" class="form-control" value="${model.sRam}"
                                           placeholder="Enter your sRam ...">
                                </div>
                                <div class="col-md-9">
                                    <h6 class="form-label fw-bold">Detail RAM:</h6>
                                    <input name="ram" class="form-control" value="${model.ram}"
                                           placeholder="Enter your ram ...">
                                </div>
                            </div>

                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Storage <i class="fa fa-hdd"></i></h6>
                                    <input name="storage" class="form-control" value="${model.storage}"
                                           placeholder="Enter your storage ...">
                                </div>
                            </div>
                            <div class="row gy-3">
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Ssd</h6>
                                    <input name="sSsd" class="form-control" value="${model.sSsd}"
                                           placeholder="Enter your sSsd ...">
                                </div>
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Hdd</h6>
                                    <input name="sHdd" class="form-control" value="${model.sHdd}"
                                           placeholder="Enter your sHdd ...">
                                </div>
                            </div>



                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Monitor <i class="fa fa-desktop"></i></h6>
                                    <input name="monitor" class="form-control" value="${model.monitor}"
                                           placeholder="Enter your monitor ...">
                                </div>
                            </div>

                            <div class="row gy-3">
                                <div class="col-md-4">
                                    <h6 class="form-label fw-bold">Size</h6>
                                    <input name="sSize" class="form-control" value="${model.sSize}"
                                           placeholder="Enter your sSize ...">
                                </div>
                                <div class="col-md-4">
                                    <h6 class="form-label fw-bold">Hz</h6>
                                    <input name="sHz" class="form-control" value="${model.sHz}"
                                           placeholder="Enter your sHz ...">
                                </div>
                                <div class="col-md-4">
                                    <h6 class="form-label fw-bold">Resolution</h6>
                                    <input name="sResolution" class="form-control" value="${model.sResolution}"
                                           placeholder="Enter your sResolution ...">
                                </div>
                            </div>
                            <div class="row gy-3">
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Weight <i class="fa fa-weight-hanging"></i></h6>
                                    <input name="sWeight" class="form-control" value="${model.sWeight}"
                                           placeholder="Enter your sWeight ...">
                                </div>
                                <div class="col-md-6">
                                    <h6 class="form-label fw-bold">Color <i class="fa fa-eye-dropper"></i></h6>
                                    <input name="color" class="form-control" value="${model.color}"
                                           placeholder="Enter your color ...">
                                </div>
                            </div>


                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Pin <i class="fa fa-battery-three-quarters"></i></h6>
                                    <input name="pin" class="form-control" value="${model.pin}"
                                           placeholder="Enter your pin ...">
                                </div>
                            </div>

                            <div class="row gy-3">
                                <div class="col-12">
                                    <h6 class="form-label fw-bold">Connection <i class="fa fa-plug"></i></h6>
                                    <input name="connection" class="form-control" value="${model.connection}"
                                           placeholder="Enter your connection ...">
                                </div>
                            </div>

                            <div style="margin-top: 10px" class="form-text" id="notification"></div>
                            <c:if test="${empty model}">
                                <input type="hidden" name="action" value="add" />
                                <button style="margin-top: 10px" class="btn btn-outline-primary mb-4" type="submit" id="firebase-trigger">Add
                                    product</button>
                            </c:if>
                            <c:if test="${not empty model}">
                                <input type="hidden" name="action" value="update" />
                                <input type="hidden" name="product_id" value="${model.product_id}"/>
                                <button style="margin-top: 12px" class="btn btn-outline-danger mb-4" type="submit" id="firebase-trigger">Update</button>
                            </c:if>
                        </div>
                    </div>
                </div>

            </div>
        </section>
    </form>
</div>