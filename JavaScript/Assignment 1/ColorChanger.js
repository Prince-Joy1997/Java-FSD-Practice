const rgbbutton = document.getElementById('rgb')
const hexbutton = document.getElementById('hex')
const rgbtext = document.getElementById('rgbtxt')
const hextext = document.getElementById('hextxt')


const random = function(limit){
    return Math.floor(Math.random()*limit);
}


const rgbfn = function(event){
    const red = random(256);
    const green = random(256);
    const blue = random(256);
    const out =`rgb(${red},${green},${blue})`
    document.body.style.backgroundColor = out;
    hexbutton.style.backgroundColor = out;
    rgbtext.style.color = out;
    
}

const hexfn = function(event){
    const list = "0123456789abcdef";
    let res = "#";
    for( i = 0; i < 6; i++){
        res += list[random(list.length - 1)];
    }
    document.body.style.backgroundColor = res;
    rgbbutton.style.backgroundColor = res;
    hextext.style.color = res;
}

rgbbutton.addEventListener('click',rgbfn);
hexbutton.addEventListener('click',hexfn);
document.addEventListener("DOMContentLoaded",hexfn);