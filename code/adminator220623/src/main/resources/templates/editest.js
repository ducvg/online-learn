$(document).ready(function() {
  addQuestion();

  function addQuestion() {
    const question =
      '<div class="question-item col-sm-12">\
      <div class="text-right"><button class="btn-remove-question btn btn-primary btn-sm"><span class="glyphicon glyphicon-remove"></span></button></div>\
      <div><label>Question:</label> <input id="user-question" class="form-control" type="text"></div>\
      <div>\
        <label>Choices: </label>\
        <ul class="choice-list">\
          <li class="choice-item">\
            <div class="form-inline"><input class="choice-input form-control" type="text">\
              <label>\
      <input class="answer-input form-control" type="checkbox"> correct answer</label><button class=" remove-choice btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"</button></div>\
          </li>\
 <li class="choice-item">\
            <div class="form-inline"><input class="choice-input form-control" type="text">\
              <label>\
      <input class="answer-input form-control" type="checkbox"> correct answer</label><button class=" remove-choice btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"</button></div>\
          </li>\
        </ul>\
        <button class="add-choice btn btn-default">Add Choice</button>\
      </div>\
    </div>';
    $("#question-wrapper").append(question);
  }
  //add question btn
  $("#add-question").click(addQuestion);

  //remove question btn
  $("body").on("click", ".btn-remove-question", function() {
    if ($(".question-item").length > 1)
      $(this)
        .parents(".question-item")
        .remove();
  });

  //add choice
  $("body").on("click", ".add-choice", function() {
    const choice =
      '<li class="choice-item"><div class="form-inline"><input class="choice-input form-control" type="text">\
              <label> <input class="answer-input form-control" type="checkbox"> correct answer</label><button class=" remove-choice btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"</button></div>\
          </li>';
    $(this)
      .siblings("ul.choice-list")
      .append(choice);
  });
  //remove choice
  $("body").on("click", ".remove-choice", function() {
    if (
      $(this)
        .parents(".question-item")
        .find(".choice-item").length > 2
    )
      $(this)
        .parents("li.choice-item")
        .remove();
  });

  $("#submit-quiz").click(function() {
    if(checkForEmpty()) return;   

    var data = [];
    $(".question-item").each(function(index, question) {
      var obj = {};
      obj.question = {
        en: $(question)
          .find("#user-question")
          .val()
      };
      obj.choices = [];
      obj.answer = [];
      $(question)
        .find(".choice-item")
        .each(function(index, choice) {
          obj.choices.push({
            en: $(choice)
              .find(".choice-input")
              .val()
          });
          if (
            $(choice)
              .find(".answer-input")
              .is(":checked")
          )
            obj.answer.push({
              en: $(choice)
                .find(".choice-input")
                .val()
            });
        });

      data.push(obj);
    });
    $("#results").html(JSON.stringify(data));
  });
  
  function checkForEmpty(){
    var isEmpty = false;
     $('input[type=text]').each(function(i,x){
      if($(x).val().length === 0){
        isEmpty = true
      }
    })
    return isEmpty;
  }
});