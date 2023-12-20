var s_oneOnOne = document.querySelector('.oneOnOne');
var s_faq = document.querySelector('#faq');
var s_customerCenter = document.querySelector('#customerCenter');
s_oneOnOne.addEventListener('mouseenter',function(){
    s_oneOnOne.style.transform = 'scale(1.1)';
});
s_oneOnOne.addEventListener('mouseleave',function(){
    s_oneOnOne.style.transform = 'scale(1)';
});
s_faq.addEventListener('mouseenter',function(){
    s_faq.style.transform = 'scale(1.1)';
});
s_faq.addEventListener('mouseleave',function(){
    s_faq.style.transform = 'scale(1)';
});
s_customerCenter.addEventListener('mouseenter',function(){
    s_customerCenter.style.transform = 'scale(1.1)';
});
s_customerCenter.addEventListener('mouseleave',function(){
    s_customerCenter.style.transform = 'scale(1)';
});

s_oneOnOne.addEventListener('click',function(){
    alert("1:1 문의");
});
s_faq.addEventListener('click',function(){
    alert("FAQ");
});
s_customerCenter.addEventListener('click',function(){
    alert("고객센터");
});
// JavaScript로 토글 메뉴 관리 코드
var dropdownContainer = document.querySelector('.dropdown-container');

var category_toggle = document.getElementById('category_toggle');
var theme_toggle = document.getElementById('theme_toggle');
var new_product_toggle = document.getElementById('new_product_toggle');
var board_toggle = document.getElementById('board_toggle');

var category = document.getElementById('category');
var theme = document.getElementById('theme');
var new_product = document.getElementById('new_product');
var board = document.getElementById('board');
var best = document.getElementById('best');
var interior_challenge = document.getElementById('interior_challenge');
var special_price = document.getElementById('special_price');

var mainImg = document.querySelector('.homePageImg');

var customer = document.querySelector('.customer');
var signUp = document.querySelector('.signUp');
var logIn = document.querySelector('.logIn');
var logOut = document.querySelector('.logOut');
var adminPage = document.querySelector('.adminPage');
var myPage = document.querySelector('.myPage');

mainImg.addEventListener('click',function(){
    if(window.location.href == 'http://localhost:8404/'){
    } else {
        alert(window.location.href);
        window.location.href = '/';
    }

});

customer.addEventListener('click',function(){
    alert('고객센터!');
});
if(signUp!=null) {
    signUp.addEventListener('click', function () {
        window.location.href = "/member/signup";
    });
}
if(logIn!=null) {
    logIn.addEventListener('click', function () {
        window.location.href = "/member/login";
    });
}
if(logOut!=null) {
    logOut.addEventListener('click', function () {
        window.location.href = "/member/logout";
    });
}
if(adminPage!=null){
    adminPage.addEventListener('click',function (){
        window.location.href = '/admin/dashboard';
    });
}
if(myPage!=null){
    myPage.addEventListener('click',function (){
        window.location.href ='/myPage/home'
    })
}

function commonEnterMouseEvent(target){
    if(target === category){       //이 if문 블럭은 메뉴 바가 동시에 출력되는 것을 막는다.
        theme_toggle.style.display = 'none';
    } else if(target === theme){
        category_toggle.style.display = 'none';
        new_product_toggle.style.display = 'none';
    } else if(target === new_product){
        theme_toggle.style.display = 'none';
    }
    target.style.color = 'gray';
    target.style.fontWeight = "bold";
}
function commonLeaveMouseEvent(){
    var list = [category,theme,new_product,best,board,interior_challenge,special_price]
    for(let i =0; i<list.length;i++) {
        list[i].style.color = 'black';
        list[i].style.fontWeight = "normal";
        list[i].style.fontSize = "16px";
    }
}
function commonEvent(e){
    var selectedOption = e.target.getAttribute('data-value');
    var list = [category_toggle,theme_toggle,new_product_toggle,board_toggle]
    for(let i =0; i<list.length;i++) {
        list[i].style.display = 'none';
    }
    var list = e.target.innerText;
    return list;
}

// 마우스가 category 위에 올라갈 때
category.addEventListener('mouseenter', function () {
    dropdownContainer.style.height = '200px';
    category_toggle.style.display = 'block';
    category.style.fontSize = "18px";
    commonEnterMouseEvent(category);
});
// 마우스가 theme 위에 올라갈 때
theme.addEventListener('mouseenter', function () {
    theme_toggle.style.display = 'block';
    theme.style.fontSize = "18px";
    commonEnterMouseEvent(theme);
});
// 마우스가 new_product 위에 올라갈 때
new_product.addEventListener('mouseenter', function () {
    new_product_toggle.style.display = 'block';
    new_product.style.fontSize = "18px";
    commonEnterMouseEvent(new_product);
});
best.addEventListener('mouseenter',function(){
    best.style.fontSize = "18px";
    commonEnterMouseEvent(best);
})
interior_challenge.addEventListener('mouseenter',function(){
    interior_challenge.style.fontSize = "18px";
    commonEnterMouseEvent(interior_challenge);
})
// 마우스가 게시판에 올라갈 때
board.addEventListener('mouseenter', function () {
    board_toggle.style.display = 'block';
    board.style.fontSize = "18px";
    commonEnterMouseEvent(board);
});
special_price.addEventListener('mouseenter',function(){
    special_price.style.fontSize = "18px";
    commonEnterMouseEvent(special_price);
});

// 마우스가 dropdownContainer 바깥으로 나갈 때
dropdownContainer.addEventListener('mouseleave', function () {
    category_toggle.style.display = 'none';
    theme_toggle.style.display = 'none';
    new_product_toggle.style.display = 'none';
    board_toggle.style.display = 'none';
    commonLeaveMouseEvent();
});

category_toggle.addEventListener('click', function (e)
{
    const categoryArray = ['목록1','목록2','목록3','목록4','목록5']
    var list = commonEvent(e);
    if(list === categoryArray[0]){
        alert("카테고리 목록1 Test");
    } else if(list === categoryArray[1]){
        alert("카테고리 목록2 Test");
    } else if(list === categoryArray[2]){
        alert("카테고리 목록3 Test");
    } else if(list === categoryArray[3]){
        alert("카테고리 목록4 Test");
    } else if(list === categoryArray[4]){
        alert("카테고리 목록5 Test");
    } else {
        alert("Error!!");
    }
});
theme_toggle.addEventListener('click', function (e)
{
    const categoryArray = ['목록6','목록7','목록8','목록9','목록10']
    var list = commonEvent(e);
    if(list === categoryArray[0]){
        alert("테마 목록6 Test");
    } else if(list === categoryArray[1]){
        alert("테마 목록7 Test");
    } else if(list === categoryArray[2]){
        alert("테마 목록8 Test");
    } else if(list === categoryArray[3]){
        alert("테마 목록9 Test");
    } else if(list === categoryArray[4]){
        alert("테마 목록10 Test");
    } else {
        alert("Error!!");
    }
});
new_product_toggle.addEventListener('click', function (e)
{
    const categoryArray = ['목록11','목록12','목록13','목록14','목록15']
    var list = commonEvent(e);
    if(list === categoryArray[0]){
        alert("신상품 목록11 Test");
    } else if(list === categoryArray[1]){
        alert("신상품 목록12 Test");
    } else if(list === categoryArray[2]){
        alert("신상품 목록13 Test");
    } else if(list === categoryArray[3]){
        alert("신상품 목록14 Test");
    } else if(list === categoryArray[4]){
        alert("신상품 목록15 Test");
    } else {
        alert("Error!!");
    }
});
best.addEventListener('click',function(){
    alert("베스트 선택.")
});
interior_challenge.addEventListener('click',function(){
    alert("인테리어 첼린지 선택")
});
board_toggle.addEventListener('click', function (e)
{
    const categoryArray = ['공지사항','리뷰 게시판','QnA']
    var list = commonEvent(e);
    if(list === categoryArray[0]){
        window.location.href = '/board/notice/list';
    } else if(list === categoryArray[1]){
        window.location.href = '/board/notice/review';
    } else if(list === categoryArray[2]){
        window.location.href = '/board/review/review';
    } else {
        alert("Error!!");
    }
});
special_price.addEventListener('click',function(){
    alert("특가 선택")
});
//첫 번째 인자 : 요청 URL.
//두 번째 인자 : 전달할 단일 변수.
//세 번째 인자 : 요청 후 수행할 함수(인자가 컨트롤러에서 돌아온 값).
/**
 * 비동기 단일 데이터 요청 함수 모든 인자는 생략 가능
 * @url 1. 요청 URL.
 * @value 2. 컨트롤러로 전달할 단일 변수.
 * @after 3. 요청 후 수행할 함수(인자는 컨트롤러에서 돌아온 값).
 */
function go(url, value,after){
    fetch(url,{
        method: "POST",
        headers:{
            'Content-Type': 'text/plain'
        },
        body: value
    })
        .then(response =>{
            return response.text();
        })
        .then(data => {
            after(data);
        })
        .catch((error) =>{
            alert(error);
        });
}
/**
 * 비동기 객체 데이터 전달 요청 함수.
 * 객체는 data = {key:value,
 *              key2:value2};
 *              의 json 형식으로 줘야한다.
 * @url 1. 요청 URL
 * @object 2. 컨트롤러로 전달할 객체
 * @after 3. 요청 후 수행할 함수(인자는 컨트롤러에서 돌아온 값).
 */
function goObject(url, object, after){
        fetch(url,{
            method: "POST",
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(object)
        })
            .then(response =>{
                return response.text();
            })
            .then(data => {
                if(after){after(data)}
            })
            .catch((error) =>{
                alert(error);
            });
}

