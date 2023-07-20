
//import * as cypress from "cypress"


//HOME PAGE
describe('land in home page', ()=>
it('visit the page', () =>{
  cy.visit("/")
})
)

describe('land in home page', ()=>
it('it should land up in home component', () =>{
  cy.url().should('include','home');
})
)

describe('checking header component', ()=>
it('it should have a title', () =>{
  cy.get('title').contains('TopJobs');
})
)

describe('checking header component', ()=>
it('it should have a background color', () =>{
  cy.get('.navbar').should('have.css', 'background-color', 'rgb(31, 42, 56)');
})
)

describe('checking home page', ()=>
it('it should have a text', () =>{
  cy.get('h2').contains('Looking for a Job?');
})
)

describe('checking home component', ()=>
it('it should have an about area', () =>{
  cy.get('#about-area');
  cy.get('.about-title').contains('TopJobs is looking for your future');
})
)

describe('checking home component', ()=>
it('it should have an team area', () =>{
  cy.get('#team-area');
  cy.get('.main-title').contains('Some of our clients');
})
)


describe('checking home component', ()=>
it('it should have an team area', () =>{
  cy.get('#team-area');
  cy.get('.main-title').contains('Some of our clients');
})
)

describe('checking footer component', ()=>
it('it should have a footer area', () =>{
  cy.get('footer');
})
)

//SIGN UP
describe('checking sign up', ()=>{
  it('should sign up into JobSeeker', ()=>{
    loadSignUpPage()
    checkRegisterBtn()
    checkSignupbutton()
    checkLoginLink()
    checkEmployerLink()
    performSignUP()
  })
})

function loadSignUpPage(){
  cy.visit('/signup')
  cy.wait(2000);
}

function checkSignupbutton(){
  cy.get('#registerCard').should('contain','Sign up')
}

function checkRegisterBtn(){
  cy.get('#submitRegisterBtn').should('contain','Sign up')
  cy.wait(2000);
}

function checkLoginLink(){
  cy.get('#loginLink').should('contain','Already a member? Click to Sign in!')
  cy.wait(2000);
}

function checkEmployerLink(){
  cy.get('#employerRegister').should('contain','Are you an Employer? Click here to Sign Up!')
  cy.wait(2000);
}


function performSignUP(){
cy.get('#inputName').type('employeeTEST', {force:true})
cy.get('#inputPassword').type('employeepassword', {force:true})
cy.get('#inputFirstName').type('nameTEST', {force:true})
cy.get('#inputLastName').type('lastTEST', {force:true})
cy.get('#inputEmail').type('employee@test.com', {force:true})
cy.get('#inputPhonenumber').type('11111111111', {force:true})
cy.get('#inputAddress').type('11, 22ave', {force:true})
cy.get('#inputResume').type('XXXXXXXXXXXXXXXXXXXXXXXXXXXXX', {force:true})
cy.get('#submitRegisterBtn').click()
cy.wait(3000);
}


//LOGIN IN
describe('Login', () =>{

 it('should log into job seeker page', ()=>{
loadLoginPage()
verifyLoginPage()
performLogin()
 })
})

function loadLoginPage(){
  cy.visit('/login')
}

function verifyLoginPage(){
cy.get('form').should('be.visible')
}

function performLogin(){
cy.get('#user').type('employeeTEST')
cy.get('#password').type('employeepassword')
cy.get('#submitBtn').click()
}


//JOB SEEKER PAGE
describe('land in jobseeker page', ()=>
it('visit the page', () =>{
  cy.visit("/jobseeker")
})
)

describe('land in jobseeker page', ()=>
it('it should land up in jobseeker component', () =>{
  cy.url().should('include','jobseeker');
})
)

describe('job postings page', () =>
it('should have a card', () =>{
  cy.get(".card").contains('Job Postings');
})
)

describe('job postings page', ()=>
it('it should have a card', () =>{
  cy.get('.card').should('have.css', 'background-color', 'rgb(31, 42, 56)');
  cy.get('.card').should('have.css', 'border-collapse', 'collapse');
  cy.get('.card').should('have.css', 'border', '2px solid rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'color', 'rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'font-size', '18px');
})
)


describe('job postings page', ()=>
it(' should have a mat-checkbox', () =>{
  cy.get('mat-checkbox');
})
)

describe('job postings page', ()=>
it(' should have a mat-label', () =>{
  cy.get('mat-label').should('contain', 'Search...');
})
)


//EMPLOYER PAGE

describe('login company page', () =>
it('perform company signup', () =>{
  cy.visit('/employerregister')
}))

//Signup as a employer

describe('checking sign up', ()=>{
  it('should sign up into JobSeeker', ()=>{
cy.get('#inputName').type('employerTEST', {force:true})
cy.get('#inputPassword').type('employerpassword', {force:true})
cy.get('#inputFirstName').type('nameTEST', {force:true})
cy.get('#inputLastName').type('lastTEST', {force:true})
cy.get('#inputcompanyname').type('lastTEST', {force:true})
cy.get('#inputEmail').type('employee@test.com', {force:true})
cy.get('#inputPhonenumber').type('11111111111', {force:true})
cy.get('#inputAddress').type('11, 22ave', {force:true})
cy.get('#signUpbtn').click()
cy.wait(3000);
  })
})

describe('login company page', () =>
it('perform company login', () =>{
  cy.visit('/login')
}))

//Sign in as a employer (how to select?)
describe('employer page', () =>
it('perform employer login', () =>{
cy.get('#role').click().then(()=>
cy.get('mat-option').contains('Employer').click())


cy.get('#user').type('employerTEST')
cy.get('#password').type('employerpassword')
cy.get('#submitBtn').click()
})
)

describe('login company page', () =>
it('perform company login', () =>{
  cy.visit('/login')
}))

describe('check employer page', () =>
it('load employer page', () =>{
  cy.visit('/employer')
}))

//Go to ADM page
describe('login admin page', () =>
it('perform adim sign in', () =>{
  cy.visit('/login')
    cy.get('#role').click().then(()=>
    cy.get('mat-option').contains('Admin').click())
  cy.get('#user').type('admin')
  cy.get('#password').type('adminpass')
  cy.get('#submitBtn').click()
}))

//Change Employer Status
describe( 'admin page', () =>
it('should change status', () =>{
  cy.get(".btn").last().click();
})
)

//log out admin page
describe( 'admin page', () =>
it('should log out', () =>{
  cy.get("#logout").click();
})
)

//Come back to Employer Page
describe('employer page', () =>
it('perform employer login', () =>{
cy.get('#role').click().then(()=>
cy.get('mat-option').contains('Employer').click())


cy.get('#user').type('employerTEST')
cy.get('#password').type('employerpassword')
cy.get('#submitBtn').click()
})
)

describe('land in employer page', ()=>
it('it should land up in employer component', () =>{
  cy.url().should('include','employer');
})
)

describe('job postings page', () =>
it('should have a card', () =>{
  cy.get(".card").contains('Job List');
})
)

describe('job postings page', ()=>
it('it should have a card', () =>{
  cy.get('.card').should('have.css', 'background-color', 'rgb(31, 42, 56)');
  cy.get('.card').should('have.css', 'border-collapse', 'collapse');
  cy.get('.card').should('have.css', 'border', '2px solid rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'color', 'rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'font-size', '18px');
})
)

describe('check and expand mat empansion panel', ()=>{
  it('it shoud open expansion panel', () =>{
    cy.get('.clsmat').click();
  })
})

describe('job posting page', ()=>
it('check form elements', () =>{
  cy.get('#jobTitle').should('contain', 'Enter Job title');
  cy.get('#jobLocation').should('contain', 'Enter Job location');
  cy.get('#jobDescription').should('contain', 'Enter Job Description');
  cy.get('#jobStatus').should('contain', 'Status');
})
)

describe('job posting page', ()=>
it('should add job using mat expand panel', ()  =>{
  cy.get('.clsmat').click();
  cy.get('#jobTitleinput').type('Developer', {force:true});
  cy.get('#jobLocationinput').type('Toronto', {force:true});
  cy.get('#jobDescriptioninput').type('description',{force:true});

  //select
  cy.get('#jobStatus').click({force: true}).then(()=>
    cy.get('#jobValue').contains('Open').click({force: true}))

  cy.get('#jobBtn').click();
})
)

//log out admin page
describe( 'admin page', () =>
it('should log out', () =>{
  cy.get("#logout").click();
})
)

//ADM
describe('login admin page', () =>
it('perform adim sign in', () =>{
  cy.visit('/login')
    cy.get('#role').click().then(()=>
    cy.get('mat-option').contains('Admin').click())
  cy.get('#user').type('admin')
  cy.get('#password').type('adminpass')
  cy.get('#submitBtn').click()
}))

describe('check employer page', () =>
it('load employer admin page', () =>{
  cy.visit('/employerAdmin')
}))

describe('land in admin page', ()=>
it('it should land up in employer-admin component', () =>{
  cy.url().should('include','employerAdmin');
})
)

describe('employer admin page', () =>
it('should have a card', () =>{
  cy.get(".card").contains('Companies List');
})
)

describe('employer admin page', ()=>
it('it should have a card', () =>{
  cy.get('.card').should('have.css', 'background-color', 'rgb(31, 42, 56)');
  cy.get('.card').should('have.css', 'border-collapse', 'collapse');
  cy.get('.card').should('have.css', 'border', '2px solid rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'color', 'rgb(221, 221, 221)');
  cy.get('.card').should('have.css', 'font-size', '18px');
})
)

describe('employer admin page', ()=>
it('check form elements', () =>{
  cy.get('#company').should('contain', 'Company Name');
  cy.get('#companyfirstname').should('contain', 'First Name');
  cy.get('#companylastname').should('contain', 'Last Name');
  cy.get('#companyemail').should('contain', 'Email');
  cy.get('#companyphone').should('contain', 'Phone No.');
  cy.get('#companyaddress').should('contain', 'Address');
  cy.get('#companystatus').should('contain', 'Status');
})
)

describe('employer admin page', () =>
it('should have a change status button', () =>{
  cy.get(".btn").contains('Change Status');
})
)

describe('employer admin page', () =>
it('status button elements', () =>{
  cy.get('.btn').should('have.css', 'background-color', 'rgb(53, 61, 65)');
  cy.get('.btn').should('have.css', 'text-align', 'right');
  cy.get('.btn').should('have.css', 'margin-right', '10px');
  cy.get('.btn').should('have.css', 'color', 'rgb(255, 255, 255)');
})
)

describe('employer admin page', () =>
it('should have a table', () =>{
  cy.get("table");
})
)

describe('employer admin page', () =>
it('table elements', () =>{
  cy.get('table').should('have.css', 'font-size', '16px');
  cy.get('table').should('have.css', 'font-weight', '400');
  cy.get('table').should('have.css', 'border', '2px solid rgb(221, 221, 221)');
  cy.get('table').should('have.css', 'background-color', 'rgb(255, 255, 255)');
})
)




































