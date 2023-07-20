import React from 'react'
import './HappyCrew.css'

function HappyCrew() {
    const[formData,SetformData] = React.useState({
        'firstName':'formData firstName',
        'email': 'formData email',
        'isCargo':true,
        'isCommuter':true,
        'isTouring':true
    })
    function valueChange(event){
        const{name,value,type,checked}=event.target
        SetformData(prevFormData=>{
            return{
                ...prevFormData,
                [name]:type === 'checkbox' ? checked : value
            }
        })
    }
  return (
    <>
    <main classNameName="container">
        <form action="#">
            <h1>Join the Happy Crew</h1>
            <h3>Get weekly ebike tips,news and discounts!</h3>
            <div className="form-group">
                <label value={formData.firstName}>First Name <span className="star">*</span></label>
                <input  className="input"  type="text"  name="firstName" onChange={valueChange}/>
            </div>
            <div className="form-group">
                <label value={formData.email}>Email <span className="star">*</span></label>
                <input className="input" type="email" name="email" id="email" onChange={valueChange} />
            </div>
            <div className="form-group">
                <label>What are you intrested in?</label><br/>
                <input className="checkbox" type="checkbox" name="isCargo" checked={formData.isCargo} onChange={valueChange}/> Cargo<br/>
                <input className="checkbox" type="checkbox" name="isCommuter" checked={formData.isCommuter} onChange={valueChange} /> Commuter<br/>
                <input className="checkbox" type="checkbox" name="isTouring" checked={formData.isTouring} onChange={valueChange}/> Touring<br/>
            </div>
            <div className="form-group">
                <button type="submit"> Subscribe </button>
            </div>
            <hr/>
            <div className="mb-3">
                    <p>{formData.firstName}</p>
                    <p>{formData.email}</p>
                    <p>{formData.isCargo}</p>
                    <p>{formData.isCommuter}</p>
                    <p>{formData.isTouring}</p>
                </div>
        </form>
    </main>
    </>
  )
}

export default HappyCrew