const nextBtn = document.getElementById('nextBtn');
const preBtn = document.getElementById('previous');
const submitBtn = document.getElementById('submitBtn');
const pages = document.getElementsByClassName('pages');
const progress = document.getElementById('progressBar');

submitBtn.disabled = true;
let counter = 0;
progress.style.width = 100 / pages.length + "%";
function showpage(index)
{
    for(let i = 0; i < pages.length; i++)
    {
        pages[i].style.display = "none";

        if(i === index)
        {
            pages[i].style.display = "block";
        }
    }
    progress.style.width = 100 * ((index + 1) / pages.length) + "%";
}

function nextpage()
{
    counter++;
    if(counter >= pages.length)
    {
        counter--;
        return false;
    }
    else
    {
        showpage(counter)
    }
    submitBtn.disabled = false;
}

preBtn.onclick = function()
{
    counter--;
    if(counter < 0)
    {
        counter = 0;
        return false;
    }
    else
    {
        showpage(counter);
    }
    submitBtn.disabled = true;
}

// --------------------------------------validate----------------------------------------------

const showPasswordBtn = document.getElementById('showPassword');
const showConfirmBtn = document.getElementById('showConfirmPassword');
const usernameBox = document.getElementById('usernameBox');
const passwordBox = document.getElementById('passwordBox');
const confirmBox = document.getElementById('confirmBox');
const emailBox = document.getElementById('emailBox');


// show password
function showPassword(btn, boxName)
{
    if(btn.innerHTML === 'Show')
    {
        document.getElementById(boxName).type = 'text';
        btn.innerHTML = 'Hidden';
    }
    else
    {
        document.getElementById(boxName).type = 'password';
        btn.innerHTML = 'Show';
    }
}
showPasswordBtn.onclick = function()
{
    showPassword(showPasswordBtn, 'passwordBox');
}
showConfirmBtn.onclick = function()
{
    showPassword(showConfirmBtn, 'confirmBox');
}

function checkPassword()
{
    const confirmValue = document.getElementById('confirmBox').value;
    const passowrd = document.getElementById('passwordBox').value;
    if(confirmValue !== passowrd)
    {
        document.getElementById('confirmText').innerHTML = 'Two password not match';
        return false;
    }
}
document.getElementById('confirmBox').onfocus = function()
{
    document.getElementById('confirmText').innerHTML = '';
}


function isEmail(str){
    const reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    return reg.test(str);
}

// set next button state
nextBtn.onclick = function()
{
    if(usernameBox.value === '') document.getElementById('usernameText').innerHTML = 'Please input the username';
    if(passwordBox.value === '') document.getElementById('passwordText').innerHTML = 'Please input the password';
    if(confirmBox.value === '') document.getElementById('confirmText').innerHTML = 'Please comfirm your password';
    if(emailBox.value === '') document.getElementById('emailText').innerHTML = 'Please input your email';
    else
    {
        if(checkPassword() === false) return false;
        else if(!isEmail(emailBox.value) && emailBox.value !== '')
        {
            document.getElementById('emailText').innerHTML = 'Email address is uncorrect';
            return false;
        }
        nextpage();
    }
}

usernameBox.onclick = function()
{
    document.getElementById('usernameText').innerHTML = '';
}
passwordBox.onclick = function() {
    document.getElementById('passwordText').innerHTML = '';
}
confirmBox.onclick = function() {
    document.getElementById('confirmText').innerHTML = '';
}
emailBox.onclick = function() {
    document.getElementById('emailText').innerHTML = '';
}

const gender = document.getElementById('gender');
const dob = document.getElementById('flatpickr-tryme');

submitBtn.onclick = function() {
    if(gender.value === 'Choose...') {
        document.getElementById('genderText').innerHTML = 'please select your gender';
        return false;
    }
    if(dob.value === '') {
        document.getElementById('dobText').innerHTML = 'please input your borthday';
        return false;
    }
}

gender.onclick = function() {
    document.getElementById('genderText').innerHTML = '';
}

dob.onclick = function() {
    document.getElementById('dobText').innerHTML = '';
}