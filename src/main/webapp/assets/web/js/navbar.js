function toggleNav() {
    let x = document.getElementById("top-nav")
    if (x.className === "nav") {
        x.className+= " active"
    }
    else {
        x.className = "nav";
    }
}