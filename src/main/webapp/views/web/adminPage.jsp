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
    <form class="insert-brand" action="<c:url value='/admin/brand'/>" method="post">
        <input type="hidden" name="action" value="add"/>
        <label class="m-b-4px">Brand</label>
        <input id="brand_name"
               name="brand_name"
               type="text" placeholder="Enter your brand..."
        />
        <button type="submit">Submit</button>
    </form>
    <!--
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
        <input id ="discountPercent"
               name="discountPercent"
               type="text" placeholder="Enter your discountPercent..."
        >
        <button type="submit">Submit</button>
    </form>
    -->
    <!--
    <form class="insert-product" action="<c:url value='/admin/product'/>" method="post">
        <input type="hidden" name="action" value="add"/>

        <label class="m-b-4px">productName</label>
        <input id="productName"
               name="productName"
               type="text" placeholder="Enter your productName ..."
        />

        <label class="m-b-4px">description</label>
        <input id="description"
               name="description"
               type="text" placeholder="Enter your description ..."
        />

        <label class="m-b-4px">price</label>
        <input id="price"
               name="price"
               type="text" placeholder="Enter your price ..."
        />

        <label class="m-b-4px">image</label>
        <input id="image"
               name="image"
               type="text" placeholder="Enter your image ..."
        />

        <label class="m-b-4px">sCpu</label>
        <input id="sCpu"
               name="sCpu"
               type="text" placeholder="Enter your sCpu ..."
        />

        <label class="m-b-4px">sVga</label>
        <input id="sVga"
               name="sVga"
               type="text" placeholder="Enter your sVga ..."
        />

        <label class="m-b-4px">sRam</label>
        <input id="sRam"
               name="sRam"
               type="text" placeholder="Enter your sRam ..."
        />

        <label class="m-b-4px">sSsd</label>
        <input id="sSsd"
               name="sSsd"
               type="text" placeholder="Enter your sSsd ..."
        />

        <label class="m-b-4px">sHdd</label>
        <input id="sHdd"
               name="sHdd"
               type="text" placeholder="Enter your Hdd ..."
        />

        <label class="m-b-4px">sWeight</label>
        <input id="sWeight"
               name="sWeight"
               type="text" placeholder="Enter your sWeight ..."
        />

        <label class="m-b-4px">sSize</label>
        <input id="sSize"
               name="sSize"
               type="text" placeholder="Enter your sSize ..."
        />

        <label class="m-b-4px">sHz</label>
        <input id="sHz"
               name="sHz"
               type="text" placeholder="Enter your sHz ..."
        />

        <label class="m-b-4px">sResolution</label>
        <input id="sResolution"
               name="sResolution"
               type="text" placeholder="Enter your sResolution ..."
        />

        <label class="m-b-4px">cpu</label>
        <input id="cpu"
               name="cpu"
               type="text" placeholder="Enter your cpu ..."
        />

        <label class="m-b-4px">vga</label>
        <input id="vga"
               name="vga"
               type="text" placeholder="Enter your vga ..."
        />

        <label class="m-b-4px">ram</label>
        <input id="ram"
               name="ram"
               type="text" placeholder="Enter your ram ..."
        />

        <label class="m-b-4px">monitor</label>
        <input id="monitor"
               name="monitor"
               type="text" placeholder="Enter your monitor ..."
        />

        <label class="m-b-4px">storage</label>
        <input id="storage"
               name="storage"
               type="text" placeholder="Enter your storage ..."
        />

        <label class="m-b-4px">pin</label>
        <input id="pin"
               name="pin"
               type="text" placeholder="Enter your pin ..."
        />

        <label class="m-b-4px">color</label>
        <input id="color"
               name="color"
               type="text" placeholder="Enter your color ..."
        />

        <label class="m-b-4px">connection</label>
        <input id="connection"
               name="connection"
               type="text" placeholder="Enter your connection ..."
        />

        <label class="m-b-4px">connection</label>
        <input id="discount"
               name="discount_id"
               type="number" placeholder="Enter your discount ..."
        />

        <label class="m-b-4px">connection</label>
        <input id="brandModel"
               name="brand_id"
               type="number" placeholder="Enter your brandModel ..."
        />

        <button type="submit">Submit</button>
    </form>
    -->
</div>