function go_dashboard(){
    window.location.href = "/admin/dashboard";
}
function go_product(){
    window.location.href = "/admin/product";
}
function go_order(){
    window.location.href = "/admin/order"
}
function go_statistics(){
    window.location.href = "/admin/statistics"
}
function go_member(){
    window.location.href = "/admin/member"
}
function go_notice(){
    window.location.href = "/admin/notice"
}
function go_event(){
    window.location.href = "/admin/event"
}
function go_coupon(){
    window.location.href = "/admin/coupon"
}
$(document).ready(function(){
    $('.search_icon').click(function(){
        alert('총 검색 아이콘 클릭');
    });
});