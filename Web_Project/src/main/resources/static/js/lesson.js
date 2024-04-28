var xhr = new XMLHttpRequest();

xhr.onload = function(){
    if(xhr.status === 200){
        responseObject = JSON.parse(xhr.responseText);
        var image1 = '<img class="image1" src="' + responseObject.data.image[0].img + '">';
        var image4 = '<img class="image1" src="' + responseObject.data.image[3].img + '">';
        var image5 = '<img class="image1" src="' + responseObject.data.image[4].img + '">';
        var image6 = '<img class="image1" src="' + responseObject.data.image[5].img + '">';
    }
    document.getElementById('i1').innerHTML = image1;
    document.getElementById('i4').innerHTML = image4;
    document.getElementById('i5').innerHTML = image5;
    document.getElementById('i6').innerHTML = image6;
}

xhr.open('GET', 'https://api.myjson.online/v1/records/72cff7bc-f8a0-4f50-b066-35039903b973', true);
xhr.send(null);

function showLessonContent(id) {
    var lesson = document.getElementById(id);
    var lessonContent = lesson.innerHTML;
    var lessonContainer = document.getElementById('lesson-content');
    lessonContainer.innerHTML = "<div class='lesson-content'>" + lessonContent + "</div>";
    lessonContainer.innerHTML += "<div id='back-btn' class='back-btn' onclick='showAllLessons()'>Back to All Lessons</div>";
    lessonContainer.scrollIntoView({ behavior: 'smooth', block: 'start' });
    document.querySelectorAll('.lesson-card').forEach(function(card) {
        card.style.display = 'none';
    });
}

function showAllLessons() {
    var lessonContainer = document.getElementById('lesson-content');
    lessonContainer.innerHTML = '';
    document.querySelectorAll('.lesson-card').forEach(function(card) {
        card.style.display = 'block';
    });
    document.getElementById('back-btn').style.display = 'none';
}