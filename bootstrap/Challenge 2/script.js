const heading = document.getElementById('Name');
const id = document.getElementById('id1');
const firstName = document.getElementById('FirstName');
const lastName = document.getElementById('LastName');
const fullName = document.getElementById('FullName');
const title = document.getElementById('Title');
const family = document.getElementById('Family');
const image = document.getElementById('Image');
const url = document.getElementById('ImgUrl');
const pic = document.getElementById('photo');

const nxt = document.getElementById('next');
const prv = document.getElementById('prev');

let idcount = 0;
const show = (id1) =>{
    fetch('https://thronesapi.com/api/v2/Characters/'+id1)
    .then(response => response.json())
    .then(data => {
        // console.log(data.fullName);
        heading.innerHTML=data.fullName;
        id.innerHTML=data.id;
        firstName.innerHTML=data.firstName;
        lastName.innerHTML=data.lastName;
        fullName.innerHTML=data.fullName;
        title.innerHTML=data.title;
        family.innerHTML=data.family;
        image.innerHTML=data.image;
        url.innerHTML=data.imageUrl;
        pic.src=data.imageUrl;
    })
}

const next = () => {
    idcount++;
    show(idcount);
}

const previous = () => {
    if(idcount<= 0){
        show(0);
    }
    idcount--;
    show(idcount);
}

document.addEventListener('DOMContentLoaded',show(0));

