const nextBtn = document.getElementById('nextBtn');
const preBtn = document.getElementById('previous');
const submitBtn = document.getElementById('submitBtn');
const pages = document.getElementsByClassName('pages');
const progress = document.getElementById('progressBar');


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

nextBtn.onclick = function()
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
}


// --------------------------------------validate----------------------------------------------

const showPasswordBtn = document.getElementById('showPassword');
const showConfirmBtn = document.getElementById('showConfirmPassword');
preBtn.disabled=true;
nextBtn.disabled = true;
submitBtn.disabled = true;

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
    if(confirmValue !== passowrd || passowrd === '' || confirmValue === '') return false;
    return true;
}
document.getElementById('confirmBox').onfocus = function()
{
    document.getElementById('confirmTips').innerHTML = '';
}

// set next button state
let userFlag = false;
const userValidate = usernameBox.oninput = function()
{
    userFlag = true;
    enableNext();

}
let emailFlag = false;
const emailValidate = emailBox.oninput = function()
{
    emailFlag = true;
    enableNext();

}

let passwordFlag = false;
const passwordValidate = passwordBox.oninput = function()
{
    if(confirmBox.value === '') return;
    passwordFlag = true;
    enableNext();
}

let confirmFlag = false;
confirmBox.oninput = function()
{
    confirmFlag = checkPassword();
    passwordFlag = checkPassword();
    enableNext();
}

function enableNext()
{
    if(userFlag === true && emailFlag === true && passwordFlag === true && confirmFlag === true)
    {
        nextBtn.disabled = false;
    }
}