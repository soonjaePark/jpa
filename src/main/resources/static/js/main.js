const list_data = $('#st_info');
const add_btn = $('#add_btn');
const delete_btn = $('#deleteBtn');
const insert_modal_bs = new bootstrap.Modal($('#main_modal'));

const _detailModalName = 'detail_modal';
const _detailModal = $('#' + _detailModalName);
const _detailModal_bs = new bootstrap.Modal(_detailModal);

//조회
const search = () => {
    var getting = $.get('/list');

    getting.done(function (data) {
        const _data = data.datalist;
        list_data.innerHTML = '';
        var insertTr = '';
        if (data.status) {
            _data.forEach((item, index) => {
                insertTr += "<tr class='text-center' data-seq='" + item.seq + "'>";
                insertTr += '<th>' + (index + 1) + '</th>'
                insertTr += '<th hidden>' + item.seq + '</th>'
                insertTr += '<th>' + item.user_name + '</th>'
                insertTr += '<th>' + item.department + '</th>'
                insertTr += '<th>' + item.level + '</th>'
                insertTr += '<th>' + item.age + '</th>'
                insertTr += '</tr>'
            })
            list_data.append(insertTr)
        }
        else {
            alert("오류", data.msg);
        }
    })
}

//상세보기
list_data.click('tr', (e) => {
    const _seq = $(e.target.parentNode).data('seq');
    getDetailData(_seq);
    deleteFunc(_seq);
})

const getDetailData = (seq) => {
    let url = "/list/" + seq;

    let getting = $.get(url);

    getting.done((data) => {

        const _data = data.data;
        if (data.status) {
            console.log(data);
            $('#' + _detailModalName + ' input[name=seq]').val(_data.seq);
            $('#' + _detailModalName + ' input[name=user_name]').val(_data.user_name);
            $('#' + _detailModalName + ' input[name=department]').val(_data.department);
            $('#' + _detailModalName + ' select[id=level]').val(_data.level);
            $('#' + _detailModalName + ' input[name=age]').val(_data.age);
            _detailModal_bs.show();
        }
        else {
            alert("오류", msg);
        }
    })
}

//추가버튼 클릭시
const Init = () => {
    list_data.empty();
    search();
}

$(document).ready(function () {
    Init();
})
