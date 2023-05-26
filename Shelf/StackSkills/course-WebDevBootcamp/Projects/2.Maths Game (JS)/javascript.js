var playing = false;
var score;
var action;
var timeremaining;
var correctAnswer;

// if we click on the start/reset
document.getElementById("startreset").onclick =
  function() {
    
    // if we are playing
    if ( playing == true ) {  
      location.reload(); // reload page
    } else { // if we are not playing

      // change mode to playing
      playing = true;
      
      // set score to 0
      score = 0;
      document.getElementById("scorevalue").innerHTML = score;

      // show countdown box
      show("timeremaining");
      timeremaining = 60;
      document.getElementById("timeremainingvalue").innerHTML = timeremaining;

      // hide game over box
      hide("gameOver");
      
      // change button to reset
      document.getElementById("startreset").innerHTML = "Reset Game";

      // start countdown
      startCountdown();

      // generate a new Q&A
      generateQA();
    }
  }
    // if we are playing
        // reload page
    // if we are not playing
        // set score to 0
        // show countdown box
        // reduce time by 1 sec in loops
            // timeleft?
                // yes -> continue
                // no -> gameover
        // change button to reset
        // generate new Q&A

// if we click on answer box
    // if we are playing
        // correct?
            // yes
                // increase score
                // show correct box for 1sec
                // generate new Q&A
            // no
                // show try again box for 1sec


// functions

// start counter
function startCountdown() {
  action = setInterval(function(){
    timeremaining -= 1;
    document.getElementById("timeremainingvalue").innerHTML = timeremaining;
    if ( timeremaining == 0 ) { // game over      
      stopCountdown();
      show("gameOver"); 
      document.getElementById("gameOver").innerHTML =
        "<p>Game over!</p><p>Your score is " + score + ".</p>";
      hide("timeremaining");
      hide("correct");
      hide("wrong");
      playing = false;
      document.getElementById("startreset").innerHTML = "Start Game";
    }
  }, 1000);
}

// stop counter
function stopCountdown() {
  clearInterval(action);
}

// hide an element
function hide(Id) {
  document.getElementById(Id).style.display = "none";
}

// show an element
function show(Id) {
  document.getElementById(Id).style.display = "block";
}

// generate question and multiple answers
function generateQA() {
  var x = 1 + Math.round( 9 * Math.random() );
  var y = 1 + Math.round( 9 * Math.random() );
  correctAnswer = x * y;
  document.getElementById("question").innerHTML =
    x + "x" + y;
  var correctPosition = 1 + Math.round( 3 * Math.random() );
  // fill one box with the correct answer
  document.getElementById("box" + correctPosition).innerHtml = correctAnswer;
  // fill other boxes with wrong answers

  var answers = [correctAnswer];
  
  for(i = 1; i < 5; i++) {
    if (i != correctPosition) {
      var wrongAnswer;

      do {
        wrongAnswer =
          ( 1 + Math.round( 9 * Math.random()  ) )
          * ( 1 + Math.round( 9 * Math.random() ) );
      } while( wrongAnswer == correctAnswer )
      
      document.getElementById("box"+i).innerHTML = wrongAnswer;
    }
  }
}
