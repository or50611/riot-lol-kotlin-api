
/* ========== header,footer,snb Include 관련 ========== */
function includeHTML(){
    var includeArea = $('[data-include]');
    var self,url;

    $.each(includeArea, function(){
        self = $(this);
        url = self.data('include');
        self.load(url, function(){
            self.removeAttr('data-include');
        });//load()
    });//each()
}//includeHTML();

/* ============페이지 로딩 완료시============== */
document.addEventListener('DOMContentLoaded',function(){
    // 호출 : header,footer,snb Include 관련
    includeHTML();

    // depth_1 ~ depth_now 이름 바꾸기
    var depth_1 = document.getElementsByClassName('depth_1');
    var depth_2 = document.getElementsByClassName('depth_2');
    var depth_3 = document.getElementsByClassName('depth_3');
    var depth_on = document.getElementsByClassName('depth_on');

    for(var i=0; i<depth_1.length; i++){depth_1[i].innerHTML = depth_1_n;}
    for(var i=0; i<depth_2.length; i++){depth_2[i].innerHTML = depth_2_n;}
    for(var i=0; i<depth_3.length; i++){depth_3[i].innerHTML = depth_3_n;}
    for(var i=0; i<depth_on.length; i++){depth_on[i].innerHTML = depth_on_n;}

/* ============TOP 버튼============== */
$('#btn_toTop').click(function(){
    $('html,body').stop(true).animate({scrollTop:0},300);
});//click

/* ============모달창 닫기============== */ /* 20200915 */
$('.btn_closeModal_g').click(function(){
    $(this).parent().parent('.sect_modal').fadeOut(100);
});//click


});//DOMContentLoaded



