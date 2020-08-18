const showPasswordBtn = document.getElementById('showPassword');
const showConfirmBtn = document.getElementById('showConfirmPassword');

const nextBtn = document.getElementById('nextBtn');
const preBtn = document.getElementById('previous');
const submitBtn = document.getElementById('submitBtn');
preBtn.disabled=true;
nextBtn.disabled = true;
submitBtn.disabled = true;

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
    if(confirmValue !== passowrd) return false;
    return true;
}
document.getElementById('confirmBox').onfocus = function()
{
    document.getElementById('confirmTips').innerHTML = '';
}

submitBtn.onclick = function() 
{
    const passwordFlag = checkPassword();
    if(passwordFlag === false)
    {
        document.getElementById('confirmTips').innerHTML = 'Two password not match';
        return false;
    }
}


// set next button state
function setNextBtn()
{
    if(checkPassword === true) nextBtn.disabled = false;

}
setNextBtn();