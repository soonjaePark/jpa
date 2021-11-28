const _deleteBtn = $('#delete_btn');

//추가
$('form[name=insert_form]').submit((e) => {
    e.preventDefault();

    let $form = $('form[name=insert_form]'),
        url = $form.attr('action');

    var posting = $.post(url, $form.serialize());

    posting.done(function (data) {
        if (data.status) {
            alert("저장되었습니다.");
            insert_modal_bs.hide();
            Init();
        } else {
            alert(data.msg);
        }
    })
})


//삭제
const deleteFunc = (seq) => {
    _deleteBtn.click((e) => {
        console.log("delete button clicked");

        let url = "/list/delete/" + seq;

        let posting = $.post(url);

        posting.done((data) => {
            console.log(data);
            if (data.status) {
                alert("삭제 되었습니다.");
                _detailModal_bs.hide();
                Init();
            }
            else {
                alert("오류", data.msg)
            }

        })

    })

}

//수정
$('form[name=update_form]').submit((e) => {
    e.preventDefault();
    console.log("update button clicked");
    updateFunc();
})

const updateFunc = () => {

    let $form = $('form[name=update_form]'),
        url = $form.attr('action');

    var posting = $.post(url, $form.serialize());
    posting.done(function (data) {
        if (data.status) {
            alert("저장되었습니다");
            _detailModal_bs.hide();
            Init();
        }
        else {
            alert(" ", data.msg)
        }

    })


}
