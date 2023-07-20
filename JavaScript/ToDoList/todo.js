const checkcontainer= document.querySelector('.container');
const inputtxt = document.querySelector('#txt');
const addbtn = document.querySelector('#add');

const todo = function(event){
    event.preventDefault();

    let todotxt = inputtxt.value;
    console.log(todotxt);


    const div = document.createElement('div');
    div.className = 'list';
    const box = document.createElement('input');
    box.type = 'checkbox';
   // box.id = 'check';
    const label = document.createElement('label');
    label.innerText = todotxt;
    label.id = 'text';
    div.appendChild(box);
    div.appendChild(label);
    checkcontainer.appendChild(div);
    inputtxt.value = "";

    const remove = function(event){

        event.target.parentNode.remove();

    }

    div.addEventListener('change',remove);
}

addbtn.addEventListener('click',todo);
