function showResult(){
    var answer1 = $("input[name=1]:checked", "#question").val();
    var answer2 = $("input[name=2]:checked", "#question").val();
    var answer3 = $("input[name=3]:checked", "#question").val();
    var answer4 = $("input[name=4]:checked", "#question").val();
    var answer5 = $("input[name=5]:checked", "#question").val();
    var answer6 = $("input[name=6]:checked", "#question").val();
    var answer7 = $("input[name=7]:checked", "#question").val();
    var answer8 = $("input[name=8]:checked", "#question").val();
    var answer9 = $("input[name=9]:checked", "#question").val();
    var answer10 = $("input[name=10]:checked", "#question").val();
    var point = 0;
    if (answer1 == "c"){
        point += 1;
    }
    if (answer2 == "d"){
        point += 1;
    }
    if (answer3 == "b"){
        point += 1;
    }
    if (answer4 == "c"){
        point += 1;
    }
    if (answer5 == "c"){
        point += 1;
    }
    if (answer6 == "d"){
        point += 1;
    }
    if (answer7 == "a"){
        point += 1;
    }
    if (answer8 == "d"){
        point += 1;
    }
    if (answer9 == "a"){
        point += 1;
    }
    if (answer10 == "b"){
        point += 1;
    }
    $("#1cc").text("C. which : Correct answer!");
    $("#2dd").text("D. has been examined : Correct answer!");
    $("#3bb").text("B. since yersterday morning : Correct answer!");
    $("#4cc").text("C. so has his sister : Correct answer!");
    $("#5cc").text("C. Jame didn't either : Correct answer!");
    $("#6dd").text("D. did : Correct answer!");
    $("#7aa").text("A. play than study: Correct answer!");
    $("#8dd").text("D. they will meet : Correct answer!");
    $("#9aa").text("A. mending : Correct answer!");
    $("#10bb").text("B. clean: Correct answer!");
    $("#result").text("You got " + point + " out of 10.");
 
}

$("#submit").on("click", showResult);

function showResult1(){
    var firstanswer = $("#answer1").val();
    var secondanswer = $("#answer2").val();
    if (firstanswer == "ALERT" && secondanswer == "HOWER"){
        $("#result1").text("You got 2 out of 2!");
    }
    else if (firstanswer == "HOWER" && secondanswer == "ALERT"){
        $("#result1").text("You got 2 out of 2!");
    }
    else if (firstanswer == "HOWER" || secondanswer == "ALERT" || 
    secondanswer == "HOWER" || firstanswer == "ALERT"){
        $("#result1").text("You got 1 out of 2!");
    }
    else {
        $("#result1").text("You got 0 out of 2!");
    }
}
$("#submit1").on("click", showResult1);


function showExerciseForm() {
    document.getElementById('exercise-card').style.display = 'none';
    document.getElementById('puzzle-card').style.display = 'none';
    document.getElementById('exercise-form').style.display = 'block';
}

function showPuzzleForm() {
    document.getElementById('exercise-card').style.display = 'none';
    document.getElementById('puzzle-card').style.display = 'none';
    document.getElementById('puzzle-form').style.display = 'block';
}

// Function to go back from exercise form to exercise cards
function goBack() {
document.getElementById('exercise-form').style.display = 'none';
document.getElementById('puzzle-form').style.display = 'none';
document.getElementById('exercise-card').style.display = 'block';
document.getElementById('puzzle-card').style.display = 'block';

// Show the name under each card
document.getElementById('exercise-card-name').style.display = 'block';
document.getElementById('puzzle-card-name').style.display = 'block';
}