function letterHover(item) {
    $(item).hover(function() {
      $(item + ' a .letter').css("background-color", "#A76F3E");
    }, function() {
      $(item + ' a .letter').css("background-color", "#002242");
    });
  }
  
  letterHover("#a")
  letterHover("#b")
  letterHover("#c")
  letterHover("#d")
  letterHover("#a2")
  letterHover("#b2")
  letterHover("#c2")
  letterHover("#d2")
  
  $("#a").click(function() {
    $('#a').css("background-color", "#2ecc71");
    $('#a p').css("color", "#fff");
  });
  
  $("#b").click(function() {
    $('#b').css("background-color", "#E23F35");
    $('#b p').css("color", "#fff");
  });
  
  $("#c").click(function() {
    $('#c').css("background-color", "#E23F35");
    $('#c p').css("color", "#fff");
  });
  
  $("#d").click(function() {
    $('#d').css("background-color", "#E23F35");
    $('#d p').css("color", "#fff");
  });
  $("#a2").click(function() {
    $('#a2').css("background-color", "#E23F35");
    $('#a2 p').css("color", "#fff");
  });
  
  $("#b2").click(function() {
    $('#b2').css("background-color", "#E23F35");
    $('#b2 p').css("color", "#fff");
  });
  
  $("#c2").click(function() {
    $('#c2').css("background-color", "#2ecc71");
    $('#c2 p').css("color", "#fff");
  });
  
  $("#d2").click(function() {
    $('#d2').css("background-color", "#E23F35");
    $('#d2 p').css("color", "#fff");
  });